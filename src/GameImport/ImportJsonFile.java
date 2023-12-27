package GameImport;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
import Enums.EnumTeam;
import GameLocal.Connector;
import GameLocal.Local;
import GameLocal.Ownership;
import GameLocal.Portal;
import GamePlayer.Player;
import GameLocal.Coordinates;
import GameLocal.Route;
import GameMapa.Mapa;
import GamePlayer.ManagementPlayer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ImportJsonFile {

    /**
     *
     * Imports local elements from a JSON file and adds them to the given Mapa
     * object and ManagementPlayer object.
     *
     * @param mapa the Mapa object to which the imported local elements will be
     * added
     * @param managementPlayers the ManagementPlayer object to which the
     * imported player objects will be added
     * @throws ParseException if there is an error parsing the JSON file
     */
    public void importLocals(Mapa mapa, ManagementPlayer managementPlayers) throws ParseException {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("exemplo.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray locals = (JSONArray) jsonObject.get("locals");
            for (Object local : locals) {
                JSONObject imLocals = (JSONObject) local;
                int id = Integer.parseInt(imLocals.get("id").toString());
                String type = imLocals.get("type").toString();
                JSONObject gameSettings = (JSONObject) imLocals.get("gameSettings");
                JSONObject coordinates = (JSONObject) imLocals.get("coordinates");
                double latitude = Double.parseDouble(coordinates.get("latitude").toString());
                double longitude = Double.parseDouble(coordinates.get("longitude").toString());
                int energy = Integer.parseInt(gameSettings.get("energy").toString());

                Coordinates coord = new Coordinates(latitude, longitude);

                if (type.equals("Portal")) {
                    String name = imLocals.get("name").toString();
                    JSONObject ownership = (JSONObject) gameSettings.get("ownership");

                    String player = ownership.get("player").toString();
                    Portal portal = null;
                    if (managementPlayers.containsPlayer(name)) {
                        Player P = new Player(name);

                        Ownership impOwnership = new Ownership(P);

                        portal = new Portal(energy, name, 150, id, coord);

                    } else {
                        portal = new Portal(energy, name, 150, id, coord);
                    }

                    mapa.addPortal(portal);

                } else if (type.equals("Connector")) {
                    int cooldown = Integer.parseInt(gameSettings.get("cooldown").toString());

                    Connector impConnector = new Connector(energy, cooldown, id, coord);
                    mapa.addConnector(impConnector);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * Imports player data from a JSON file and adds them to a ManagementPlayer
     * object. The JSON file must have a "Players" array containing objects with
     * the following fields: name: String representing the player's name. team:
     * String representing the player's team, either "Giants" or "Sparks".
     * level: Integer representing the player's level. experiencePoints: Integer
     * representing the player's experience points. currentEnergy: Integer
     * representing the player's current energy.
     *
     * @param managementPlayer the ManagementPlayer object to add the players
     * to.
     */
    public void importPlayers(ManagementPlayer managementPlayer) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("exemplo.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray players = (JSONArray) jsonObject.get("Players");
            for (Object player : players) {
                JSONObject impPlayer = (JSONObject) player;

                String name = impPlayer.get("name").toString();
                String team = impPlayer.get("team").toString();
                int level = Integer.parseInt(impPlayer.get("level").toString());
                int experiencePoints = Integer.parseInt(impPlayer.get("experiencePoints").toString());
                int currentEnergy = Integer.parseInt(impPlayer.get("currentEnergy").toString());
                EnumTeam enumT = null;
                if (team.equalsIgnoreCase(EnumTeam.GIANTS.toString())) {
                    enumT = EnumTeam.GIANTS;

                } else if (team.equalsIgnoreCase(EnumTeam.SPARKS.toString())) {
                    enumT = EnumTeam.SPARKS;
                }

                Player newPlayer = new Player(name, level, experiencePoints, currentEnergy, enumT);
                managementPlayer.addPlayer(newPlayer);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * Imports routes from a JSON file and adds them to a given Mapa object. The
     * JSON file must have a "routes" field containing an array of objects, each
     * representing a route with the following fields: "from" - the id of the
     * Local where the route starts "to" - the id of the Local where the route
     * ends "team" - (optional) the team that controls the route ("GIANTS" or
     * "SPARKS") If the "team" field is not present, the route is considered
     * neutral. If the Local objects corresponding to the "from" and "to" ids
     * are found in the given Mapa object, the route is added to the Mapa
     * object. If the "team" field is present and is equal to "GIANTS", the
     * route is also added to the list of routes controlled by the Giants team
     * in the Mapa object. If the "team" field is present and is equal to
     * "SPARKS", the route is also added to the list of routes controlled by the
     * Sparks team in the Mapa object.
     *
     * @param mapa the Mapa object to which the routes will be added
     */

    public void importRoute(Mapa mapa) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("exemplo.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray routes = (JSONArray) jsonObject.get("routes");
            for (Object route : routes) {
                JSONObject impRoute = (JSONObject) route;

                int from = Integer.parseInt(impRoute.get("from").toString());
                Local local1 = mapa.findLocalNetwork(from);

                int to = Integer.parseInt(impRoute.get("to").toString());
                Local local2 = mapa.findLocalNetwork(to);

                try {
                    String team = impRoute.get("team").toString();

                    if (local1 != null && local2 != null) {
                        if (team.equalsIgnoreCase(EnumTeam.GIANTS.toString())) {
                            Route iRoute = new Route(local1, local2);
                            mapa.getRoutesGiants().addToRear(iRoute);

                        } else if (team.equalsIgnoreCase(EnumTeam.SPARKS.toString())) {
                            Route iRoute = new Route(local1, local2);
                            mapa.getRoutesSparks().addToRear(iRoute);
                        }
                        mapa.addRoute(local1, local2);
                    }

                } catch (NullPointerException e) {
                    mapa.addRoute(local1, local2);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}