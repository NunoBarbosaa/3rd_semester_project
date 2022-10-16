package lapr.project.model;

import java.util.ArrayList;
import java.util.Objects;


public class DBCountry {

    private String name;
    private float population;
    private String alphaCode2;
    private String alphaCode3;
    private int continentId;


    public DBCountry(String name, float population, String alphaCode2, String alphaCode3, int continentId) {
        this.name = name;
        this.population = population;
        this.alphaCode2 = alphaCode2;
        this.alphaCode3 = alphaCode3;
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public String getAlphaCode2() {
        return alphaCode2;
    }

    public void setAlphaCode2(String alphaCode2) {
        this.alphaCode2 = alphaCode2;
    }

    public String getAlphaCode3() {
        return alphaCode3;
    }

    public void setAlphaCode3(String alphaCode3) {
        this.alphaCode3 = alphaCode3;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", alphaCode2='" + alphaCode2 + '\'' +
                ", alphaCode3='" + alphaCode3 + '\'' +
                ", continentId=" + continentId +
                '}';
    }

}