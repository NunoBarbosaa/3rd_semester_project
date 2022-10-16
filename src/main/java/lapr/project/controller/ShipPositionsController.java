package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipDynamicFields;
import lapr.project.data.AVL;


import java.io.FileNotFoundException;


import java.util.*;

public class ShipPositionsController {



    public ShipPositionsController() throws FileNotFoundException {
    }
/*
    public static AVL<ShipDynamicFields> checkPositions(String dateOfCheck, String hourCheck,
                                                        HashMap<Ship, List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        AVL<ShipDynamicFields> position = new AVL<>();

        for(Ship ship : shipMap.keySet()) {
           String read[] = hourCheck.split(":");
            ShipDynamicFields checkShip = ShipDynamicFields.checkLastPosition(ship.getMmsi(),
                    Integer.parseInt(read[0]), Integer.parseInt(read[1]), shipMap);
            position.insert(checkShip);
            }
        return position;
    }

    public static AVL<ShipDynamicFields> checkPositionsBetweenDates(String dateOfCheck, String hourCheck, String DateOfCheck2, String hourCheck2, HashMap<Ship, List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        AVL<ShipDynamicFields> position = new AVL<>();

        for(Ship ship : shipMap.keySet()) {
            for (List<ShipDynamicFields> ships : shipMap.values()) {
                for (ShipDynamicFields din : ships) {
                        String read[] = din.getDateTime().split(" ");
                        String diaAno = read[0];
                        String hora = read[1];
                        String read3[] = hora.split(":");
                        int hour3 = Integer.parseInt(read3[0]);
                        int minutes3 = Integer.parseInt(read3[1]);
                        String read2[] = hourCheck.split(":");
                        int hour = Integer.parseInt(read2[0]);
                        int minutes = Integer.parseInt(read2[1]);
                        String read1[] = hourCheck2.split(":");
                        int hour1 = Integer.parseInt(read1[0]);
                        int minutes1 = Integer.parseInt(read1[1]);
                        if (dateOfCheck.equals(diaAno) && hour3 >= hour && hour3 <= hour1 && minutes3 >= minutes && minutes3 <= minutes1) {
                            ShipDynamicFields path = new ShipDynamicFields(ship.getMmsi(), diaAno + hora, din.getLat(),din.getLon(), din.getSog(), din.getCog(),
                                    din.getHeading(), din.getTransceiverClass());
                            position.insert(path);
                        }
                    }
                }
            }
        return position;
    }
*/
}
