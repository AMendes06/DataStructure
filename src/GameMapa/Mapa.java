package GameMapa;

import EstruturasList.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import EstruturasGraph.Network;
import GameLocal.Connector;
import GameLocal.Local;
import GameLocal.Portal;
import GameLocal.Route;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Angelo
 */
/**
 * The Mapa class represents the game map, which is a network of interconnected
 * locations and portals. It also includes lists of routes available to the
 * Giants and Sparks teams respectively.
 */
public class Mapa {

    /**
     * The routes taken by the Giants team on the map.
     */
    ArrayUnorderedList<Route> routesGiants = new ArrayUnorderedList<>();
    /**
     * The routes taken by the Sparks team on the map.
     */
    ArrayUnorderedList<Route> routesSparks = new ArrayUnorderedList<>();

    /**
     * The network representing the map.
     */
    private Network<Local> mapa = new Network<>();

    /**
     * Adds a portal to the map.
     *
     * @param portal the portal to be added
     */
    public void addPortal(Portal portal) {
        mapa.addVertex(portal);
    }

    /**
     * Adds a connector to the network map.
     *
     * @param connector the connector to add
     */
    public void addConnector(Connector connector) {
        mapa.addVertex(connector);
    }

    /**
     * Removes a portal from the network map.
     *
     * @param portal the portal to remove
     * @throws EmptyCollectionException if the network map is empty
     */
    public void removePortal(Portal portal) throws EmptyCollectionException {
        mapa.removeVertex(portal);

    }

    /**
     * Removes a connector from the network map.
     *
     * @param connector the connector to remove
     * @throws EmptyCollectionException if the network map is empty
     */
    public void removerConnector(Connector connector) throws EmptyCollectionException {
        mapa.removeVertex(connector);
    }

    /**
     * Returns the local network map.
     *
     * @return the local network map
     */
    public Network<Local> getLocalNetwork() {
        return mapa;
    }

    /**
     * Sets the current portal network to the given network.
     *
     * @param portalNetwork the new portal network to set
     */
    public void setPortalNetwork(Network<Local> portalNetwork) {
        this.mapa = portalNetwork;
    }

    /**
     * Prints the number of edges in the current network.
     *
     */
    public void PrintNumberEdges() {
        System.out.println(mapa.size());

    }

    /**
     * Sets the current local network to the given network.
     *
     * @param localNetwork the new local network to set
     */
    public void setLocalNetwork(Network<Local> localNetwork) {
        this.mapa = localNetwork;
    }

    /**
     *
     * Edits a connector in the network, given its id and new attributes.
     *
     * @param connector the connector to be edited
     * @param id the new id of the connector
     * @param energy the new energy of the connector
     * @param cooldown the new cooldown of the connector
     * @param latitude the new latitude of the connector's location
     * @param longitude the new longitude of the connector's location
     * @return the edited connector, or null if a connector with the given id
     * was not found in the network
     */
    public Connector editConnector(Connector connector, int id, int energy, int cooldown, double latitude, double longitude) {
        ArrayUnorderedList<Connector> tempConnector = listConnectors();
        for (Connector oldConnector : tempConnector) {
            if (oldConnector.getId() == id) {
                oldConnector.setCooldown(cooldown);
                oldConnector.setEnergy(id);
                oldConnector.getCoordinates().setLatitude(latitude);
                oldConnector.getCoordinates().setLongitude(longitude);

                return oldConnector;
            }
        }
        System.out.println("Nao Existe Connector com o id: " + id);
        return null;
    }

    /**
     *
     * Edits a portal's properties given its id, new name, max energy, current
     * energy, and coordinates
     *
     * @param portal The portal to edit
     * @param id The id of the portal to be edited
     * @param name The new name of the portal
     * @param maxEnergy The new max energy of the portal
     * @param energy The new current energy of the portal
     * @param latitude The new latitude coordinate of the portal
     * @param longitude The new longitude coordinate of the portal
     * @return The edited portal if it exists, otherwise null
     */
    public Portal editPortal(Portal portal, int id, String name, int maxEnergy, int energy, double latitude, double longitude) {
        ArrayUnorderedList<Portal> tempPortal = listPortals();
        for (Portal oldPortal : tempPortal) {
            if (oldPortal.getId() == id) {
                oldPortal.setName(name);
                oldPortal.setMaxEnergy(maxEnergy);
                oldPortal.setEnergy(energy);
                oldPortal.getCoordinates().setLatitude(latitude);
                oldPortal.getCoordinates().setLongitude(longitude);

                return oldPortal;
            }
        }
        System.out.println("Nao Existe Portal com o id: " + id);
        return null;
    }

    /**
     *
     * Finds a portal in the portal network by its ID.
     *
     * @param id the ID of the portal to find
     * @return the portal with the specified ID, or null if no portal with that
     * ID is found
     */
    public Portal findPortalNetwork(int id) {
        Iterator iter = listPortals().iterator();
        while (iter.hasNext()) {
            Portal tempPortal = (Portal) iter.next();
            if (tempPortal.getId() == id) {
                return tempPortal;
            }
        }
        System.out.println("Portal não existe!");
        return null;
    }

    /**
     * Searches for the Connector with the given ID in the network.
     *
     * @param id the ID of the Connector to search for
     * @return the Connector with the given ID, or null if no Connector with
     * that ID is found
     */
    public Connector findConnectorNetwork(int id) {
        Iterator iter = listConnectors().iterator();
        while (iter.hasNext()) {
            Connector tempConnector = (Connector) iter.next();
            if (tempConnector.getId() == id) {
                return tempConnector;
            }
        }
        System.out.println("Portal não Existe!");
        return null;
    }

    /**
     * Returns an unordered list of all the local objects (Portals and
     * Connectors) in the network.
     *
     * @return an ArrayUnorderedList containing all the local objects in the
     * network
     */
    public ArrayUnorderedList<Local> listLocals() {
        ArrayUnorderedList<Local> tempLocal = new ArrayUnorderedList<>();
        Network network = this.getLocalNetwork();
        for (int i = 0; i < network.getVertices().length; i++) {
            Object obj = network.getVertices()[i];

            tempLocal.addToRear((Local) obj);

        }

        return tempLocal;
    }

    /**
     * Finds the Local object with the given id in the local network.
     *
     * @param id the id of the local object to find
     * @return the local object with the given id, or null if it doesn't exist
     * in the network
     */
    public Local findLocalNetwork(int id) {
        Iterator iter = listLocals().iterator();
        while (iter.hasNext()) {
            Local tempLocal = (Local) iter.next();
            if (tempLocal.getId() == id) {
                return (Local) tempLocal;
            }
        }
        System.out.println("Local não existe!");
        return null;

    }

    /**
     * Returns an unordered list of all connectors in the local network.
     *
     * @return an unordered list of all connectors in the local network
     */
    public ArrayUnorderedList<Connector> listConnectors() {
        ArrayUnorderedList<Connector> tempConnector = new ArrayUnorderedList<Connector>();
        Network network = this.getLocalNetwork();
        for (int i = 0; i < network.getVertices().length; i++) {
            Object obj = network.getVertices()[i];

            if (obj instanceof Connector) {
                tempConnector.addToRear((Connector) obj);

            }
        }

        return tempConnector;

    }

    /**
     *
     * Returns a list of all portals, including their attributes like name, id,
     * ownership, energy, team and state. If a portal is owned by a player, the
     * owner's name is included.
     *
     * @return a list of all portals and their attributes
     */
    public ArrayUnorderedList<Portal> getPortals() {
        ArrayUnorderedList<Portal> tempPortals = listPortals();

        System.out.println("\nPortais: \n");
        for (int i = 0; i < tempPortals.size(); i++) {
            String owner = null;
            if (tempPortals.get(i).getOwnership() != null) {
                if (tempPortals.get(i).getOwnership().getPlayer() != null) {
                    owner = tempPortals.get(i).getOwnership().getPlayer().getName();
                }

            }
            System.out.println("\nNome: " + tempPortals.get(i).getName()
                    + "\nId: " + tempPortals.get(i).getId()
                    + "\nOwnership: " + owner
                    + "\nEnergia : " + tempPortals.get(i).getEnergy()
                    + "\nTeam: " + tempPortals.get(i).getTeam()
                    + "\nEstado: " + tempPortals.get(i).getState());
        }

        return tempPortals;
    }

    /**
     * Returns an ArrayUnorderedList of all the Portal objects in the
     * LocalNetwork.
     *
     * @return ArrayUnorderedList of all the Portal objects in the LocalNetwork.
     */
    public ArrayUnorderedList<Portal> listPortals() {
        ArrayUnorderedList<Portal> tempPortals = new ArrayUnorderedList<Portal>();
        Network network = this.getLocalNetwork();
        for (int i = 0; i < network.getVertices().length; i++) {
            Object obj = network.getVertices()[i];

            if (obj instanceof Portal) {
                tempPortals.addToRear((Portal) obj);

            }
        }

        return tempPortals;
    }

    /**
     * Returns a list of all connectors in the network and prints some
     * information about each connector to the console.
     *
     * @return a list of all connectors in the network
     */
    public ArrayUnorderedList<Connector> getConnectors() {
        ArrayUnorderedList<Connector> tempConnector = listConnectors();

        for (int i = 0; i < tempConnector.size(); i++) {
            System.out.println("Connectores:\nId: " + tempConnector.get(i).getId()
                    + "\nEnergia : " + tempConnector.get(i).getEnergy()
                    + "\nCooldown: " + tempConnector.get(i).getCooldown()
                    + "\n Com mina: " + tempConnector.get(i).isMina());

        }

        return tempConnector;
    }

    /**
     *
     * Assigns mines to a percentage of the connectors in the local network. The
     * number of mines is set to be 25% of the total number of connectors,
     * rounded up to the nearest integer. If the current number of connectors
     * with mines is less than the calculated number of mines, new mines are
     * assigned to random connectors.
     */
    public void atribuirMinas() {
        ArrayUnorderedList<Connector> tempConnector = listConnectors();
        int numberMinas = (int) Math.ceil(tempConnector.size() / 4.0);
        int count = 0;
        for (Connector connec : tempConnector) {
            if (connec.isMina()) {
                count++;
            }
        }
        for (int i = count; i < numberMinas; i++) {
            Connector connector = getRandomConnector();
            connector.setMina(true);
        }
    }

    /**
     * Returns a random connector from the list of connectors.
     *
     * @return a random connector from the list of connectors
     */
    private Connector getRandomConnector() {
        Random rand = new Random();
        ArrayUnorderedList<Connector> tempConnectors = listConnectors();
        int randomIndex = rand.nextInt(tempConnectors.size());
        return tempConnectors.get(randomIndex);
    }

    /**
     *
     * Export the list of portals to a JSON file named "ExportPortals.json". For
     * each portal, its name, state, energy, maximum energy, ownership, team,
     * and coordinates (latitude and longitude) are included in the JSON object.
     * If the export fails, a message is printed to the console.
     */
    public void exportPortalsToJson() {
        // Create a JSON array to hold the portals
        JSONArray portalsJson = new JSONArray();

        // Iterate over all portals and add them to the JSON array
        ArrayUnorderedList<Portal> portalList = listPortals();
        for (Portal portal : portalList) {
            JSONObject portalJson = new JSONObject();
            portalJson.put("name :", portal.getName());
            portalJson.put("state: ", portal.getState());
            portalJson.put("energy: ", portal.getEnergy());
            portalJson.put("maxEnergy: ", portal.getMaxEnergy());
            portalJson.put("ownership: ", portal.getOwnership());
            portalJson.put("team: ", portal.getTeam());
            portalJson.put("latitude: ", portal.coordinates.getLatitude());
            portalJson.put("longitude: ", portal.coordinates.getLongitude());
            portalsJson.add(portalJson);
        }

        // Write the JSON array to a file
        try (FileWriter file = new FileWriter("ExportPortals.json")) {
            file.write(portalsJson.toJSONString());
        } catch (IOException e) {
            System.out.println("Erro ao guardar o ficheiro!");
        }
    }

    /**
     * Export the list of connectors to a JSON file.
     *
     * The method creates a JSON array to hold the connectors and iterates over
     * all the connectors in the list, adding them to the JSON array. The JSON
     * array is then written to a file.
     *
     * @throws IOException if there is an error writing to the file
     */
    public void exportConnectorsToJson() {
        // Create a JSON array to hold the connectors
        JSONArray connectorsJson = new JSONArray();

        // Iterate over all connectors and add them to the JSON array
        ArrayUnorderedList<Connector> connectorList = listConnectors();
        for (Connector connector : connectorList) {
            JSONObject connectorJson = new JSONObject();
            connectorJson.put("id: ", connector.getId());
            connectorJson.put("Energy: ", connector.getEnergy());
            connectorJson.put("Cooldown: ", connector.getCooldown());
            connectorJson.put("Latitude", connector.getCoordinates().getLatitude());
            connectorJson.put("Longitude: ", connector.getCoordinates().getLongitude());
            connectorsJson.add(connectorJson);
        }

        // Write the JSON array to a file
        try (FileWriter file = new FileWriter("ExportConnector.json")) {
            file.write(connectorsJson.toJSONString());
        } catch (IOException e) {
            System.out.println("Erro ao guardar o ficheiro!");
        }
    }

    /**
     * Returns the network representing the map.
     *
     * @return the network representing the map
     */
    public Network<Local> getMapa() {
        return mapa;
    }

    /**
     * Sets the network representing the map.
     *
     * @param mapa the network representing the map
     */
    public void setMapa(Network<Local> mapa) {
        this.mapa = mapa;
    }

    /**
     * //Rotas
     *
     */
    /**
     * Adds a route between two locals in the map with the specified weight.
     *
     * @param local1 the starting point of the route
     * @param local2 the end point of the route
     * @param weight the weight of the route
     */
    public void addRoute(Local local1, Local local2, double weight) {
        mapa.addEdge(local1, local2, weight);
    }

    /**
     * Adds an unweighted route between two locals in the map.
     *
     * @param local1 the starting point of the route
     * @param local2 the end point of the route
     */
    public void addRoute(Local local1, Local local2) {
        mapa.addEdge(local1, local2);
    }

    /**
     * Removes the route between the two specified locals in the map.
     *
     * @param vertex1 one of the two locals defining the route
     * @param vertex2 one of the two locals defining the route
     */
    public void removeRoute(Local vertex1, Local vertex2) {
        mapa.removeEdge(vertex1, vertex2);
    }

    /**
     * Returns a string representation of all the routes in the map.
     *
     * @return a string representation of all the routes in the map
     */
    public String listRoutes() {
        return this.mapa.toString();
    }

    /**
     * Returns an iterator that iterates over the vertices of the shortest path
     * between two given vertices.
     *
     * @param local1 the first vertex
     * @param local2 the second vertex
     * @return an iterator that iterates over the vertices of the shortest path
     * between local1 and local2
     */
    public Iterator<Local> ShortestPath(Local local1, Local local2) {
        Iterator<Local> iterShort = mapa.iteratorShortestPath(local1, local2);
        return iterShort;
    }

    /**
     *
     * Exports the route data to a JSON file.
     *
     * Creates a JSON array to hold the connectors and iterates over the
     * network's vertices to create a JSON object for each
     *
     * connected pair, adding it to the array. Finally, the array is written to
     * a file named "ExportRoutes.json" in the working directory.
     *
     * @throws ElementNotFoundException if the source or destination vertex is
     * not found in the network
     *
     * @throws IOException if there is an error writing to the output file
     */
    public void exportRouteToJson() throws ElementNotFoundException {
        // Create a JSON array to hold the connectors
        JSONArray routesJson = new JSONArray();
        Network<Local> node = this.mapa;
        JSONObject routeJson;

        for (int i = 0; i < this.mapa.size(); i++) {
            for (int j = 0; j < this.mapa.size(); j++) {
                if (node.areConnected(i, j)) {
                    routeJson = new JSONObject();
                    routeJson.put("from: ", node.getVertices()[i].getId());
                    routeJson.put("to: ", node.getVertices()[j].getId());
                    routesJson.add(routeJson);
                    System.out.println("true");
                }
            }

        }
        System.out.println("false!");

        // Write the JSON array to a file
        try (FileWriter file = new FileWriter("ExportRoutes.json")) {
            file.write(routesJson.toJSONString());
        } catch (IOException e) {
            System.out.println("Erro ao guardar o ficheiro!");
        }
    }

    /**
     *
     * This class represents a game system that manages routes for two different
     *
     * teams. Each team has its own list of routes, which can be accessed and
     *
     * modified using the corresponding getter and setter methods.
     */
    public ArrayUnorderedList<Route> getRoutesGiants() {
        return routesGiants;
    }

    /**
     *
     * Sets the routes for the Giants team to the specified list.
     *
     * @param routesGiants the new list of routes for the Giants team
     */
    public void setRoutesGiants(ArrayUnorderedList<Route> routesGiants) {
        this.routesGiants = routesGiants;
    }

    /**
     *
     * Returns the list of routes of the Sparks team.
     *
     * @return the list of routes of the Sparks team
     */
    public ArrayUnorderedList<Route> getRoutesSparks() {
        return routesSparks;
    }

    /**
     *
     * Sets the ArrayUnorderedList of Route objects for the team Sparks.
     *
     * @param routesSparks the ArrayUnorderedList of Route objects for the team
     * Sparks
     */
    public void setRoutesSparks(ArrayUnorderedList<Route> routesSparks) {
        this.routesSparks = routesSparks;
    }

}
