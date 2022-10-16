package lapr.project.data;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ContainerStore implements Persistable{
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        return false;
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }

    public String getContainerInfo(DatabaseConnection databaseConnection,int clientId, int containerNumber) throws SQLException {
        /**Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_ContainerInfo(?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,clientId);
            callfunctions.setInt(2,containerNumber);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){
                    result += String.format("%10s" + "%10s" , resultSet.getString(1),
                            resultSet.getString(2) + "\n");
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;**/


        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_ContainerInfo(?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,clientId);
            callfunctions.setInt(3,containerNumber);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" +"%10s"+ resultSet.getString(1),resultSet.getString(2));
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }



}

