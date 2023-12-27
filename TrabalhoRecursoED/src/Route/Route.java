package Route;

import List.ArrayUnorderedList;
import Local.Local;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Route {

    private Local from;
    private Local to;
    ArrayUnorderedList<Route> route = new ArrayUnorderedList();

    public Route(Local from, Local to) {
        this.from = from;
        this.to = to;
    }

    public ArrayUnorderedList<Route> getRoute() {
        return route;
    }

    public void setRoute(ArrayUnorderedList<Route> route) {
        this.route = route;
    }

    public Local getFrom() {
        return from;
    }

    public void setFrom(Local from) {
        this.from = from;
    }

    public Local getTo() {
        return to;
    }

    public void setTo(Local to) {
        this.to = to;
    }

}
