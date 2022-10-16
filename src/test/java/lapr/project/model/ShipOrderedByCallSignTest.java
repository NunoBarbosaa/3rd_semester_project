package lapr.project.model;

import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipOrderedByCallSign;
import lapr.project.data.AVL;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipOrderedByCallSignTest {

    @Test
    void findShipByCallSign() throws FileNotFoundException {
        ShipOrderedByCallSign shipTest = new ShipOrderedByCallSign(210950000, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5f, "NA");
        AVL<Ship> avl = new AVL<>();
        File file = new File("sships.csv");

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            ShipOrderedByCallSign ship = new ShipOrderedByCallSign(Integer.parseInt(read[0]), read[7], read[8], read[9], Integer.parseInt(read[10]),
                    Integer.parseInt(read[11]), Integer.parseInt(read[12]), Float.parseFloat(read[13]), read[14]);
            avl.insert(ship);
        }
        Ship shipResult = ShipOrderedByCallSign.findShipByCallSign(avl, "C4SQ2");
        assertEquals(shipTest.getCallSign(), shipResult.getCallSign());
    }


    @Test
    void compareTo() {
        ShipOrderedByCallSign shipTest = new ShipOrderedByCallSign(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        ShipOrderedByCallSign shipTest2 = new ShipOrderedByCallSign(100000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 0;
        int resultado = shipTest.compareTo(shipTest2);
        assertEquals(expected,resultado) ;
    }

    @Test
    void verifyIfAvlNull() throws FileNotFoundException {
        ShipOrderedByCallSign shipTest = new ShipOrderedByCallSign(210950000, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5f, "NA");
        AVL<Ship> avl = new AVL<>();
        Ship shipResult = ShipOrderedByCallSign.findShipByCallSign(avl, "C4SQ2");
        assertEquals(null, shipResult);
    }



}

