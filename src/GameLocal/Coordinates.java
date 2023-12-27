package GameLocal;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Coordinates {

    private double latitude;
    private double Longitude;

    /**
     *
     * Constructs a new Coordinates object with the given latitude and
     * longitude.
     *
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     */
    public Coordinates(double latitude, double Longitude) {
        this.latitude = latitude;
        this.Longitude = Longitude;
    }

    /**
     *
     * Constructs a new, empty Coordinates object.
     */
    public Coordinates() {
    }

    /**
     *
     * Returns the latitude of the location.
     *
     * @return the latitude of the location
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * Sets the latitude of the location.
     *
     * @param latitude the new latitude of the location
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * Returns the longitude of the location.
     *
     * @return the longitude of the location
     */
    public double getLongitude() {
        return Longitude;
    }

    /**
     *
     * Sets the longitude of the location.
     *
     * @param longitude the new longitude of the location
     */
    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

}