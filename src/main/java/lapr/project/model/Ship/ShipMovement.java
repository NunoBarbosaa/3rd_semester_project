package lapr.project.model.Ship;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

public class ShipMovement {
    @CsvBindByName
    private int mmsi;
    @CsvBindByName
    @CsvDate("dd/mm/yyyy HH:mm")
    private Date baseDateTime;
    @CsvBindByName
    private double lat;
    @CsvBindByName
    private double lon;
    @CsvBindByName
    private double sog;
    @CsvBindByName
    private double cog;
    @CsvBindByName
    private int heading;
    @CsvBindByName
    private String vesselName;
    @CsvBindByName
    private String imo;
    @CsvBindByName
    private String callSign;
    @CsvBindByName
    private int vesselType;
    @CsvBindByName
    private int length;
    @CsvBindByName
    private int width;
    @CsvBindByName
    private float draft;
    @CsvBindByName
    private String cargo;
    @CsvBindByName(column = "transcieverClass")
    private String transceiverClass;

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public Date getBaseDateTime() {
        return baseDateTime;
    }

    public void setBaseDateTime(Date baseDateTime) {
        this.baseDateTime = baseDateTime;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getSog() {
        return sog;
    }

    public void setSog(double sog) {
        this.sog = sog;
    }

    public double getCog() {
        return cog;
    }

    public void setCog(double cog) {
        this.cog = cog;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getVesselType() {
        return vesselType;
    }

    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getDraft() {
        return draft;
    }

    public void setDraft(float draft) {
        this.draft = draft;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTransceiverClass() {
        return transceiverClass;
    }

    public void setTransceiverClass(String transceiverClass) {
        this.transceiverClass = transceiverClass;
    }
}
