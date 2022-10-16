package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.data.ShipDistance;
import lapr.project.model.Ship.ShipDynamicFields;


import java.io.FileNotFoundException;
import java.util.*;

public class ShipDistanceController {

    public static ShipDistance shipDistCalc(int mmsi, HashMap<Ship, List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        ShipDistance shipDistance = new ShipDistance();
        shipDistance.setMmsi(mmsi);
        shipDistance.setTotalMovements(ShipDistance.getTotalMovements(mmsi, shipMap));
        shipDistance.setTotalTime(ShipDistance.getTotalTime(mmsi, shipMap));
        shipDistance.setMaxCog(ShipDistance.maxCog(mmsi, shipMap));
        shipDistance.setMaxSog(ShipDistance.maxSog(mmsi, shipMap));
        shipDistance.setStartTime(ShipDistance.minTime(mmsi, shipMap).getDateTime());
        shipDistance.setEndTime(ShipDistance.maxTime(mmsi, shipMap).getDateTime());
        shipDistance.setDepLatitude(ShipDistance.minTime(mmsi, shipMap).getLat());
        shipDistance.setDepLong(ShipDistance.minTime(mmsi, shipMap).getLon());
        shipDistance.setArrLatitude(ShipDistance.maxTime(mmsi, shipMap).getLat());
        shipDistance.setArrLong(ShipDistance.maxTime(mmsi, shipMap).getLon());
        shipDistance.setMeanCog(ShipDistance.meanCog(mmsi, shipMap));
        shipDistance.setMeanSog(ShipDistance.meanSog(mmsi, shipMap));
        shipDistance.setDeltDis(ShipDistance.distDelta(mmsi, shipMap));
        shipDistance.setTravDis(ShipDistance.totalDistance(mmsi, shipMap));
        for (Ship ship1 : shipMap.keySet()) {
            if (ship1.getMmsi() == mmsi) {
                shipDistance.setVesselName(ship1.getVesselName());
            }
        }
        return shipDistance;
    }

/*
    public static List<ShipDistance> shipsOrderByMostKmFastShips (String dateOfCheck, String hourCheck, String hourCheck2, int numberOfResults, HashMap<Ship,List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        return ShipDistance.mostKmFastShips(dateOfCheck,hourCheck,hourCheck2,numberOfResults,shipMap);
    }

*/

    public static List<ShipDistance> orderShipsByTdOrNumbOfMov(HashMap<Ship, List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        return ShipDistance.orderShips(shipMap);
    }


}