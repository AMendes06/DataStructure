package GameLocal;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public abstract class Local {

    private int id;
    public Coordinates coordinates;

    /**
     * Constructs a new Local object with the given ID and coordinates.
     *
     * @param id the ID of the location
     * @param coordinates the coordinates of the location
     */
    public Local(int id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    /**
     * Returns the ID of the location.
     *
     * @return the ID of the location
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the location.
     *
     * @param id the new ID of the location
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the coordinates of the location.
     *
     * @return the coordinates of the location
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the coordinates of the location.
     *
     * @param coordinates the new coordinates of the location
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}

