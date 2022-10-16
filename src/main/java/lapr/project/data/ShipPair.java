package lapr.project.data;

import java.util.Comparator;
import java.util.List;

public class ShipPair {

    private int mmsi1;
    private int mmsi2;
    private double departureDistance;
    private double arrivalDistance;
    private double travelDistance1;
    private double travelDistance2;
    private double travelDistanceDifferential;

    public static void order(List<ShipPair> shipPairList) {
        shipPairList.sort(new Comparator() {
            public int compare(Object o1, Object o2) {
                final Integer mmsi1ShipPair1 = ((ShipPair) o1).getMmsi1();
                final Integer mmsi1ShipPair2 = ((ShipPair) o2).getMmsi1();
                final int mmsiComparison = mmsi1ShipPair1.compareTo(mmsi1ShipPair2);

                if (mmsiComparison != 0) {
                    return mmsiComparison;
                }

                final int reverseToDescending = -1;
                final Double travelDistanceDifferentialShip1 = ((ShipPair) o1).getTravelDistanceDifferential();
                final Double travelDistanceDifferentialShip2 = ((ShipPair) o2).getTravelDistanceDifferential();
                return travelDistanceDifferentialShip1.compareTo(travelDistanceDifferentialShip2) * reverseToDescending;
            }
        });
    }

    public int getMmsi1() {
        return mmsi1;
    }

    public void setMmsi1(int mmsi1) {
        this.mmsi1 = mmsi1;
    }

    public int getMmsi2() {
        return mmsi2;
    }

    public void setMmsi2(int mmsi2) {
        this.mmsi2 = mmsi2;
    }

    public double getDepartureDistance() {
        return departureDistance;
    }

    public void setDepartureDistance(double departureDistance) {
        this.departureDistance = departureDistance;
    }

    public double getArrivalDistance() {
        return arrivalDistance;
    }

    public void setArrivalDistance(double arrivalDistance) {
        this.arrivalDistance = arrivalDistance;
    }

    public double getTravelDistance1() {
        return travelDistance1;
    }

    public void setTravelDistance1(double travelDistance1) {
        this.travelDistance1 = travelDistance1;
    }

    public double getTravelDistance2() {
        return travelDistance2;
    }

    public void setTravelDistance2(double travelDistance2) {
        this.travelDistance2 = travelDistance2;
    }

    public double getTravelDistanceDifferential() {
        return travelDistanceDifferential;
    }

    public void setTravelDistanceDifferential(double travelDistanceDifferential) {
        this.travelDistanceDifferential = travelDistanceDifferential;
    }

    @Override
    public String toString() {
        return "\n\nShipPair{" +
                "\nmmsi1=" + mmsi1 +
                "\n, mmsi2=" + mmsi2 +
                "\n, departureDistance=" + departureDistance +
                "\n, arrivalDistance=" + arrivalDistance +
                "\n, travelDistance1=" + travelDistance1 +
                "\n, travelDistance2=" + travelDistance2 +
                "\n}";
    }
}
