package lapr.project.model;

import lapr.project.data.ShipDistance;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShipDynamicFieldsTest {

    @Test
    public void nullDynamicFields() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        Object object = new ShipDynamicFields();
        assertEquals(object, shipDynamicFields);

    }


    @Test
    public void setDateTime() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        String expected = "31/10/2020";
        assertNotEquals(expected, shipDynamicFields.getDateTime());
        shipDynamicFields.setDateTime("31/10/2020");
        assertEquals(expected, shipDynamicFields.getDateTime());

    }

    @Test
    public void setLon() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        double expected = 33;
        assertNotEquals(expected, shipDynamicFields.getLon());
        shipDynamicFields.setLon(33);
        assertEquals(expected, shipDynamicFields.getLon());
    }

    @Test
    public void setLat() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        double expected = 22;
        assertNotEquals(expected, shipDynamicFields.getLat());
        shipDynamicFields.setLat(22);
        assertEquals(expected, shipDynamicFields.getLat());
    }

    @Test
    public void setSog() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        float expected = 55f;
        assertNotEquals(expected, shipDynamicFields.getSog());
        shipDynamicFields.setSog(55f);
        assertEquals(expected, shipDynamicFields.getSog());
    }

    @Test
    public void setCog() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        float expected = 33f;
        assertNotEquals(expected, shipDynamicFields.getCog());
        shipDynamicFields.setCog(33f);
        assertEquals(expected, shipDynamicFields.getCog());
    }

    @Test
    public void setHeading() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        int expected = 2;
        assertNotEquals(expected, shipDynamicFields.getHeading());
        shipDynamicFields.setHeading(2);
        assertEquals(expected, shipDynamicFields.getHeading());

    }

    @Test
    void getPosition() {
        ShipDynamicFields dynamicFields = new ShipDynamicFields();
        int position = 0;
        int result = dynamicFields.getPosition();
        assertEquals(position, result);
    }

    @Test
    public void setPosition() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        int expected = 5;
        assertNotEquals(expected, shipDynamicFields.getPosition());
        shipDynamicFields.setPosition(5);
        assertEquals(expected, shipDynamicFields.getPosition());

    }

    @Test
    public void setTransceiverClass() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        String expected = "Ola";
        assertNotEquals(expected, shipDynamicFields.getTransceiverClass());
        shipDynamicFields.setTransceiverClass("Ola");
        assertEquals(expected, shipDynamicFields.getTransceiverClass());
    }

    @Test
    public void equalsTest(){
        ShipDynamicFields test1=new ShipDynamicFields(210950000,"31/12/2020 17:15",42.96527,-66.97082,12.8,-58.6,358,"B");
        ShipDynamicFields test2=new ShipDynamicFields(21000011,"31/12/2020 17:15",42.96527,-66.97082,12.8,-58.6,358,"B");
        assertNotEquals(test1,test2);
    }

    @Test
    void TestToString() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        shipDynamicFields.getDateTime();
        shipDynamicFields.getLon();
        shipDynamicFields.getLat();
        shipDynamicFields.getSog();
        shipDynamicFields.getCog();
        shipDynamicFields.getHeading();
        shipDynamicFields.getPosition();
        shipDynamicFields.getMMSI();
        shipDynamicFields.getTransceiverClass();
        shipDynamicFields.toString();
    }

    @Test
    void equalssTest() {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        ShipDynamicFields shipDynamicFields1 = new ShipDynamicFields();
        boolean result = shipDynamicFields.equals(shipDynamicFields1);
        boolean expected = true;
        assertEquals(expected, result);



    }

    @Test
    void notEqualTest() throws FileNotFoundException {
        ShipDynamicFields shipDynamicFields = new ShipDynamicFields();
        ShipDistance shipDistance = new ShipDistance();
        boolean result = shipDynamicFields.equals(shipDistance);
        boolean expected = false;
        assertEquals(expected, result);
    }




}








