/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
package Local;

import List.ArrayUnorderedList;
import Exceptions.EmptyCollectionException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import Graph.Network;
import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class ManagementLocal<T> {

    private Network<Local> localNetwork = new Network<>();

    public void addPortal(Portal portal) {
        localNetwork.addVertex(portal);
    }

    public void addConnector(Connector connector) {
        localNetwork.addVertex(connector);
    }

    public void removePortal(Portal portal) throws EmptyCollectionException {
        localNetwork.removeVertex(portal);

    }

    public void removerConnector(Connector connector) throws EmptyCollectionException {
        localNetwork.removeVertex(connector);
    }
    

    public Network<Local> getLocalNetwork() {
        return localNetwork;
    }

    public void setPortalNetwork(Network<Local> portalNetwork) {
        this.localNetwork = portalNetwork;
    }

    public void PrintNumberEdges() {
        System.out.println(localNetwork.size());

    }

    public void setLocalNetwork(Network<Local> localNetwork) {
        this.localNetwork = localNetwork;
    }

    public Connector editConnector(Connector connector, int id, int cooldown, double latitude, double longitude) {
        for (Local oldConnector : localNetwork.getVertices()) {
            if (oldConnector.equals(connector)) {
                oldConnector.getCoordinates().setLatitude(latitude);
                oldConnector.getCoordinates().setLongitude(longitude);
                return (Connector) oldConnector;
            }
        }
        return null;
    }

    public Portal editPortal(Portal portal, String name, int maxEnergy, int energy, double latitude, double longitude) {
        for (Local oldPortal : localNetwork.getVertices()) {
            if (oldPortal.equals(portal)) {
                oldPortal.getCoordinates().setLatitude(latitude);
                oldPortal.getCoordinates().setLongitude(longitude);
                return (Portal) oldPortal;
            }
        }
        return null;
    }

    public Portal findPortalNetwork(int id) {
        Iterator iter = listPortals().iterator();
        while (iter.hasNext()) {
            Portal tempPortal = (Portal) iter.next();
            if (tempPortal.getId() == id) {
                return tempPortal;
            }
        }

        return null;
    }

    public Connector findConnectorNetwork(int id) {
        Iterator iter = listConnectors().iterator();
        while (iter.hasNext()) {
            Connector tempConnector = (Connector) iter.next();
            if (tempConnector.getId() == id) {
                return tempConnector;
            }
        }

        return null;
    }

    public ArrayUnorderedList<Local> listLocals() {
        ArrayUnorderedList<Local> tempLocal = new ArrayUnorderedList<>();
        Network network = this.getLocalNetwork();
        for (int i = 0; i < network.getVertices().length; i++) {
            Object obj = network.getVertices()[i];

            tempLocal.addToRear((Local) obj);

        }

        return tempLocal;
    }

    public Local findLocalNetwork(int id) {
        Iterator iter = listLocals().iterator();
        while (iter.hasNext()) {
            Local tempLocal = (Local) iter.next();
            if (tempLocal.getId() == id) {
                return (Local) tempLocal;
            }
        }

        return null;
    }

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

    public ArrayUnorderedList<Portal> getPortals() {
        ArrayUnorderedList<Portal> tempPortals = listPortals();
        System.out.println("\nPortais: \n");
        for (int i = 0; i < tempPortals.size(); i++) {
            System.out.println("\nNome: " + tempPortals.get(i).getName()
                    + "\nId: " + tempPortals.get(i).getId()
                    + "\nEnergia : " + tempPortals.get(i).getEnergy()
                    + "\nEstado: " + tempPortals.get(i).getState());

        }
        System.out.println(localNetwork.toString());

        return tempPortals;
    }

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

    public ArrayUnorderedList<Connector> getConnectors() {
        ArrayUnorderedList<Connector> tempConnector = listConnectors();

        for (int i = 0; i < tempConnector.size(); i++) {
            System.out.println("Connectores:\nId: " + tempConnector.get(i).getId()
                    + "\nEnergia : " + tempConnector.get(i).getEnergy()
                    + "\nCooldown: " + tempConnector.get(i).getCooldown());

        }

        return tempConnector;
    }

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

}
