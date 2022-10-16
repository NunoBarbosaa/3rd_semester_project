package lapr.project.model.Ship;


import java.util.Date;
import java.util.List;


public class ShipRoute {

    private int mmsi;
    private double departureLat;
    private double arrivalLat;
    private double departureLong;
    private double arrivalLong;
    private double travelDistance;

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public double getDepartureLat() {
        return departureLat;
    }

    public void setDepartureLat(double departureLat) {
        this.departureLat = departureLat;
    }

    public double getArrivalLat() {
        return arrivalLat;
    }

    public void setArrivalLat(double arrivalLat) {
        this.arrivalLat = arrivalLat;
    }

    public double getDepartureLong() {
        return departureLong;
    }

    public void setDepartureLong(double departureLong) {
        this.departureLong = departureLong;
    }

    public double getArrivalLong() {
        return arrivalLong;
    }

    public void setArrivalLong(double arrivalLong) {
        this.arrivalLong = arrivalLong;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public static ShipRoute calculateShipRouteDetails(List<ShipMovement> shipMovementList){
        final ShipRoute shipRoute = new ShipRoute();

        Date maxDate = new Date(0L);
        Date minDate = new Date(33193569834000L);

        double arrivalLong;
        double arrivalLat;
        double departureLong;
        double departureLat;
        double previousLat = 0L;
        double previousLong = 0L;
        double travelDistance = 0L;

        for (ShipMovement shipMovement : shipMovementList) {
            boolean verifyPreviousLat = (previousLat == 0L);
            boolean verifyPreviousLong = (previousLong == 0L);

            final Date movementDate = shipMovement.getBaseDateTime();

            if(verifyPreviousLat && verifyPreviousLong){
                previousLat = shipMovement.getLat();
                previousLong= shipMovement.getLon();
                shipRoute.setMmsi(shipMovement.getMmsi());
            }
            if (maxDate.before(movementDate)){
                maxDate = movementDate;
                arrivalLat= shipMovement.getLat();
                shipRoute.setArrivalLat(arrivalLat);
                arrivalLong= shipMovement.getLon();
                shipRoute.setArrivalLong(arrivalLong);
            }
            if (minDate.after(movementDate)){
                minDate = movementDate;
                departureLat = shipMovement.getLat();
                shipRoute.setDepartureLat(departureLat);
                departureLong = shipMovement.getLon();
                shipRoute.setDepartureLong(departureLong);
            }

            travelDistance = travelDistance + distance(shipMovement.getLat(), previousLat, shipMovement.getLon(), previousLong);
            previousLat = shipMovement.getLat();
            previousLong= shipMovement.getLon();

        }
        shipRoute.setTravelDistance(travelDistance);
        return shipRoute;
    }

    public static double distance(
            double lat1, double lat2, double lon1, double lon2
    ) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

}
