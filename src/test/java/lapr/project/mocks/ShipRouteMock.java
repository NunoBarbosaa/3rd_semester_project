package lapr.project.mocks;

import lapr.project.model.Ship.ShipRoute;

public class ShipRouteMock {
    public static ShipRoute generate(final int mmsi, final double travelDistance) {
        final ShipRoute shipRoute = new ShipRoute();
        shipRoute.setMmsi(mmsi);
        shipRoute.setDepartureLat(Math.random() * 2000);
        shipRoute.setArrivalLat(Math.random() * 2000);
        shipRoute.setDepartureLong(Math.random() * 2000);
        shipRoute.setArrivalLong(Math.random() * 2000);
        shipRoute.setTravelDistance(travelDistance);

        return shipRoute;
    }
}
