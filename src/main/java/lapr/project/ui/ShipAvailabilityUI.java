package lapr.project.ui;

import lapr.project.data.ShipAvailabilityController;

import java.util.Scanner;

public class ShipAvailabilityUI {

    static Scanner ler = new Scanner(System.in);
    public void getAvailableShips() {
        System.out.println("What's next Monday date? format : YYYY-MM-DD HH:MI");
        String date = ler.nextLine();
        ShipAvailabilityController shipAvailabilityController = new ShipAvailabilityController();
        System.out.println("MMSI");
        try{
            String result=shipAvailabilityController.getAvailableShips(date);
            System.out.println(result);
        }catch (Exception exception){

        }


    }
}
