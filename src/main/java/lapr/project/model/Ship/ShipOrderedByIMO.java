package lapr.project.model.Ship;

import lapr.project.data.AVL;






public class ShipOrderedByIMO extends Ship implements Comparable<Ship> {


    /**
    * Utilizamos o contrutor da classe Ship
     */

    public ShipOrderedByIMO(int mmsi, String vesselName, String imo, String callSign, int vesselType, int length, int width, float draft,
                            String cargo){
        super(mmsi,vesselName,imo,callSign,vesselType,length,width,draft,cargo);
    }

    /**
    * Encontrar um barco por IMO
    * @param avl
    * @param imo
    */

    public static Ship findShipByIMO(AVL avl , String imo){
        if(avl.isEmpty()){
            return null;
        }
        Iterable<Ship> list = avl.preOrder();
        for(Ship ship : list){
            if(imo.equalsIgnoreCase(ship.getImo())){
                return ship;
            }
        }
        return null;
    }

    @Override
    public int compareTo(Ship ship) {
        return super.getImo().compareTo(ship.getImo());
    }
}
