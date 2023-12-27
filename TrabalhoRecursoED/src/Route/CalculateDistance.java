package Route;

import Local.Coordinates;

/**
 *
 * @author Angelo
 */
public class CalculateDistance {

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
        System.out.println("Distancia : "+ distance);
        return distance;

    }

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
