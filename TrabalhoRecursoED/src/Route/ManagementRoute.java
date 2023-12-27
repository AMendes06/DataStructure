package Route;

import List.ArrayUnorderedList;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Local.Local;
import Graph.Network;
import Local.Local;
import Local.Portal;
import Player.Player;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class ManagementRoute {

    private Network<Local> localNetwork = new Network<>();

    public ManagementRoute(Network network) {
        this.localNetwork = network;
    }

    public ManagementRoute() {
    }

    public void addRoute(Local local1, Local local2, double weight) {
        localNetwork.addEdge(local1, local2, weight);
    }

    public void addRoute(Local local1, Local local2) {
        localNetwork.addEdge(local1, local2);
    }

    public void removeRoute(Local vertex1, Local vertex2) {
        localNetwork.removeEdge(vertex1, vertex2);
    }

    public Network<Local> getLocalNetwork() {
        return localNetwork;
    }

    public void setLocalNetwork(Network<Local> localNetwork) {
        this.localNetwork = localNetwork;
    }

    public String listRoutes() {
        return this.localNetwork.toString();
    }

    public Iterator<Local> ShortestPath(Local local1, Local local2) {
       Iterator<Local> iterShort = localNetwork.iteratorShortestPath(local1, local2);
       return iterShort;
    }

    public void exportRouteToJson() throws ElementNotFoundException {
        // Create a JSON array to hold the connectors
        JSONArray routesJson = new JSONArray();
        Network<Local> node = this.localNetwork;
        JSONObject routeJson;

        for (int i = 0; i < this.localNetwork.size(); i++) {
            for (int j = 0; j < this.localNetwork.size(); j++) {
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

}
