package Local;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Coordinates {
    private double latitude;
    private double Longitude;

    public Coordinates(double latitude, double Longitude) {
        this.latitude = latitude;
        this.Longitude = Longitude;
    }

    public Coordinates() {
    }
    

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }
    
    
    
    
}
