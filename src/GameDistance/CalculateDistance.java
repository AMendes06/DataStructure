package GameDistance;

import GameLocal.Coordinates;

/**
 *
 * @author Angelo
 */
public class CalculateDistance {

    /**
     *
     * Calculates the distance in meters between two points on Earth given their
     * latitude and longitude coordinates. Uses the Haversine formula and
     * assumes a spherical Earth with radius 6371 km.
     *
     * @param latitude1 The latitude of the first point in degrees
     * @param longitude1 The longitude of the first point in degrees
     * @param latitude2 The latitude of the second point in degrees
     * @param longitude2 The longitude of the second point in degrees
     * @return The distance between the two points in meters, rounded to two
     * decimal places
     */
    public static double calculateDistanceWithTwoPoints(double latitude1, double longitude1, double latitude2, double longitude2) {
        final int R = 6371;
        double distance = 0;
        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = R * c * 1000;
        distance = Math.round(distance * 100.0) / 100.0;
        System.out.println("Distancia : " + distance);
        return distance;

    }

    /**
     *
     * Calculates the distance in meters between two points on Earth using their
     * latitude and longitude coordinates.
     *
     * Uses the Haversine formula and assumes Earth is a perfect sphere.
     *
     * @param latitude1 the latitude of the first point
     *
     * @param longitude1 the longitude of the first point
     *
     * @param coordinate the coordinates of the second point
     *
     * @return the distance between the two points in meters
     */
    public static double calculateDistanceWithTwoPointsInclass(double latitude1, double longitude1, Coordinates coordinate) {
        final int R = 6371;
        double distance = 0;
        double latitude2 = coordinate.getLatitude();
        double longitude2 = coordinate.getLongitude();
        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = R * c * 1000;
        distance = Math.round(distance * 100.0) / 100.0;
        System.out.println("Distancia : " + distance);
        return distance;

    }

    /**
     *
     * Calculates the distance in meters between two geographical coordinates
     * using the Haversine formula.
     *
     * @param coordinate the first coordinate
     *
     * @param coordinate1 the second coordinate
     *
     * @return the distance between the two coordinates in meters
     */
    public static double calculateDistanceWithTwoPointsInCoordinates(Coordinates coordinate, Coordinates coordinate1) {
        final int R = 6371;
        double latitude1 = coordinate.getLatitude();
        double longitude1 = coordinate.getLongitude();

        double distance = 0;
        double latitude2 = coordinate1.getLatitude();
        double longitude2 = coordinate1.getLongitude();
        double latDistance = Math.toRadians(latitude2 - latitude1);
        double lonDistance = Math.toRadians(longitude2 - longitude1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = R * c * 1000;
        distance = Math.round(distance * 100.0) / 100.0;
        System.out.println("Distance : " + distance);
        return distance;

    }
}
