package lapr.project.model.SeaDist;

import java.util.Objects;

public class SeaDist {

    private String fCountry;
    private String fPortId;
    private String fPort;
    private String tCountry;
    private String tPortId;
    private String tPort;
    private int dist;

    public SeaDist(String fCountry, String fPortId, String fPort, String tCountry, String tPortId, String tPort, int dist) {
        this.fCountry = fCountry;
        this.fPortId = fPortId;
        this.fPort = fPort;
        this.tCountry = tCountry;
        this.tPortId = tPortId;
        this.tPort = tPort;
        this.dist = dist;
    }

    public String getfCountry() {
        return fCountry;
    }

    public void setfCountry(String fCountry) {
        this.fCountry = fCountry;
    }

    public String getfPortId() {
        return fPortId;
    }

    public void setfPortId(String fPortId) {
        this.fPortId = fPortId;
    }

    public String getfPort() {
        return fPort;
    }

    public void setfPort(String fPort) {
        this.fPort = fPort;
    }

    public String gettCountry() {
        return tCountry;
    }

    public void settCountry(String tCountry) {
        this.tCountry = tCountry;
    }

    public String gettPortId() {
        return tPortId;
    }

    public void settPortId(String tPortId) {
        this.tPortId = tPortId;
    }

    public String gettPort() {
        return tPort;
    }

    public void settPort(String tPort) {
        this.tPort = tPort;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeaDist seaDist = (SeaDist) o;
        return dist == seaDist.dist && fCountry.equals(seaDist.fCountry) && fPortId.equals(seaDist.fPortId) && fPort.equals(seaDist.fPort) && tCountry.equals(seaDist.tCountry) && tPortId.equals(seaDist.tPortId) && tPort.equals(seaDist.tPort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fCountry, fPortId, fPort, tCountry, tPortId, tPort, dist);
    }
}
