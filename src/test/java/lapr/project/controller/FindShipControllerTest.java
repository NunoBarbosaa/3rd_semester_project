package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipOrderedByCallSign;
import lapr.project.model.Ship.ShipOrderedByIMO;
import lapr.project.data.AVL;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindShipControllerTest {

    @Test
    void findShipByMmsi() throws FileNotFoundException {
        AVL<Ship> avl = LoaderController.loadShipsByMmsi("sships.csv");
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        Ship ship = null;
        ship = FindShipController.findShipByMmsi(avl, 210950000);
        assertEquals(ship.getMmsi(), shipTest.getMmsi());

    }

    @Test
    void findShipByIMO() throws FileNotFoundException {
        AVL<Ship> avl = LoaderController.loadShipsByIMO("sships.csv");
        ShipOrderedByIMO shipTest = new ShipOrderedByIMO(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        Ship ship = null;
        ship = FindShipController.findShipByIMO(avl, "IMO9395044");
        assertEquals(ship.getImo(), shipTest.getImo());

    }




    @Test
    void findShipByCallSign() throws FileNotFoundException {
        AVL<Ship> avl = LoaderController.loadShipsByCallSign("sships.csv");
        ShipOrderedByCallSign shipTest = new ShipOrderedByCallSign(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        Ship ship = null;
        ship = FindShipController.findShipByCallSign(avl, "C4SQ2");
        assertEquals(ship.getCallSign(), shipTest.getCallSign()) ;

    }


}
