package lapr.project.model.Country;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Country {
    private String continent;
    private String a2;
    private String a3;
    private String name;
    private String pop;
    private String cap;
    private double lat;
    private double longi;
    private Set borders;

    public Country(String continent, String a2, String a3, String name, String pop, String cap, double lat, double longi) {
        this.continent = continent;
        this.a2 = a2;
        this.a3 = a3;
        this.name = name;
        this.pop = pop;
        this.cap = cap;
        this.lat = lat;
        this.longi = longi;
        this.borders = new HashSet();
    }



    private boolean addBorder(Country oPais) {
        return this.borders.add(oPais);
    }

    public static boolean addBorder(Country oPais1, Country oPais2) {
        return (oPais1.addBorder(oPais2)
                && oPais2.addBorder(oPais1));
    }


    public Set<Country> getFronteiras() {
        return this.borders;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.lat, lat) == 0 && Double.compare(country.longi, longi) == 0 && continent.equals(country.continent) && a2.equals(country.a2) && a3.equals(country.a3) && name.equals(country.name) && pop.equals(country.pop) && cap.equals(country.cap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continent, a2, a3, name, pop, cap, lat, longi);
    }
}
