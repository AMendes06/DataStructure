package GameLocal;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Route {

    private Local from;
    private Local to;

    /**
     *
     * Creates a new Route between two Locals.
     *
     * @param from the starting Local of the Route
     * @param to the ending Local of the Route
     */

    public Route(Local from, Local to) {
        this.from = from;
        this.to = to;
    }

    /**
     *
     * Returns the starting Local of the Route.
     *
     * @return the starting Local of the Route
     */
    public Local getFrom() {
        return from;
    }

    /**
     *
     * Sets the starting Local of the Route.
     *
     * @param from the starting Local of the Route
     */
    public void setFrom(Local from) {
        this.from = from;
    }

    /**
     *
     * Returns the ending Local of the Route.
     *
     * @return the ending Local of the Route
     */
    public Local getTo() {
        return to;
    }

    /**
     *
     * Sets the ending Local of the Route.
     *
     * @param to the ending Local of the Route
     */
    public void setTo(Local to) {
        this.to = to;
    }
}

