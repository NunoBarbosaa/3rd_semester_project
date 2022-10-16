package lapr.project.data;

import java.text.DecimalFormat;

public class SinkController {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.000");

    public String Sink(int shipMass, int comp, int larg, int containerMass, int numContainers) {

        double massVolWater = 1030;
        double massShipWithContainers = shipMass + (containerMass * numContainers);
        double gravidade = 9.8;
        double weight= massShipWithContainers * gravidade;
        double area = comp * larg;
        double pressao = weight / area;
        double alt1= massShipWithContainers / (massVolWater*comp*larg);
        double alt2=shipMass / (massVolWater * comp * larg);
        double afundou = alt1 - alt2;
        String ship =  " The ship dive " + decimalFormat.format(afundou) + " meters when we added "  + numContainers + " container(s).\nThe pressure on the water is " + pressao + " Newton/Meter ";
        return ship;
    }

}
