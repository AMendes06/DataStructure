package Import;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
import List.ArrayUnorderedList;
import Enum.EnumTeam;
import Local.Connector;
import Local.Local;
import Local.Ownership;
import Local.Portal;
import Player.Player;
import Local.Coordinates;
import Local.ManagementLocal;
import Player.ManagementPlayer;
import Route.ManagementRoute;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ImportJsonFile {

    public void importLocals(ManagementLocal managementLocal, ManagementPlayer managementPlayers) throws ParseException {

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

                    managementLocal.addPortal(portal);

                } else if (type.equals("Connector")) {
                    int cooldown = Integer.parseInt(gameSettings.get("cooldown").toString());

                    Connector impConnector = new Connector(id, cooldown, coord);
                    managementLocal.addConnector(impConnector);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
                if (team.equals(EnumTeam.GIANTS.toString())) {
                    enumT = EnumTeam.GIANTS;

                } else if (team.equals(EnumTeam.SPARKS.toString())) {
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

    public void importRoute(ManagementLocal managementLocal, ManagementRoute managementRoute) {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("exemplo.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray routes = (JSONArray) jsonObject.get("routes");
            for (Object route : routes) {
                JSONObject impRoute = (JSONObject) route;

                int from = Integer.parseInt(impRoute.get("from").toString());
                Local local1 = managementLocal.findLocalNetwork(from);

                int to = Integer.parseInt(impRoute.get("to").toString());
                Local local2 = managementLocal.findLocalNetwork(to);

                if (local1 != null && local2 != null) {
                    managementRoute.addRoute(local1, local2);
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
