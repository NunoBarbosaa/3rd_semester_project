package lapr.project.data;

import lapr.project.data.CargoManifestStore;
import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;

public class WareHouseController {

    public String getWareHouseAvailabilty() throws IOException, SQLException {
        String result="";
        DatabaseConnection databaseConnection = null;

        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        result=cargoManifestStore.wareHouseOccupancyByDate(databaseConnection);

        return result;
    }

    public String getWareHouseEstimation() throws IOException {
        String result="";
        DatabaseConnection databaseConnection = null;

        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        result=cargoManifestStore.wareHouseEstimation(databaseConnection);

        return result;
    }


    public String getResourceList(int portId, String day) throws IOException {

        String result="";
        DatabaseConnection databaseConnection = null;

        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        result=cargoManifestStore.getResourceList(databaseConnection,portId,day);

        return result;
    }
}
