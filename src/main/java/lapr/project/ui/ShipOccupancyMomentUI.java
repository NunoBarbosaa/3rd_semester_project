package lapr.project.ui;

import lapr.project.data.ShipOccupancyMomentController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ShipOccupancyMomentUI {
    static ShipOccupancyMomentController controller = new ShipOccupancyMomentController();


    public void getShipOccupancyByMoment(int MMSI) throws IOException, SQLException {
        Scanner ler = new Scanner(System.in);
        System.out.println("What's the date? format:YYYY-MM-DD HH:MI");
        String date= ler.nextLine();
        System.out.println("MMSI || SHIP CAPACITY || OCCUPANCY RATE (%)");
        try {
            String result = controller.shipCapacityCalcByMoment(MMSI,date);
            System.out.println(result);
        } catch (Exception exception) {
        }
    }
}
