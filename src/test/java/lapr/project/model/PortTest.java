package lapr.project.model;

import lapr.project.model.Ports.Port;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PortTest {


    @Test
    void getContinent() throws FileNotFoundException {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String result = port.getContinent();
        String expected = "Europe";
        assertEquals(result, expected);
    }


    @Test
    void getCountry() throws FileNotFoundException {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String result = port.getCountry();
        String expected = "Portugal";
        assertEquals(result, expected);
    }

    @Test
    void getCode() throws FileNotFoundException {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        int result = port.getCode();
        int expected = 500000000;
        assertEquals(result, expected);
    }

    @Test
    void getPort() throws FileNotFoundException {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String result = port.getPort();
        String expected = "Travel";
        assertEquals(result, expected);
    }

    @Test
    void setContinent() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String expected = "Africa";
        assertNotEquals(expected, port.getContinent());
        port.setContinent("Africa");
        assertEquals(expected, port.getContinent());
    }

    @Test
    void setCountry() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String expected = "France";
        assertNotEquals(expected, port.getCountry());
        port.setCountry("France");
        assertEquals(expected, port.getCountry());
    }

    @Test
    void setCode() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        int expected = 5666666;
        assertNotEquals(expected, port.getCode());
        port.setCode(5666666);
        assertEquals(expected, port.getCode());
    }

    @Test
    void setPort() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        String expected = "reel";
        assertNotEquals(expected, port.getPort());
        port.setPort("reel");
        assertEquals(expected, port.getPort());
    }

    @Test
    void setLat() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        Double expected = 555d;
        assertNotEquals(expected, port.getLat());
        port.setLat(555d);
        assertEquals(expected, port.getLat());
    }

    @Test
    void setLon() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        Double expected = 555d;
        assertNotEquals(expected, port.getLon());
        port.setLon(555d);
        assertEquals(expected, port.getLon());
    }

    @Test
    void TestToString() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        port.getContinent();
        port.getCountry();
        port.getCode();
        port.getPort();
        port.getLat();
        port.getLon();
        port.toString();
    }

    @Test
    void equalssTest() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        Port port1 = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        boolean result = port.equals(port1);
        boolean expected = true;
        assertEquals(expected, result);


    }

    @Test
    void notEqualTest() throws FileNotFoundException {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        boolean result = port.equals(shipDynamicFields);
        boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public int hashCode() {
        Port port = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        Port port1 = new Port("Europe", "Portugal", 500000000, "Travel", 55d, 65d);
        assertEquals(port, port1);
        assertTrue(port.hashCode() == port1.hashCode());
return 0 ;

    }
}

















