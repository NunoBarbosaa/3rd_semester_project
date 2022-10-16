package lapr.project.data;

import lapr.project.data.CargoManifestStore;
import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;

import java.io.IOException;

public class AuditTrailController {

    public static String getAuditTrail() throws IOException {
        String result="";
        DatabaseConnection databaseConnection = null;

        databaseConnection = ConnectionFactory.getInstance()
                .getDatabaseConnection();
        CargoManifestStore cargoManifestStore = new CargoManifestStore();
        result=cargoManifestStore.getAuditTrail(databaseConnection);

        return result;
    }
}
