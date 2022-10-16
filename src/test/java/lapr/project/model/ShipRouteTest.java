package lapr.project.model;

import lapr.project.model.Ship.ShipRoute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShipRouteTest {

    @Test
    void setMmsi() {
        ShipRoute shipRoute = new ShipRoute();
        int expected = 2;
        assertNotEquals(expected, shipRoute.getMmsi());
        shipRoute.setMmsi(2);
        assertEquals(expected, shipRoute.getMmsi());
    }

    @Test
    void setDepartureLat() {
        ShipRoute shipRoute = new ShipRoute();
        double expected = 2;
        assertNotEquals(expected, shipRoute.getDepartureLat());
        shipRoute.setDepartureLat(2);
        assertEquals(expected, shipRoute.getDepartureLat());
    }

    @Test
    void setArrivalLat() {
        ShipRoute shipRoute = new ShipRoute();
        double expected = 2;
        assertNotEquals(expected, shipRoute.getArrivalLat());
        shipRoute.setArrivalLat(2);
        assertEquals(expected, shipRoute.getArrivalLat());
    }

    @Test
    void setDepartureLong() {
        ShipRoute shipRoute = new ShipRoute();
        double expected =2;
        assertNotEquals(expected,shipRoute.getDepartureLong());
        shipRoute.setDepartureLong(2);
        assertEquals(expected,shipRoute.getDepartureLong());
    }

    @Test
    void setArrivalLong() {
        ShipRoute shipRoute = new ShipRoute();
        double expected =2;
        assertNotEquals(expected,shipRoute.getArrivalLong());
        shipRoute.setArrivalLong(2);
        assertEquals(expected,shipRoute.getArrivalLong());
    }

    @Test
    void setTravelDistance() {
        ShipRoute shipRoute = new ShipRoute();
        double expected =2;
        assertNotEquals(expected,shipRoute.getTravelDistance());
        shipRoute.setTravelDistance(2);
        assertEquals(expected,shipRoute.getTravelDistance());
    }

    @Test
    void getMmsi() {
        ShipRoute ship = new ShipRoute();
        int mm = 0;
        int result = ship.getMmsi();
        assertEquals(mm,result);
    }

    @Test
    void getDepartureLat() {
        ShipRoute ship = new ShipRoute();
        double d = 0;
        double result = ship.getDepartureLat();
        assertEquals(d,result);
    }

    @Test
    void getArrivalLat() {
        ShipRoute ship = new ShipRoute();
        double d = 0;
        double result = ship.getArrivalLat();
        assertEquals(d,result);
    }

    @Test
    void getDepartureLong() {
        ShipRoute ship = new ShipRoute();
        double y = 0;
        double result = ship.getDepartureLong();
        assertEquals(y,result);
    }

    @Test
    void getArrivalLong() {
        ShipRoute ship = new ShipRoute();
        double p = 0;
        double result = ship.getArrivalLong();
        assertEquals(p,result);
    }

    @Test
    void getTravelDist() {
        ShipRoute ship = new ShipRoute();
        double td = 0;
        double result = ship.getTravelDistance();
        assertEquals(td,result);
    }






}
