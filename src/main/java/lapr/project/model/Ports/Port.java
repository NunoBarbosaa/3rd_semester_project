package lapr.project.model.Ports;

import java.util.Objects;

public class Port {
    private String continent;
    private String country;
    private int code;
    private String port;
    private Double lat;
    private Double lon;
    public Port(String continent, String country, int code, String port, Double lat, Double lon) {
        this.continent = continent;
        this.country = country;
        this.code = code;
        this.port = port;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Port: \n" +
                "continent=" + continent + '\n' +
                "country='" + country + '\n' +
                "code=" + code + '\n' +
                "port='" + port + '\n' +
                "lat=" + lat + '\n' +
                "lon=" + lon;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public int getCode() {
        return code;
    }

    public String getPort() {
        return port;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Port)) return false;
        Port port1 = (Port) o;
        return code == port1.code && continent.equals(port1.continent) && country.equals(port1.country) && port.equals(port1.port) && lat.equals(port1.lat) && lon.equals(port1.lon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continent, country, code, port, lat, lon);
    }
}
