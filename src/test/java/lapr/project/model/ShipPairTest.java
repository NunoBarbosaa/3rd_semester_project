package lapr.project.model;

import lapr.project.data.ShipPair;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipPairTest {

    @Test
    void getMmsi1() {
        ShipPair ship = new ShipPair();
        int m = 0;
        int result = ship.getMmsi1();
        assertEquals(m,result);
    }

    @Test
    void getMmsi2() {
        ShipPair ship = new ShipPair();
        int m1 = 0;
        int result = ship.getMmsi2();
        assertEquals(m1,result);
    }

    @Test
    void getDepartureDistance() {
        ShipPair ship = new ShipPair();
        double sp = 0;
        double result = ship.getDepartureDistance();
        assertEquals(sp,result);
    }

    @Test
    void getArrivalDist() {
        ShipPair ship = new ShipPair();
        double ad = 0;
        double result = ship.getArrivalDistance();
        assertEquals(ad,result);
    }

    @Test
    void getTravelDist1() {
        ShipPair ship = new ShipPair();
        double td1 = 0;
        double result = ship.getTravelDistance1();
        assertEquals(td1,result);
    }

    @Test
    void getTravelDist2() {
        ShipPair ship = new ShipPair();
        double td2 = 0;
        double result = ship.getTravelDistance2();
        assertEquals(td2,result);
    }

    @Test
    void setMmsi1() {
        ShipPair shipPair = new ShipPair();
        int expected = 2;
        assertNotEquals(expected, shipPair.getMmsi1());
        shipPair.setMmsi1(2);
        assertEquals(expected, shipPair.getMmsi1());
    }

    @Test
    void setMmsi2() {
        ShipPair shipPair = new ShipPair();
        int expected = 2;
        assertNotEquals(expected, shipPair.getMmsi2());
        shipPair.setMmsi2(2);
        assertEquals(expected, shipPair.getMmsi2());
    }

    @Test
    void setDepartureDistance() {
        ShipPair shipPair = new ShipPair();
        double expected = 2;
        assertNotEquals(expected, shipPair.getDepartureDistance());
        shipPair.setDepartureDistance(2);
        assertEquals(expected, shipPair.getDepartureDistance());
    }

    @Test
    void setArrivalDistance() {
        ShipPair shipPair = new ShipPair();
        double expected = 2;
        assertNotEquals(expected, shipPair.getArrivalDistance());
        shipPair.setArrivalDistance(2);
        assertEquals(expected, shipPair.getArrivalDistance());
    }

    @Test
    void setTD1() {
        ShipPair shipPair = new ShipPair();
        double expected = 0.0;
        assertEquals(expected, shipPair.getTravelDistance1());
        shipPair.setTravelDistance1(0.0);
        assertEquals(expected, shipPair.getTravelDistance1());
    }

    @Test
    void setTD2() {
        ShipPair shipPair = new ShipPair();
        double expected = 0.0;
        assertEquals(expected, shipPair.getTravelDistance2());
        shipPair.setTravelDistance2(0.0);
        assertEquals(expected, shipPair.getTravelDistance2());
    }

    @Test
    void TestToString() {
        ShipPair shipPair = new ShipPair();
        shipPair.getMmsi1();
        shipPair.getMmsi2();
        shipPair.getDepartureDistance();
        shipPair.getArrivalDistance();
        shipPair.getTravelDistance1();
        shipPair.getArrivalDistance();
        shipPair.toString();
    }








}
