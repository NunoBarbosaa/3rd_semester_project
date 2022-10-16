package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipDynamicFields;
import lapr.project.data.AVL;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipPositionsControllerTest {
    HashMap<Ship, List<ShipDynamicFields>>shipMap = LoaderController.mapShipData(LoaderController.loadDynamicFields("sshipstest.csv") ,LoaderController.loadShipsByMmsi("sshipstest.csv"));

    ShipPositionsControllerTest() throws FileNotFoundException {
    }
/*
    @Test
    void checkPositions() throws FileNotFoundException {
        String date = "31/12/2020";
        String hour =  "17:15";
        ShipDynamicFields test1=new ShipDynamicFields(210950000,"31/12/2020 17:15",42.96527,-66.97082,12.8,-58.6,358,"B");
        ShipDynamicFields test2=new ShipDynamicFields(228339600,"31/12/2020 03:56",27.87869,-88.22321,11.7,127.9,128,"B");

        AVL<ShipDynamicFields> result = ShipPositionsController.checkPositions(date,hour, shipMap);
        AVL<ShipDynamicFields> expected = new AVL<>();
        expected.insert(test1);
        expected.insert(test2);
        assertEquals(result,expected) ;
    }

    @Test
    void checkPositionsBetweenDates() throws FileNotFoundException {
        String date = "31/12/2020";
        String hour =  "17:10";
        String date2 = "31/12/2020";
        String hour2 =  "17:15";
        ShipDynamicFields test1=new ShipDynamicFields(210950000,"31/12/2020 17:15",42.96527,-66.97082,12.8,-58.6,358,"B");

        AVL<ShipDynamicFields> result = ShipPositionsController.checkPositionsBetweenDates(date,hour,date2,hour2,shipMap);
        AVL<ShipDynamicFields> expected = new AVL<>();
        expected.insert(test1);
        assertEquals(result,expected);
    }
    */

}