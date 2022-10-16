package lapr.project.model;

import lapr.project.model.Ship.ShipMovement;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShipMovementTest {

    @Test
    void getMmsi() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        int mm = 0;
        int result = shipMovement.getMmsi();
        assertEquals(mm, result);
    }

    @Test
    void getBaseDateTime() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        Date date = null;
        Date result = shipMovement.getBaseDateTime();
        assertEquals(null, result);
    }

    @Test
    void getLat() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        double lat = 0;
        double result = shipMovement.getLat();
        assertEquals(lat, result);
    }

    @Test
    void getLong() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        double lon = 0;
        double result = shipMovement.getLon();
        assertEquals(lon, result);
    }

    @Test
    void getSog() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        double sog = 0;
        double result = shipMovement.getSog();
        assertEquals(sog, result);
    }

    @Test
    void getCog() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        double cog = 0;
        double result = shipMovement.getCog();
        assertEquals(cog, result);
    }

    @Test
    void getHeading() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        int heading = 0;
        int result = shipMovement.getHeading();
        assertEquals(heading, result);
    }

    @Test
    void getVesselName() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        String vn = null;
        String result = shipMovement.getVesselName();
        assertEquals(vn, result);
    }


    @Test
    void getImo() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        String IMO = null;
        String result = shipMovement.getImo();
        assertEquals(IMO, result);
    }

    @Test
    void getCallSign() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        String cs = null;
        String result = shipMovement.getCallSign();
        assertEquals(cs, result);
    }


    @Test
    void getVesselType() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        int hh = 0;
        int result = shipMovement.getVesselType();
        assertEquals(hh, result);
    }


    @Test
    void getLenght() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        int u = 0;
        int result = shipMovement.getLength();
        assertEquals(u, result);
    }

    @Test
    void getWidth() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        int a = 0;
        int result = shipMovement.getWidth();
        assertEquals(a, result);
    }

    @Test
    void getDraft() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        float f = 0f;
        float result = shipMovement.getDraft();
        assertEquals(f, result);
    }

    @Test
    void getCargo() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        String s = null;
        String result = shipMovement.getCargo();
        assertEquals(s, result);
    }

    @Test
    void getTransceiverClass() throws FileNotFoundException {
        ShipMovement shipMovement = new ShipMovement();
        String tc = null;
        String result = shipMovement.getTransceiverClass();
        assertEquals(tc, result);
    }


    @Test
    void setMmsi() {
        ShipMovement shipMovement = new ShipMovement();
        int expected = 1;
        assertNotEquals(expected,shipMovement.getMmsi());
        shipMovement.setMmsi(1);
        assertEquals(expected,shipMovement.getMmsi());
    }

    @Test
    void setBaseDateTime() {
        ShipMovement shipMovement = new ShipMovement();
        Date expected = null;
        assertEquals(expected,shipMovement.getBaseDateTime());
        shipMovement.setBaseDateTime(null);
        assertEquals(null,shipMovement.getBaseDateTime());
    }

    @Test
    void setLat() {
        ShipMovement shipMovement = new ShipMovement();
        double expected = 1;
        assertNotEquals(expected,shipMovement.getLat());
        shipMovement.setLat(1);
        assertEquals(expected,shipMovement.getLat());
    }

    @Test
    void setLon() {
        ShipMovement shipMovement = new ShipMovement();
        double expected = 1;
        assertNotEquals(expected,shipMovement.getLon());
        shipMovement.setLon(1);
        assertEquals(expected,shipMovement.getLon());
    }

    @Test
    void setSog() {
        ShipMovement shipMovement = new ShipMovement();
        double expected = 1;
        assertNotEquals(expected,shipMovement.getSog());
        shipMovement.setSog(1);
        assertEquals(expected,shipMovement.getSog());
    }

    @Test
    void setCog() {
        ShipMovement shipMovement = new ShipMovement();
        double expected = 1;
        assertNotEquals(expected,shipMovement.getCog());
        shipMovement.setCog(1);
        assertEquals(expected,shipMovement.getCog());
    }

    @Test
    void setHeading() {
        ShipMovement shipMovement = new ShipMovement();
        int expected = 1;
        assertNotEquals(expected,shipMovement.getHeading());
        shipMovement.setHeading(1);
        assertEquals(expected,shipMovement.getHeading());
    }

    @Test
    void setVesselName() {
        ShipMovement shipMovement = new ShipMovement();
        String expected =null;
        assertEquals(expected,shipMovement.getVesselName());
        shipMovement.setVesselName(null);
        assertEquals(expected,shipMovement.getVesselName());
    }

    @Test
    void setImo() {
        ShipMovement shipMovement = new ShipMovement();
        String expected =null;
        assertEquals(expected,shipMovement.getImo());
        shipMovement.setImo(null);
        assertEquals(expected,shipMovement.getImo());
    }

    @Test
    void setCallSign() {
        ShipMovement shipMovement = new ShipMovement();
        String expected =null;
        assertEquals(expected,shipMovement.getCallSign());
        shipMovement.setCallSign(null);
        assertEquals(expected,shipMovement.getCallSign());
    }

    @Test
    void setVesselType() {
        ShipMovement shipMovement = new ShipMovement();
        int expected =9;
        assertNotEquals(expected,shipMovement.getVesselType());
        shipMovement.setVesselType(9);
        assertEquals(expected,shipMovement.getVesselType());
    }

    @Test
    void setLenght() {
        ShipMovement shipMovement = new ShipMovement();
        int expected =8;
        assertNotEquals(expected,shipMovement.getLength());
        shipMovement.setLength(8);
        assertEquals(expected,shipMovement.getLength());
    }

    @Test
    void setWidth() {
        ShipMovement shipMovement = new ShipMovement();
        int expected =5;
        assertNotEquals(expected,shipMovement.getWidth());
        shipMovement.setWidth(5);
        assertEquals(expected,shipMovement.getWidth());
    }

    @Test
    void setDraft() {
        ShipMovement shipMovement = new ShipMovement();
        float expected =6f;
        assertNotEquals(expected,shipMovement.getDraft());
        shipMovement.setDraft(6f);
        assertEquals(expected,shipMovement.getDraft());
    }

    @Test
    void setCargo() {
        ShipMovement shipMovement = new ShipMovement();
        String expected =null;
        assertEquals(expected,shipMovement.getCargo());
        shipMovement.setCargo(null);
        assertEquals(expected,shipMovement.getCargo());
    }

    @Test
    void setTransceiverClass() {
        ShipMovement shipMovement = new ShipMovement();
        String expected =null;
        assertEquals(expected,shipMovement.getTransceiverClass());
        shipMovement.setTransceiverClass(null);
        assertEquals(expected,shipMovement.getTransceiverClass());
    }


















}
