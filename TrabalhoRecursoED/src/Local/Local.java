package Local;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public abstract class Local {

    private int id;
    public Coordinates coordinates;

    public Local(int id, Coordinates coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
