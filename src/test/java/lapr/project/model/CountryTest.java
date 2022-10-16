package lapr.project.model;

import lapr.project.model.Country.Country;
import lapr.project.model.Ports.Port;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CountryTest {

    @Test
    void getContinent() throws FileNotFoundException {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String result = country.getContinent();
        String expected = "Europe";
        assertEquals(result, expected);
    }

    @Test
    void getA2() throws FileNotFoundException {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String result = country.getA2();
        String expected = "Portugal";
        assertEquals(result, expected);
    }

    @Test
    void getA3() throws FileNotFoundException {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String result = country.getA3();
        String expected = "ffff";
        assertEquals(result, expected);
    }

    @Test
    void getPop() throws FileNotFoundException {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String result = country.getPop();
        String expected = "fffff";
        assertEquals(result, expected);
    }

    @Test
    void setContinent() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getContinent());
        country.setContinent("Africa");
        assertEquals(expected, country.getContinent());
    }

    @Test
    void setA2() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getA2());
        country.setA2("Africa");
        assertEquals(expected, country.getA2());
    }

    @Test
    void setA3() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getA3());
        country.setA3("Africa");
        assertEquals(expected, country.getA3());
    }

    @Test
    void setName() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getName());
        country.setName("Africa");
        assertEquals(expected, country.getName());
    }

    @Test
    void setPop() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getPop());
        country.setPop("Africa");
        assertEquals(expected, country.getPop());
    }

    @Test
    void setCap() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        String expected = "Africa";
        assertNotEquals(expected, country.getCap());
        country.setCap("Africa");
        assertEquals(expected, country.getCap());
    }

    @Test
    void setLat() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        Double expected = 99d;
        assertNotEquals(expected, country.getLat());
        country.setLat(99d);
        assertEquals(expected, country.getLat());
    }

    @Test
    void setLongi() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        Double expected = 90d;
        assertNotEquals(expected, country.getLongi());
        country.setLongi(90d);
        assertEquals(expected, country.getLongi());
    }

    @Test
    void equalssTest() {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        Country country1 = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        boolean result = country.equals(country1);
        boolean expected = true;
        assertEquals(expected, result);


    }

    @Test
    void notEqualTest() throws FileNotFoundException {
        Country country = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        Country country1 = new Country("Europe", "Portugal", "ffff", "Travel", "fffff", "fffff", 65d, 55d);
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        boolean result = country.equals(shipDynamicFields);
        boolean expected = false;
        assertEquals(expected, result);
    }



}
