package lapr.project.data;

import lapr.project.controller.ShipDistanceController;
import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipDynamicFields;

import java.io.FileNotFoundException;
import java.util.*;


public class ShipDistance {
    private int mmsi;

    private String vesselName;
    private String startTime;
    private String endTime;
    private int totalMovements;
    private String totalTime;
    private double maxSog;
    private double meanSog;
    private double maxCog;
    private double meanCog;
    private double depLatitude;
    private double arrLatitude;
    private double depLong;
    private double arrLong;
    private double travDis;
    private double deltDis;


    public ShipDistance() throws FileNotFoundException {}

    public ShipDistance(int mmsi, String vesselName, String startTime, String endTime, int totalMovements, String totalTime, double maxSog, double meanSog, double maxCog, double meanCog, double depLatitude, double arrLatitude, double depLong, double arrLong, double travDis, double deltDis) throws FileNotFoundException {
        this.mmsi = mmsi;
        this.vesselName = vesselName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalMovements = totalMovements;
        this.totalTime = totalTime;
        this.maxSog = maxSog;
        this.meanSog = meanSog;
        this.maxCog = maxCog;
        this.meanCog = meanCog;
        this.depLatitude = depLatitude;
        this.arrLatitude = arrLatitude;
        this.depLong = depLong;
        this.arrLong = arrLong;
        this.travDis = travDis;
        this.deltDis = deltDis;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    @Override
    public String toString() {
        return "ShipDistance{" +
                "mmsi=" + mmsi +
                ", vesselName='" + vesselName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", totalMovements=" + totalMovements +
                ", totalTime='" + totalTime + '\'' +
                ", maxSog=" + maxSog +
                ", meanSog=" + meanSog +
                ", maxCog=" + maxCog +
                ", meanCog=" + meanCog +
                ", depLatitude=" + depLatitude +
                ", arrLatitude=" + arrLatitude +
                ", depLong=" + depLong +
                ", arrLong=" + arrLong +
                ", travDis=" + travDis +
                ", deltDis=" + deltDis +
                '}';
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTotalMovements() {
        return totalMovements;
    }

    public void setTotalMovements(int totalMovements) {
        this.totalMovements = totalMovements;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public double getMaxSog() {
        return maxSog;
    }

    public void setMaxSog(double maxSog) {
        this.maxSog = maxSog;
    }

    public double getMeanSog() {
        return meanSog;
    }

    public void setMeanSog(double meanSog) {
        this.meanSog = meanSog;
    }

    public double getMaxCog() {
        return maxCog;
    }

    public void setMaxCog(double maxCog) {
        this.maxCog = maxCog;
    }

    public double getMeanCog() {
        return meanCog;
    }

    public void setMeanCog(double meanCog) {
        this.meanCog = meanCog;
    }

    public double getDepLatitude() {
        return depLatitude;
    }

    public void setDepLatitude(double depLatitude) {
        this.depLatitude = depLatitude;
    }

    public double getArrLatitude() {
        return arrLatitude;
    }

    public void setArrLatitude(double arrLatitude) {
        this.arrLatitude = arrLatitude;
    }

    public double getDepLong() {
        return depLong;
    }

    public void setDepLong(double depLong) {
        this.depLong = depLong;
    }

    public double getArrLong() {
        return arrLong;
    }

    public void setArrLong(double arrLong) {
        this.arrLong = arrLong;
    }

    public double getTravDis() {
        return travDis;
    }

    public void setTravDis(double travDis) {
        this.travDis = travDis;
    }

    public double getDeltDis() {
        return deltDis;
    }

    public void setDeltDis(double deltDis) {
        this.deltDis = deltDis;
    }


    public static int getTotalMovements(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        int counter = 0;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String getTotalTime(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        int minHora = 25;
        int minMin = 61;
        int maxHora = -1;
        int maxMin = -1;
        int difHora = 0;
        int difMin = 0;

        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    String read = shipDynamicFields.getDateTime().split("/s")[0];
                    String hora = read.split(" ")[1];
                    String[] read2 = hora.split(":");
                    int hour = Integer.parseInt(read2[0]);
                    int minutes = Integer.parseInt(read2[1]);
                    if (hour < minHora) {
                        minHora = hour;
                        minMin = minutes;
                    }
                    if (hour == minHora && minutes < minMin) {
                        minHora = hour;
                        minMin = minutes;
                    }
                    if (hour > maxHora) {
                        maxHora = hour;
                        maxMin = minutes;
                    }
                    if (hour == maxHora && minutes > maxMin) {
                        maxHora = hour;
                        maxMin = minutes;
                    }
                    difHora = maxHora - minHora;
                    difMin = maxMin - minMin;
                    if (difMin < 0) {
                        difHora = difHora - 1;
                        difMin = 60 + difMin;
                    }
                }
            }
        }
        return String.valueOf(difHora) + ':' + difMin;
    }

    public static double maxCog(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        double min = -999999;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    if (shipDynamicFields.getCog() > min) {
                        min = shipDynamicFields.getCog();
                    }
                }
            }
        }
        return min;
    }

    public static double maxSog(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        double min = 0;
            for (List<ShipDynamicFields>ship : shipMap.values()) {
                for (ShipDynamicFields shipDynamicFields : ship) {
            if (shipDynamicFields.getMMSI() == mmsi) {
                if (shipDynamicFields.getSog() > min) {
                    min = shipDynamicFields.getSog();
                }
            }
        }
            }
        return min;
    }

    public static double meanCog(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        double counter = 0;
        double total = 0;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    total = total + shipDynamicFields.getCog();
                    counter++;

                }
            }
        }
        if(counter!=0) {
            return total / counter;
        }else
            return 0;
    }

    public static double meanSog(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        double counter = 0;
        double total = 0;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    total = total + shipDynamicFields.getSog();
                    counter++;

                }
            }
        }
        if(counter!=0) {
            return total / counter;
        }else
            return 0;
    }

    public static ShipDynamicFields minTime(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        int minHora = 25;
        int minMin = 61;

        ShipDynamicFields finalShip = null;
        for (List<ShipDynamicFields> ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    String read = shipDynamicFields.getDateTime().split("/s")[0];
                    String hora = read.split(" ")[1];
                    String[] read2 = hora.split(":");
                    int hour = Integer.parseInt(read2[0]);
                    int minutes = Integer.parseInt(read2[1]);
                    if (hour < minHora) {
                        minHora = hour;
                        minMin = minutes;
                        finalShip = shipDynamicFields;
                    }
                    if (hour == minHora && minutes < minMin) {
                        minHora = hour;
                        minMin = minutes;
                        finalShip = shipDynamicFields;
                    }
                }
            }
        }

        return finalShip;
    }

    public static ShipDynamicFields maxTime(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        int maxHora = -1;
        int maxMin = -1;
        ShipDynamicFields finalShip = null;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    String read = shipDynamicFields.getDateTime().split("/s")[0];
                    String hora = read.split(" ")[1];
                    String[] read2 = hora.split(":");
                    int hour = Integer.parseInt(read2[0]);
                    int minutes = Integer.parseInt(read2[1]);
                    if (hour > maxHora) {
                        maxHora = hour;
                        maxMin = minutes;
                        finalShip = shipDynamicFields;
                    }
                    if (hour == maxHora && minutes > maxMin) {
                        maxHora = hour;
                        maxMin = minutes;
                        finalShip = shipDynamicFields;
                    }
                }
            }
        }
        return finalShip;
    }

    public static double distDelta(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        ShipDynamicFields ship1 = ShipDistance.minTime(mmsi,shipMap);
        ShipDynamicFields ship2 = ShipDistance.maxTime(mmsi,shipMap);

        return distance(ship1.getLat(), ship2.getLat(), ship1.getLon(), ship2.getLon());


    }

    public static double distance(
            double lat1, double lat2, double lon1, double lon2
    ) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

    public static double totalDistance(int mmsi,HashMap<Ship, List<ShipDynamicFields>> shipMap) {
        double counter = 0;
        double lastLat = 0;
        double lastLon = 0;
        for (List<ShipDynamicFields>ship : shipMap.values()) {
            for (ShipDynamicFields shipDynamicFields : ship) {
                if (shipDynamicFields.getMMSI() == mmsi) {
                    if (lastLat == 0 && lastLon == 0) {
                        lastLat = shipDynamicFields.getLat();
                        lastLon = shipDynamicFields.getLon();
                    }
                    counter = counter + distance(shipDynamicFields.getLat(), lastLat, shipDynamicFields.getLon(), lastLon);
                    lastLat = shipDynamicFields.getLat();
                    lastLon = shipDynamicFields.getLon();
                }
            }
        }
        return counter;
    }
/*
    public static List<ShipDistance> mostKmFastShips(String dateOfCheck, String hourCheck, String hourCheck2, int numberOfResults, HashMap<Ship,List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        int i = 0;
        List<ShipDistance> temp = new ArrayList<>();
        List<ShipDistance> shipsFinal = new ArrayList<>();
        if (dateOfCheck == null || hourCheck == null || hourCheck2 == null || numberOfResults == 0 || shipMap == null)
            return null;
        for (List<ShipDynamicFields> ship : shipMap.values()){
            for (ShipDynamicFields ships : ship) {
                String read[] = ships.getDateTime().split(" ");
                String diaAno = read[0];
                String hora = read[1];
                String read1[] = hora.split(":");
                int hour = Integer.parseInt(read1[0]);
                int minutes = Integer.parseInt(read1[1]);
                String read2[] = hourCheck.split(":");
                int hour1 = Integer.parseInt(read2[0]);
                int minutes1 = Integer.parseInt(read2[1]);
                String read3[] = hourCheck2.split(":");
                int hour2 = Integer.parseInt(read3[0]);
                int minutes2 = Integer.parseInt(read3[1]);
                if (diaAno.equals(dateOfCheck) && (hour >= hour1 && hour <= hour2 ) && (minutes >= minutes1 && minutes <= minutes2)) {
                    ShipDistance shipAdd = ShipDistanceController.shipDistCalc(ships.getMMSI(),shipMap);
                    String readEnd[] = shipAdd.getEndTime().split(" ");
                    String diaAnoEnd = readEnd[0];
                    String horaEnd = readEnd[1];
                    String read1End[] = horaEnd.split(":");
                    int hourEnd = Integer.parseInt(read1End[0]);
                    int minutesEnd = Integer.parseInt(read1End[1]);
                    if(diaAnoEnd.equals(dateOfCheck) && (hourEnd >= hour1 && hourEnd <= hour2 ) && (minutesEnd >= minutes1 && minutesEnd <= minutes2)) {
                        temp.add(shipAdd);
                    }
                }
            }
        }
        Collections.sort(temp, new Comparator<ShipDistance>() {
            @Override
            public int compare(ShipDistance p1, ShipDistance p2) {
                return (int) (p1.totalDistance(p1.getMmsi(),shipMap) - p2.totalDistance(p2.getMmsi(),shipMap));
            }
        });
        for (ShipDistance shipsF : temp){
            while(i!=numberOfResults){
                shipsFinal.add(shipsF);
                i++;
            }
        }
        return shipsFinal;
    }

*/

       public static List<ShipDistance> orderShips(HashMap<Ship,List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        List<ShipDistance> shipsFinal = new ArrayList<>();

        for (List<ShipDynamicFields> ship : shipMap.values()){
           for (ShipDynamicFields ships : ship) {
               ShipDistance shipAdd = ShipDistanceController.shipDistCalc(ships.getMMSI(),shipMap);
                    shipsFinal.add(shipAdd);
            }
        }
       Collections.sort(shipsFinal, new Comparator<ShipDistance>() {
           @Override
            public int compare(ShipDistance p1, ShipDistance p2) {
                if(p1.travDis>p2.travDis){
                    return -1;
                } else if (p1.travDis< p2.travDis){
                    return 1;
                } else if(p1.totalMovements>p2.totalMovements){
                   return 1;
               } else if (p1.totalMovements< p2.totalMovements){
                   return -1;
               }

                return 0;
            }
        });
        return shipsFinal;
   }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDistance)) return false;
        ShipDistance that = (ShipDistance) o;
        return mmsi == that.mmsi && totalMovements == that.totalMovements && Double.compare(that.maxSog, maxSog) == 0 && Double.compare(that.meanSog, meanSog) == 0 && Double.compare(that.maxCog, maxCog) == 0 && Double.compare(that.meanCog, meanCog) == 0 && Double.compare(that.depLatitude, depLatitude) == 0 && Double.compare(that.arrLatitude, arrLatitude) == 0 && Double.compare(that.depLong, depLong) == 0 && Double.compare(that.arrLong, arrLong) == 0 && Double.compare(that.travDis, travDis) == 0 && Double.compare(that.deltDis, deltDis) == 0 && Objects.equals(vesselName, that.vesselName) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(totalTime, that.totalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mmsi, vesselName, startTime, endTime, totalMovements, totalTime, maxSog, meanSog, maxCog, meanCog, depLatitude, arrLatitude, depLong, arrLong, travDis, deltDis);
    }



}
