package lapr.project.data;

import org.apache.commons.collections.list.SynchronizedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author João Fernandes 1201450
 */
public class Insulation {

    public static List<String> getMaterials(double tempToBeKeptInCelsius, double ambientTempInCelsius) {
        List<String> result = new ArrayList<>();
        Material styrofoam = new Material(1131, "Styrofoam");
        Material SprayFoam = new Material(1.57,"Spray foam");
        double difference = ambientTempInCelsius - tempToBeKeptInCelsius;
        return result;
    }
}
