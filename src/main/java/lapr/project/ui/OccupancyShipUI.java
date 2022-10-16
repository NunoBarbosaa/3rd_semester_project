package lapr.project.ui;

import lapr.project.data.ShipOccupancyController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class OccupancyShipUI {


    static ShipOccupancyController controller = new ShipOccupancyController();
    static Scanner ler = new Scanner(System.in);
    static Scanner in = new Scanner(System.in);

    public  void getShipOccupancy () throws IOException, SQLException {

        System.out.println("What's the Cargo Manifest id?");
        int cargoId = ler.nextInt();
        System.out.println("MMSI || SHIP CAPACITY || OCCUPANCY RATE (%)");
        try {
            String result = controller.shipCapacityCalc(cargoId);
            System.out.println(result);
        } catch (Exception exception) {
        }
    }

}
