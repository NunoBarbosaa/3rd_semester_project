package lapr.project.model;

import lapr.project.model.Ship.Ship;
import lapr.project.data.AVL;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    void getPowerOutput() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,(float)9.5,"NA");
        double poExpected = 20.00;
        double result = shipTest.getPowerOutput();
        assertEquals(poExpected,result);
    }

    @Test
    void badGetPowerOutput() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,(float)9.5,"NA");
        double poExpected = 25.00;
        double result = shipTest.getPowerOutput();
        assertNotEquals(poExpected,result);
    }

    @Test
    void getMmsi() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int mmsi = 210950000;
        int result = shipTest.getMmsi();
        assertEquals(mmsi,result);
    }

    @Test
    void badGetMmsi() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int mmsi = 210950;
        int result = shipTest.getMmsi();
        assertNotEquals(mmsi,result);
    }

    @Test
    void getVesselName() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,(float)9.5,"NA");
        String vesselNameEx = "Joao";
        String result = shipTest.getVesselName();
        assertNotEquals(vesselNameEx,result);
    }

    @Test
    void getImo() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String imo = "IMO9395044";
        String result = shipTest.getImo();
        assertEquals(imo,result);
    }

    @Test
    void getCallSign() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String callSign = "C4SQ2";
        String result = shipTest.getCallSign();
        assertEquals(callSign,result);
    }

    @Test
    void getVesselType() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,(float)9.5,"NA");
        int vesselTypeEx = 70;
        int result = shipTest.getVesselType();
        assertEquals(vesselTypeEx,result);
    }

    @Test
    void getLength() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int lengthEx = 166;
        int result = shipTest.getLength();
        assertEquals(lengthEx,result);
    }

    @Test
    void getWidth() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int width = 25;
        int result = shipTest.getWidth();
        assertEquals(width,result);
    }

    @Test
    void getDraft() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        float draft = 9.5f;
        float result = shipTest.getDraft();
        assertEquals(draft,result);

    }

    @Test
    void getCargo() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String cargoEx = "NA";
        String result = shipTest.getCargo();
    }

    @Test
    void getNumEnergyGen() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        double expected = 0.0;
        double result = shipTest.getNumEnergyGen();
        assertEquals(expected,result);
    }

    @Test
    void setMmsi() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 1;
        assertNotEquals(expected,shipTest.getMmsi());
        shipTest.setMmsi(1);
        assertEquals(expected,shipTest.getMmsi());
    }

    @Test
    void setVesselName() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String expected = "Hello";
        assertNotEquals(expected,shipTest.getVesselName());
        shipTest.setVesselName("Hello");
        assertEquals(expected,shipTest.getVesselName());
    }

    @Test
    void setImo() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String expected = "Teste";
        assertNotEquals(expected,shipTest.getImo());
        shipTest.setImo("Teste");
        assertEquals(expected,shipTest.getImo());
    }

    @Test
    void setCallSign() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String expected = "Porto";
        assertNotEquals(expected,shipTest.getCallSign());
        shipTest.setCallSign("Porto");
        assertEquals(expected,shipTest.getCallSign());
    }

    @Test
    void setVesselType() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 100;
        assertNotEquals(expected,shipTest.getVesselType());
        shipTest.setVesselType(100);
        assertEquals(expected,shipTest.getVesselType());
    }

    @Test
    void setLength() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 30;
        assertNotEquals(expected,shipTest.getLength());
        shipTest.setLength(30);
        assertEquals(expected,shipTest.getLength());
    }

    @Test
    void setWidth() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 50;
        assertNotEquals(expected,shipTest.getWidth());
        shipTest.setWidth(50);
        assertEquals(expected,shipTest.getWidth());
    }

    @Test
    void setDraft() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        float expected = 1.6f;
        assertNotEquals(expected,shipTest.getDraft());
        shipTest.setDraft(1.6f);
        assertEquals(expected,shipTest.getDraft());
    }

    @Test
    void setCargo() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        String expected = "K";
        assertNotEquals(expected,shipTest.getCargo());
        shipTest.setCargo("K");
        assertEquals(expected,shipTest.getCargo());
    }

    @Test
    void setNumEnergyGen() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        double expected = 10.00;
        assertNotEquals(expected,shipTest.getNumEnergyGen());
        shipTest.setNumEnergyGen(10.00);
        assertEquals(expected,shipTest.getNumEnergyGen());
    }

    @Test
    void findShip() throws FileNotFoundException {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        AVL<Ship> bstMmsi = new AVL<>();
        File file = new File("sships.csv");

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            Ship ship = new Ship(Integer.parseInt(read[0]),read[7],read[8],read[9],Integer.parseInt(read[10]),
                    Integer.parseInt(read[11]),Integer.parseInt(read[12]),Float.parseFloat(read[13]),read[14]);
            bstMmsi.insert(ship);
        }
        Ship shipResult = Ship.findShip(bstMmsi,210950000);
        assertEquals(shipTest.getMmsi(),shipResult.getMmsi());
    }

    @Test
    void compareTo() {
        Ship shipTest = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        Ship shipTest2 = new Ship(100000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        int expected = 1;
        int resultado = shipTest.compareTo(shipTest2);
        assertEquals(expected,resultado);
    }

    @Test
    void testPrintDetails() {
        Ship ship = new Ship(210950000,"VARAMO","IMO9395044","C4SQ2",70,166,25,9.5f,"NA");
        ship.getMmsi();
        ship.getVesselName();
        ship.getImo();
        ship.getCallSign();
        ship.getVesselType();
        ship.getLength();
        ship.getWidth();
        ship.getDraft();
        ship.getCargo();
        ship.getNumEnergyGen();
        ship.printDetails();

    }



}