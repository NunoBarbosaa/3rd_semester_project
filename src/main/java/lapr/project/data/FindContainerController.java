package lapr.project.data;

import lapr.project.data.ConnectionFactory;
import lapr.project.data.ContainerStore;
import lapr.project.data.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;

public class FindContainerController {

    public String findContainer(int clientId,int containerId) throws SQLException, IOException {
        DatabaseConnection databaseConnection;

            databaseConnection = ConnectionFactory.getInstance()
                    .getDatabaseConnection();
            ContainerStore containerStore = new ContainerStore();
        String result=containerStore.getContainerInfo(databaseConnection, clientId,containerId);
        return result;


        }

    }

