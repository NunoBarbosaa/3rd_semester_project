package lapr.project.model;

import lapr.project.model.Ports.Port;
import lapr.project.model.SeaDist.SeaDist;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SeadistTest {

    @Test
    void getfCountry() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.getfCountry();
        String expected = "Portugal";
        assertEquals(result, expected);
    }

    @Test
    void getfPortId() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.getfPortId();
        String expected = "tres";
        assertEquals(result, expected);
    }

    @Test
    void getfPort() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.getfPort();
        String expected = "port";
        assertEquals(result, expected);
    }

    @Test
    void gettCountry() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.gettCountry();
        String expected = "Spain";
        assertEquals(result, expected);

    }

    @Test
    void gettPortId() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.gettPortId();
        String expected = "one";
        assertEquals(result, expected);

    }

    @Test
    void gettPort() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String result = seaDist.gettPort();
        String expected = "gg";
        assertEquals(result, expected);

    }

    @Test
    void getdist() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        int result = seaDist.getDist();
        int expected = 55;
        assertEquals(result, expected);

    }

    @Test
    void setfCountry() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "Portugal";
        assertEquals(expected, seaDist.getfCountry());
        seaDist.setfCountry("Portugal");
        assertEquals(expected, seaDist.getfCountry());
    }

    @Test
    void setfPortId() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "tres";
        assertEquals(expected, seaDist.getfPortId());
        seaDist.setfPortId("tres");
        assertEquals(expected, seaDist.getfPortId());
    }

    @Test
    void setfPort() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "port";
        assertEquals(expected, seaDist.getfPort());
        seaDist.setfPort("port");
        assertEquals(expected, seaDist.getfPort());
    }

    @Test
    void settCountry() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "Spain";
        assertEquals(expected, seaDist.gettCountry());
        seaDist.settCountry("Spain");
        assertEquals(expected, seaDist.gettCountry());
    }

    @Test
    void settPortId() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "one";
        assertEquals(expected, seaDist.gettPortId());
        seaDist.settPortId("one");
        assertEquals(expected, seaDist.gettPortId());
    }


    @Test
    void settPort() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        String expected = "gg";
        assertEquals(expected, seaDist.gettPort());
        seaDist.settPort("gg");
        assertEquals(expected, seaDist.gettPort());
    }

    @Test
    void setDist() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        int expected = 55;
        assertEquals(expected, seaDist.getDist());
        seaDist.setDist(55);
        assertEquals(expected, seaDist.getDist());
    }

    @Test
    void equalssTest() {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        SeaDist seaDist1 = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        boolean result = seaDist.equals(seaDist1);
        boolean expected = true;
        assertEquals(expected, result);


    }

    @Test
    void notEqualTest() throws FileNotFoundException {
        SeaDist seaDist = new SeaDist("Portugal", "tres", "port", "Spain", "one", "gg", 55);
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        boolean result = seaDist.equals(shipDynamicFields);
        boolean expected = false;
        assertEquals(expected, result);
    }















}
