package lapr.project.model.Ship;

import lapr.project.data.AVL;





public class ShipOrderedByCallSign extends Ship implements Comparable<Ship> {


    public ShipOrderedByCallSign(int mmsi, String vesselName, String imo, String callSign, int vesselType, int length,
                                 int width, float draft, String cargo) {
        super(mmsi,vesselName, imo, callSign, vesselType, length, width, draft, cargo);
    }

    public static Ship findShipByCallSign(AVL avl , String callSign){
        if(avl.isEmpty()){
            return null;
        }
        Iterable<Ship> list = avl.preOrder();
        for(Ship ship : list){
            if(callSign.equalsIgnoreCase(ship.getCallSign())){
                return ship;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Ship ship) {
        return super.getCallSign().compareTo(ship.getCallSign());
    }
}
