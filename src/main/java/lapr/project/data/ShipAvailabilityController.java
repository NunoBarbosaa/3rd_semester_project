package lapr.project.data;

import lapr.project.data.CargoManifestStore;
import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;

import java.io.IOException;

public class ShipAvailabilityController {

    public String getAvailableShips(String date) throws IOException {

        DatabaseConnection databaseConnection = null;

            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
            CargoManifestStore cargoManifestStore = new CargoManifestStore();
            cargoManifestStore.shipAvailability(databaseConnection,date);
            String result=cargoManifestStore.shipAvailability(databaseConnection,date);
        return result;
    }
}
