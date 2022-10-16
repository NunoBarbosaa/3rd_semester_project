package lapr.project.controller;

import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipOrderedByCallSign;
import lapr.project.model.Ship.ShipOrderedByIMO;
import lapr.project.data.AVL;

public class FindShipController {

    public static Ship findShipByMmsi(AVL avl, int mmsi) {
        Ship ship = null;
        ship = Ship.findShip(avl, mmsi);
        return ship;
    }

    public static Ship findShipByIMO(AVL avl, String imo) {
        Ship ship = null;
        ship = ShipOrderedByIMO.findShipByIMO(avl, imo);
        return ship;
    }

    public static Ship findShipByCallSign(AVL avl, String callSign) {
        Ship ship = null;
        ship = ShipOrderedByCallSign.findShipByCallSign(avl, callSign);
        return ship;
    }

}






