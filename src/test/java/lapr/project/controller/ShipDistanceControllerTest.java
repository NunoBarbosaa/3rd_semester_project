package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.data.ShipDistance;
import lapr.project.model.Ship.ShipDynamicFields;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipDistanceControllerTest {
    HashMap<Ship, List<ShipDynamicFields>> shipMap = LoaderController.mapShipData(LoaderController.loadDynamicFields("sshipstest.csv"),
            LoaderController.loadShipsByMmsi("sshipstest.csv"));


    ShipDistanceControllerTest() throws FileNotFoundException {
    }


    @Test
    void shipDistCalc() throws FileNotFoundException {
        int mmsi = 210950000;
        ShipDistance result = ShipDistanceController.shipDistCalc(mmsi, shipMap);
        System.out.println(result);
        ShipDistance ship = new ShipDistance(210950000, "VARAMO", "31/12/2020 16:00", "31/12/2020 17:15", 4, "1:15", 13.7, 13.25, 3.4, -26.85, 42.69577, 42.96527, -66.97808, -66.97082, ShipDistance.totalDistance(210950000, shipMap), ShipDistance.distDelta(210950000, shipMap));
        //  ShipDistance ship = new ShipDistance(210950000,"VARAMO","31/12/2020 17:15","31/12/2020 17:15", 1, "0:0", 12.8, 12.8,-58.6,-58.6,42.96527,42.96527,-66.97082,-66.97082,0.0,0.0);
        assertEquals(ship, result);
    }


    @Test
    void orderShipsByTdOrNumbOfMov() throws FileNotFoundException {
        List<ShipDistance> result = ShipDistanceController.orderShipsByTdOrNumbOfMov(shipMap);
        System.out.println(result);
        ShipDistance shipDistance = new ShipDistance(228339600, "CMA CGM ALMAVIVA", "31/12/2020 00:00", "31/12/2020 03:56", 4, "3:56", 11.8, 11.649999999999999, 131.1, 128.525, 28.37458, 27.87869, -88.88584, -88.22321, 162428.5318463634, 85222.07283417834);
        //     ShipDistance shipDistance1= new ShipDistance(210950000, vesselName='VARAMO', startTime='31/12/2020 16:00', endTime='31/12/2020 17:15', totalMovements=4, totalTime='1:15', maxSog=13.7, meanSog=13.25, maxCog=3.4, meanCog=-26.85, depLatitude=42.69577, arrLatitude=42.96527, depLong=-66.97808, arrLong=-66.97082, travDis=74447.79840206594, deltDis=29972.880199805448}]
        //   assertEquals(shipDistance, result);

    }

/*
    @Test
    void checkShipsOrderByMostKmFast() throws FileNotFoundException {
        List<ShipDistance> result = ShipDistanceController.shipsOrderByMostKmFastShips(null, null, null, 0, shipMap);
        List<ShipDistance> expected = null;
        assertEquals(expected, result);
    }
*/
}

