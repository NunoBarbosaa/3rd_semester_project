package lapr.project.ui;


import lapr.project.data.ShipRouteController;
import lapr.project.model.Ship.ShipMovement;
import lapr.project.data.ShipPair;
import lapr.project.model.Ship.ShipRoute;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ShipRouteUI {
    static ShipRouteController controller = new ShipRouteController();
    static List<ShipMovement> shipMovementList;

    static {
        try {
            shipMovementList = controller.loadCsvFile("bships.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static  ShipRouteController shipRouteController = new ShipRouteController();
    static List<ShipRoute> shipRouteList = shipRouteController.calculateShipRoute(shipMovementList);
    static List<ShipRoute> filteredShipRouteList = shipRouteController.filterShipRoutesByTravelDistance(shipRouteList, 10000);


    static Scanner in = new Scanner(System.in);

    public static void RouteUI() throws IOException {

        System.out.println("1 - Deseja imprimir pares de navios com coordenadas  de partida/chegada semelhantes?");
        System.out.println("(Só navios com mais de 10km de distancia percorrida serão considerados)");
        int op = in.nextInt();
        switch(op){
        case 1:
            List<ShipPair> shipPairList = shipRouteController.filterShipRoutesByPairs(filteredShipRouteList, 5000);
            if(shipPairList == null){
                System.out.println("A lista é null");
            }else if(shipPairList.isEmpty()){
                System.out.println("A lista está vazia");
            }
            System.out.println(shipPairList.toString());
            break;
            default: System.out.println("opção inválida.");
        }
    }
}
