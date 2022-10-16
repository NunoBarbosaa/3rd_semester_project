package lapr.project.utils;

public class GPS {
    public static double distanceBetweenCoordinates(double lat1, double lon1, double lat2, double lon2) {
        double radius = 6371e3;
        double lat1rad = Math.toRadians(lat1);
        double lat2rad = Math.toRadians(lat2);

        double varLat = Math.toRadians(lat2 - lat1);
        double varLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(varLat / 2) * Math.sin(varLat / 2)
                + Math.cos(lat1rad) * Math.cos(lat2rad)
                * Math.sin(varLon / 2) * Math.sin(varLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = radius * c;

        return d;
    }
}
