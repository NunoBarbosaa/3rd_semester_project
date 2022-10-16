package lapr.project.data;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ShipOccupancyController {

    public String shipCapacityCalc (int cargoId) throws IOException, SQLException {
        DatabaseConnection databaseConnection = null;

            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
            CargoManifestStore cargoManifestStore = new CargoManifestStore();
        String result=cargoManifestStore.shipOccupancy(databaseConnection,cargoId);
        return result;
        }

    public void averageOccupancyRate(int mmsi) throws IOException {
        Scanner in = new Scanner(System.in);
        DatabaseConnection databaseConnection = null;
        System.out.println("What's the START date?");
        String StartDate = in.nextLine();
        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        String result=cargoManifestStore.averageOccupancyRate(databaseConnection,mmsi,StartDate);
        System.out.println("MMSI  ||   AVERAGE RATE(%)");
        System.out.println(result);

    }
    public void getLoadingMap()throws IOException{
        DatabaseConnection databaseConnection;
        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        String result = cargoManifestStore.getLoadingMap(databaseConnection);
        System.out.println("TRANSPORT TYPE || TRANSPORT ID || LOADING TYPE || TRANSPORTDATE");
        System.out.println(result);

    }

    public void tripsBelowThreshHold(int mmsi) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("whats the starting date? YYYY-MM-DD");
        String startDate = in.nextLine();

        DatabaseConnection databaseConnection;
        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        String result = cargoManifestStore.getTripsThreshHold(databaseConnection,mmsi,startDate);
        System.out.println("TRIPID || START LOCATION || START DATE || END LOCATION || END DATE || AVG RATE(%)");
        System.out.println(result);
    }
}
