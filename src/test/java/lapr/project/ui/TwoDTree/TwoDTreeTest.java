package lapr.project.ui.TwoDTree;

import lapr.project.model.Ports.Port;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TwoDTreeTest {

    /**
     * Test of isEmpty method, of class TwoDTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        TwoDTree instance = new TwoDTree();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class TwoDTree.
     */
    @Test
    public void testInsert() throws FileNotFoundException {
        System.out.println("insert");

        TwoDTree<Port> instance = new TwoDTree();
        Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
        Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
        Port port2 = new Port ("Europe","Denmark",10358,"Aarhus",56.15,10.21666667);
        Port port3 = new Port("Europe","Denmark",10563,"Copenhagen",55.7,12.61666667);
        Port port4 = new Port ("America","Peru",10860,"Matarani",-17.00,-72.1);
        Port port5 = new Port ("Europe","Italy",11174,"Genoa",44.4,8.933333333);
        //new elements
        instance.insert(port);
        instance.insert(port1);
        instance.insert(port2);
        instance.insert(port3);
        instance.insert(port4);
        instance.insert(port5);
        TwoDTree<Port> doisDCallSign = new TwoDTree<>();
        File file = new File("bports.csv");

        Scanner in = new Scanner(file);
        String line = in.nextLine();
        int i = 0;

        while (i < 6) {
            String read[] = in.nextLine().trim().split(",");
            Port portTest = new Port(read[0],read[1],Integer.parseInt(read[2]),read[3],Double.parseDouble(read[4]),Double.parseDouble(read[5]));
            doisDCallSign.insert(portTest);
            i++;
        }
        assertEquals(instance.size(),6);
        }
/*
       @Test
       public void findNearestNeighbourTest(){
           Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
           Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
           Port port2 = new Port ("Europe","Denmark",10358,"Aarhus",56.15,10.21666667);
           TwoDTree<Port> doisDCallSign = new TwoDTree<>();
           doisDCallSign.insert(port);
           doisDCallSign.insert(port1);
           doisDCallSign.insert(port2);
           // deve retornar o port2 já que é o porto mais proximo as coordenadas inseridas
           Node closestNode = doisDCallSign.findNearestNeighbour(56.00,10.29);
           assertEquals(port2,closestNode.info);
       }
*/
    @Test
    public void testSize() {
        System.out.println("size");
        Port port = new Port("Europe","Cyprus",10136,"Larnaca",34.91666667,33.65);
        Port port1 = new Port ("Europe","Malta",10138,"Marsaxlokk",35.84194,14.54306);
        Port port2 = new Port ("Europe","Denmark",10358,"Aarhus",56.15,10.21666667);
        // tem coordenadas iguais ao port2 logo nao deve ser inserida na arvore
        Port port4 = new Port ("Europe","Malta",10358,"Aarhus",56.15,10.21666667);

        TwoDTree<String> sInstance = new TwoDTree();
        assertEquals(sInstance.size(), 0);
        sInstance.insert(port);
        assertEquals(sInstance.size(), 1);
        sInstance.insert(port1);
        assertEquals(sInstance.size(), 2);
        sInstance.insert(port2);
        assertEquals(sInstance.size(), 3);
        sInstance.insert(port4);
        assertEquals(sInstance.size(), 3);

    }







    }
