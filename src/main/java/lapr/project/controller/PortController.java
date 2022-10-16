package lapr.project.controller;
import lapr.project.model.Ports.Port;
import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipDynamicFields;
import lapr.project.ui.TwoDTree.TwoDTree;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;



public class PortController {
    TwoDTree<Port> portstest = LoaderController.loadPortsTwoDTree("sports.csv");
    HashMap<Ship, List<ShipDynamicFields>> shipMaptest = LoaderController.mapShipData(LoaderController.loadDynamicFields("sships.csv") ,
    LoaderController.loadShipsByCallSign("sships.csv"));

    public PortController() throws FileNotFoundException {
    }
/*
    public Port findClosestPortToShip(String callSign, Date year, LocalTime hours) throws FileNotFoundException, ParseException {
        Ship ship = new Ship();
        for(Ship ships : shipMaptest.keySet()) {
            if (ships.getCallSign().equals(callSign)) {
                 ship = ships;
            }
        }
        List<ShipDynamicFields> shipDynamicFields = shipMaptest.get(ship);
        ShipDynamicFields finalShip =ShipDynamicFields.checkLastPositionUpgrade(year, hours, shipDynamicFields);
        Node portNode = portstest.findNearestNeighbour(finalShip.getLat(), finalShip.getLon());
        return portNode.getInfo();
    }

 */
}
