package lapr.project.model.Ship;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ShipDynamicFields implements Comparable<ShipDynamicFields> {


   private String dateTime;
   private double lon;
   private double lat;
   private double sog;
   private double cog;
   private int heading;
   private int position;
   private final int mmsi;
   private String transceiverClass;


    public ShipDynamicFields(){
        mmsi = 0;
        dateTime = "0";
        lon = 0;
        lat = 0;
        sog =0;
        cog= 0;
        heading =0;
        position=0;
        transceiverClass=null;
    }

    public ShipDynamicFields(int mmsi ,String dateTime, double lat, double lon, double sog, double cog, int heading, String transceiverClass) {
        this.mmsi = mmsi;
        this.dateTime = dateTime;
        this.lon = lon;
        this.lat = lat;
        this.sog = sog;
        this.cog = cog;
        this.heading = heading;
        this.transceiverClass=transceiverClass;
    }

    public int getMMSI(){return mmsi;}

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(float sog) {
        this.sog = sog;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(float cog) {
        this.cog = cog;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTransceiverClass() {
        return transceiverClass;
    }

    public void setTransceiverClass(String transceiverClass) {
        this.transceiverClass = transceiverClass;
    }

/*
    public static ShipDynamicFields checkLastPosition(int mmsi, int hour, int minutes, HashMap<Ship, List<ShipDynamicFields>> shipMap) throws FileNotFoundException {
        ShipDynamicFields finalShip = null;
        int minHoras = 99999;
        int minMinutes = 99999;
        int difHoras;
        int difMinutos;

        for (Ship ship : shipMap.keySet()) {

            for (List<ShipDynamicFields> ships : shipMap.values()) {
                for (ShipDynamicFields shipDynamicFields : ships) {
                    if (mmsi == shipDynamicFields.getMMSI()) {
                        String read[] = shipDynamicFields.getDateTime().split(" ");
                        String DiaAno = read[0];
                        String Hora = read[1];
                        String read2[] = Hora.split(":");
                        int hour1 = Integer.parseInt(read2[0]);
                        int minutes2 = Integer.parseInt(read2[1]);
                        difHoras = hour - hour1;
                        difMinutos = minutes - minutes2;
                        if(difHoras==0 && difMinutos == 0){
                             finalShip = shipDynamicFields;
                            return finalShip;
                        }
                        if (difHoras < minHoras && difHoras >= 0) {
                            if (difMinutos < 0) {
                                difHoras = difHoras - 1;
                                difMinutos = 60 + difMinutos;
                                if (difHoras < minHoras) {
                                    minHoras = difHoras;
                                    minMinutes =difMinutos;
                                    finalShip = shipDynamicFields;
                                }
                                if (difHoras == minHoras && difMinutos<minMinutes) {
                                    minHoras = difHoras;
                                    minMinutes =difMinutos;
                                    finalShip = shipDynamicFields;
                                }
                            } else {
                                minHoras = difHoras;
                                minMinutes = difMinutos;
                                finalShip = shipDynamicFields;
                            }
                        }
                    }
                }
            }
        }
        return finalShip;
    }

    public static ShipDynamicFields checkLastPositionUpgrade(Date year, LocalTime hours, List<ShipDynamicFields> ships) throws FileNotFoundException, ParseException {
        ShipDynamicFields finalShip = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        long minHoras = 999999999;
        long minMinutes = 999999999;
        long minDias = 999999;
        long difHoras;
        long difMinutos;
        long difDias;

                for (ShipDynamicFields shipDynamicFields : ships) {
                    String read[] = shipDynamicFields.getDateTime().split(" ");
                    String diaAno = read[0];
                    Date ano = sdf.parse(diaAno);
                    LocalTime hora = LocalTime.parse(read[1]);
                    difHoras = hours.getHour() - hora.getHour();
                    difMinutos = hours.getMinute() - hora.getMinute();
                    long dif = year.getTime() - ano.getTime();
                    difDias = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
                    if (difHoras == 0 && difMinutos == 0 && difDias == 0) {
                        finalShip = shipDynamicFields;
                        return finalShip;
                    }
                    if (difMinutos < 0) {
                        difHoras = difHoras - 1;
                        difMinutos = 60 + difMinutos;
                    }
                    if (difDias >= 0 && difDias <= minDias) {
                        difHoras = difHoras + (difDias * 24);
                        if (difHoras <= minHoras && difHoras >= 0) {
                            if (difHoras < minHoras) {
                                minHoras = difHoras;
                                minMinutes = difMinutos;
                                minDias = difDias;
                                finalShip = shipDynamicFields;
                            }
                            if (difHoras == minHoras && difMinutos < minMinutes && difDias >= 0 && difDias <= minDias) {
                                minHoras = difHoras;
                                minMinutes = difMinutos;
                                minDias = difDias;
                                finalShip = shipDynamicFields;
                            }
                        }
                    }
                }

        return finalShip;
    }
    */


    @Override
    public String toString() {
        return "ShipDynamicFields{" +
                "dateTime='" + dateTime + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                ", sog=" + sog +
                ", cog=" + cog +
                ", heading=" + heading +
                ", position=" + position +
                ", mmsi=" + mmsi +
                ", transceiverClass='" + transceiverClass + '\'' +
                '}';
    }

    @Override
    public int compareTo(ShipDynamicFields o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDynamicFields)) return false;
        ShipDynamicFields that = (ShipDynamicFields) o;
        return Double.compare(that.lon, lon) == 0 && Double.compare(that.lat, lat) == 0 && Double.compare(that.sog, sog) == 0 && Double.compare(that.cog, cog) == 0 && heading == that.heading && position == that.position && mmsi == that.mmsi && Objects.equals(dateTime, that.dateTime) && Objects.equals(transceiverClass, that.transceiverClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, lon, lat, sog, cog, heading, position, mmsi, transceiverClass);
    }
}
