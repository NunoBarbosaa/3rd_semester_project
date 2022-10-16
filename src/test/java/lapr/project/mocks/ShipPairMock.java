package lapr.project.mocks;

import lapr.project.data.ShipPair;

import static java.lang.Math.abs;

public class ShipPairMock {
    public static ShipPair generate(
            final int mmsi1, final int mmsi2, final double travelDistance1, final double travelDistance2
    ) {
        final double travelDistanceDifferential = abs(travelDistance1 - travelDistance2);

        final ShipPair shipPair = new ShipPair();
        shipPair.setMmsi1(mmsi1);
        shipPair.setMmsi2(mmsi2);
        shipPair.setTravelDistance1(travelDistance1);
        shipPair.setTravelDistance2(travelDistance2);
        shipPair.setArrivalDistance(Math.random() * 2000);
        shipPair.setDepartureDistance(Math.random() * 2000);
        shipPair.setTravelDistanceDifferential(travelDistanceDifferential);

        return shipPair;
    }
}
