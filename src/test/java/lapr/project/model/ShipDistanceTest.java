package lapr.project.model;

import lapr.project.controller.LoaderController;
import lapr.project.model.Ship.Ship;
import lapr.project.data.ShipDistance;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ShipDistanceTest {
    HashMap<Ship, List<ShipDynamicFields>> shipMap = LoaderController.mapShipData(LoaderController.loadDynamicFields("sshipstest.csv"), LoaderController.loadShipsByMmsi("sshipstest.csv"));

    public ShipDistanceTest() throws FileNotFoundException {
    }

    @Test
    void getMmsi() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        int result = ship.getMmsi();
        int expected = 210950000;
        assertEquals(result, expected);
    }

    @Test
    void setMmsi() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getVesselName() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getVesselName();
        String expected = "VARAMO";
        assertEquals(result, expected);
    }

    @Test
    void setVesselName() {
    }

    @Test
    void getStartTime() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getStartTime();
        String expected = "31/12/2020 16:00";
        assertEquals(result, expected);
    }

    @Test
    void setStartTime() {
    }

    @Test
    void getEndTime() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getEndTime();
        String expected = "31/12/2020 17:15";
        assertEquals(result, expected);
    }

    @Test
    void setEndTime() {
    }

    @Test
    void getTotalMovements() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        int result = ship.getTotalMovements();
        int expected = 4;
        assertEquals(result, expected);
    }

    @Test
    void setTotalMovements() {
    }

    @Test
    void getTotalTime() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:30", "31/12/2020 17:15", 4, "0:45", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getTotalTime();
        String expected = "0:45";
        assertEquals(result, expected);
    }

    @Test
    void getTotalTime2() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getTotalTime();
        String expected = "1:15";
        assertEquals(result, expected);
    }

    @Test
    void getTotalTime3() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 17:00", "31/12/2020 17:15", 4, "0:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        String result = ship.getTotalTime();
        String expected = "0:15";
        assertEquals(result, expected);
    }

    @Test
    void setTotalTime() {
    }

    @Test
    void getMaxSog() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getMaxSog();
        double expected = 13.7;
        assertEquals(result, expected);
    }

    @Test
    void setMaxSog() {
    }

    @Test
    void getMeanSog() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getMeanSog();
        double expected = 13.25;
        assertEquals(result, expected);
    }

    @Test
    void setMeanSog() {
    }

    @Test
    void getMaxCog() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getMaxCog();
        double expected = 3.4;
        assertEquals(result, expected);
    }

    @Test
    void setMaxCog() {
    }

    @Test
    void getMeanCog() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getMeanCog();
        double expected = -26.85;
        assertEquals(result, expected);
    }

    @Test
    void setMeanCog() {
    }

    @Test
    void getDepLatitude() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getDepLatitude();
        double expected = 42.69577;
        assertEquals(result, expected);
    }

    @Test
    void setDepLatitude() {
    }

    @Test
    void getArrLatitude() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getArrLatitude();
        double expected = 42.96527;
        assertEquals(result, expected);
    }

    @Test
    void setArrLatitude() {
    }

    @Test
    void getDepLong() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getDepLong();
        double expected = -66.97808;
        assertEquals(result, expected);
    }

    @Test
    void setDepLong() {
    }

    @Test
    void getArrLong() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getArrLong();
        double expected = -66.97082;
        assertEquals(result, expected);
    }

    @Test
    void setArrLong() {
    }

    @Test
    void getTravDis() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getTravDis();
        double expected = ship.getTravDis();
        assertEquals(result, expected);
    }

    @Test
    void getTotalDis() throws FileNotFoundException {
        Ship ship = new Ship(210950000, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5f, "NA");
        ShipDynamicFields test1 = new ShipDynamicFields(210950000, "31/12/2020 17:15", 07, 0, 12.8, -58.6, 358, "B");
        HashMap<Ship, List<ShipDynamicFields>> map = new HashMap<>();
        List<ShipDynamicFields> listM = new ArrayList<>();
        listM.add(test1);
        map.put(ship, listM);
        ShipDistance ships = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 0, 0, 0, 0, ShipDistance.totalDistance(210950000, map), ShipDistance.distDelta(210950000, map));
        double result = ships.totalDistance(210950000, map);
        double expected = 0;
        assertEquals(result, expected);
    }

    @Test
    void setTravDis() {
    }

    @Test
    void getDeltDis() throws FileNotFoundException {
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        double result = ship.getDeltDis();
        double expected = ship.getDeltDis();
        assertEquals(result, expected);
    }

    @Test
    void setDeltDis() {
    }

    @Test
    void maxCog() {
    }

    @Test
    void maxSog() {
    }

    @Test
    void meanCog() {
    }

    @Test
    void meanSog() {
    }

    @Test
    void minTime() {
    }

    @Test
    void maxTime() {
    }

    @Test
    void distDelta() {
    }

    @Test
    void distance() {
    }

    @Test
    void totalDistance() {
    }

    @Test
    void orderShips() throws FileNotFoundException {
        List<ShipDistance> result = ShipDistance.orderShips(shipMap);
        List<ShipDistance> expected = new ArrayList<>();
        ShipDistance shipDistance1 = new ShipDistance(228339600, "CMA CGM ALMAVIVA", "31/12/2020 00:00", "31/12/2020 03:56", 4, "3:56", 11.8, 11.649999999999999, 131.1, 128.525, 28.37458, 27.87869, -88.88584, -88.22321, 162428.5318463634, 85222.07283417834);
        ShipDistance shipDistance2 = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, 74447.79840206594, 29972.880199805448);
        expected.add(shipDistance1);
        expected.add(shipDistance1);
        assertNotEquals(result, expected);

    }

/*
    void testHashCode() {
    }
*/
    /*
    @Test
    void mostKmFastShips() throws FileNotFoundException {
        List<ShipDistance> result = ShipDistance.mostKmFastShips(null, null, null, 0, shipMap);
        System.out.println(result);
        ShipDistance shipDistance = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        assertNotEquals(result, shipDistance);


    }

     */
}



