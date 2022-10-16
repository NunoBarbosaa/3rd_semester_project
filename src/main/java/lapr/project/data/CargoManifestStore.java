package lapr.project.data;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CargoManifestStore implements Persistable{
    @Override
    public boolean save(DatabaseConnection databaseConnection, Object object) {
        return false;
    }

    @Override
    public boolean delete(DatabaseConnection databaseConnection, Object object) {
        return false;
    }

    public String shipOccupancy(DatabaseConnection databaseConnection, int cargoManifestId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_OccupancyByCargo(?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,cargoManifestId);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()) {

                    result = String.format("%10s" + "%10s" + "%10s", resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }
    public String shipOccupancyByDate(DatabaseConnection databaseConnection, int MMSI,String date) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_OccupancyAtMoment(?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,MMSI);
            callfunctions.setString(3,date);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result = String.format("%10s" + "%10s" + "%10s", resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }

    public String shipAvailability(DatabaseConnection databaseConnection, String date) {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_shipAvailability(?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setString(2,date);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while(resultSet.next()){
                result+= (resultSet.getString(1))+"\n";
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }

    public String wareHouseOccupancyByDate (DatabaseConnection databaseConnection) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_wareHouseOccupancyRate()}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s", resultSet.getInt(1), resultSet.getInt(2) + "\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }


    public String wareHouseEstimation(DatabaseConnection databaseConnection) {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_wareHouseContainerEstimate()}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s", resultSet.getInt(1), resultSet.getInt(2) + "\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }

    public String getAuditTrail(DatabaseConnection databaseConnection) {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call  fnc_getAuditTrail()}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s" + "%10s" + "%10s" + "%10s" +"%10s",resultSet.getInt(1),resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4),resultSet.getInt(5), resultSet.getInt(6) + "\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }

    public String getResourceList(DatabaseConnection databaseConnection, int portId, String day) {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_ResourceList(?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,portId);
            callfunctions.setString(3,day);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s" + "%10s"  ,resultSet.getInt(1),
                            resultSet.getInt(2), resultSet.getInt(3));
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;

    }

    public String averageOccupancyRate(DatabaseConnection databaseConnection, int mmsi, String startDate) {
        Scanner in = new Scanner(System.in);
        System.out.println("What's the FINAL date?");
        String finalDate = in.next();
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_averageOccupancyRate(?,?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,mmsi);
            callfunctions.setString(3,startDate);
            callfunctions.setString(4,finalDate);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s"   ,resultSet.getInt(1), resultSet.getInt(2) +"\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;


    }

    public String getLoadingMap(DatabaseConnection databaseConnection) {
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_LoadingMap()}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()){;
                    result += String.format("%10s" + "%10s" + "%10s" +"%10s"  ,resultSet.getString(1)+"         ",resultSet.getInt(2)+ "         ",
                            resultSet.getString(3) +"         " , resultSet.getString(4) +"\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }

    public String getTripsThreshHold(DatabaseConnection databaseConnection, int mmsi, String startDate ) {
        Scanner in = new Scanner(System.in);
        System.out.println("whats the ending date? YYYY-MM-DD");
        String endDate = in.nextLine();
        Connection connection = databaseConnection.getConnection();
        String result="";
        try (CallableStatement callfunctions = connection.prepareCall("{?=call fnc_tripThreshHold(?,?,?)}")){
            callfunctions.registerOutParameter(1, OracleTypes.CURSOR);
            callfunctions.setInt(2,mmsi);
            callfunctions.setString(3,startDate);
            callfunctions.setString(4,endDate);
            callfunctions.execute();
            try (ResultSet resultSet =(ResultSet) callfunctions.getObject(1)) {
                while (resultSet.next()) {
                    ;
                    result += String.format("%10s" + "%10s" + "%10s" + "%10s" + "%10s" + "%10s", resultSet.getInt(1)+"     ",
                            resultSet.getString(2)+"    ", resultSet.getString(3)+"         " ,
                                    resultSet.getString(4)+"     ", resultSet.getString(5)+"    " ,resultSet.getString(6)+"\n");
                }
            }
            return result;
        }catch (SQLException tt){tt.printStackTrace();}
        return null;
    }
}
