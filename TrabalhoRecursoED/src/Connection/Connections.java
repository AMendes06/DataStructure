/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import Exceptions.ElementNotFoundException;
import Graph.Network;
import Local.Connector;
import Local.Local;
import Local.Portal;
import Route.CalculateDistance;

/**
 *
 * @author franc
 */
public class Connections {

    public Connections() {
    }

    public static  connectLocals(int vertice1, int vertice) throws ElementNotFoundException {
        Network<Local> network = region.getNetwork();
        Object obj = network.getVertice(vertice);
        Object obj1 = network.getVertice(vertice1);
        Double weight;
        Portal portalReturned;
        if (obj instanceof Portal portalReturned && obj1 instanceof Portal) {
            portalReturned = (Portal) obj1;
            weight = CalculateDistance.calculateDistanceWithTwoPointsInCoordinates(portalReturned.getCoordinates(), portalReturned.getCoordinates());
            network.addEdge(portalReturned, portalReturned, weight);
        } else {
            Connector conectorReturned1;
            if (obj instanceof Portal portalReturned && obj1 instanceof Connector) {
                conectorReturned1 = (Connector) obj1;
                weight = CalculateDistance.calculateDistanceWithTwoPointsInCoordinates(portalReturned.getCoordinates(), conectorReturned1.getCoordinates());
                network.addEdgeWithTwoTypes(portalReturned, conectorReturned1, weight);
            } else if (obj instanceof Connector conectorReturned && obj1 instanceof Connector) {
                conectorReturned1 = (Connector) obj1;
                weight = CalculateDistance.calculateDistanceWithTwoPointsInCoordinates(conectorReturned1.getCoordinates(), conectorReturned.getCoordinates());
                network.addEdgeWithTwoTypes(conectorReturned1, conectorReturned, weight);
            } else if (obj instanceof Connector conectorReturned && obj1 instanceof Portal) {
                portalReturned = (Portal) obj1;
                weight = CalculateDistance.calculateDistanceWithTwoPointsInCoordinates(portalReturned.getCoordinates(), conectorReturned.getCoordinates());
                network.addEdgeWithTwoTypes(portalReturned, conectorReturned, weight);
            }
        }

        return region;
    }

    public static Region disconnectLocals(Region region, int vertice1, int vertice2) {
        Network<Local> network = region.getNetwork();
        Object obj = network.getVertice(vertice1);
        Object obj1 = network.getVertice(vertice2);
        Portal portalReturned;
        if (obj instanceof Portal portalReturned && obj1 instanceof Portal) {
            portalReturned = (Portal) obj1;
            network.removeEdge(portalReturned, portalReturned);
        } else {
            Connector conectorReturned1;
            if (obj instanceof Portal portalReturned && obj1 instanceof Connector) {
                conectorReturned1 = (Connector) obj1;
                network.removeEdgeWithTwoTypes(portalReturned, conectorReturned1);
            } else if (obj instanceof Connector conectorReturned && obj1 instanceof Connector) {
                conectorReturned1 = (Connector) obj1;
                network.removeEdgeWithTwoTypes(conectorReturned1, conectorReturned);
            } else if (obj instanceof Connector conectorReturned && obj1 instanceof Portal) {
                portalReturned = (Portal) obj1;
                network.removeEdgeWithTwoTypes(portalReturned, conectorReturned);
            }
        }

        return region;
    }
}
