package lapr.project.data;

import lapr.project.data.CargoManifestStore;
import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;

public class ShipOccupancyMomentController {


    public String shipCapacityCalcByMoment(int MMSI, String date) throws SQLException, IOException {
        DatabaseConnection databaseConnection = null;

            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
            CargoManifestStore cargoManifestStore = new CargoManifestStore();
        String result=cargoManifestStore.shipOccupancyByDate(databaseConnection,MMSI,date);
        return result;

    }
}
