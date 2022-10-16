package lapr.project.data;

/**
 * @author João Fernandes 1201450
 */
public class Material {
    //specific heat capacity in joules per celsius
    double specificHeatCapacity;
    //name of the material
    String name;

    private double heatCapacity_by_omission = 0;
    private String name_by_omission = "Unnamed";

    /**
     * Creates an object Material and defines its characteristics
     * @param specificHeatCapacity specific heat capacity of the material
     * @param name name of the material
     */
    Material(double specificHeatCapacity, String name) {
        this.specificHeatCapacity = specificHeatCapacity;
        this.name = name;
    }

    /**
     * Creates an object Material with parameters by omission
     */
    Material() {
        this.name = name_by_omission;
        this.specificHeatCapacity = heatCapacity_by_omission;
    }
    //getters
    double getSpecificHeatCapacity() {
        return this.specificHeatCapacity;
    }

    String getName() {
        return this.name;
    }
    //setters
    void setSpecificHeatCapacity(double heatCapacity) {
        this.specificHeatCapacity = heatCapacity;
    }

    void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return String.format("Specific Heat Capacity in joules per celsius: "+getSpecificHeatCapacity()+"\n"+":"+getName());
    }
}
