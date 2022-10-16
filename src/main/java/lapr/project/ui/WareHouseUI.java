package lapr.project.ui;

import lapr.project.data.WareHouseController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class WareHouseUI {
        WareHouseController wareHouseController = new WareHouseController();

                public void getWareHouseOccupancy () throws SQLException, IOException {
               System.out.println("WareHouseID|| OCCUPANCY RATE (%)");

               String result = wareHouseController.getWareHouseAvailabilty();
             System.out.println(result);
           }

    public void getWareHouseEstimation() throws IOException {
        System.out.println("WareHouseID|| Estimation of container leaving");
        String result = wareHouseController.getWareHouseEstimation();
        System.out.println(result);

    }

    public void getResourceList(int portId) throws IOException {
                    Scanner in = new Scanner(System.in);
        System.out.println("Qual o mês e ano? yyyy-MM");
        String month = in.nextLine();
        String day = month+"-05";
        System.out.println("PORTID|| CONTAINER RATE(%) || SHIP RATE(%)");
        WareHouseController wareHouseController = new WareHouseController();
        try {
            String result = wareHouseController.getResourceList(portId,day);
            System.out.println(result);

        } catch (Exception exception) {

        }}
}