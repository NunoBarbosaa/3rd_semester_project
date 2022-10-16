/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;
import lapr.project.model.Country.Country;
import lapr.project.model.Ports.Port;
import lapr.project.model.SeaDist.SeaDist;
import lapr.project.model.Ship.Ship;
import lapr.project.model.Ship.ShipDynamicFields;
import lapr.project.model.Ship.ShipOrderedByCallSign;
import lapr.project.model.Ship.ShipOrderedByIMO;
import lapr.project.ui.TwoDTree.TwoDTree;
import lapr.project.data.AVL;
import lapr.project.model.DBCountry;


import java.io.*;
import java.util.*;

/**
 *
 * @author kevin
 */
public class LoaderController {

    public static AVL<Ship> loadShipsByMmsi(String fileName) throws FileNotFoundException {
        AVL<Ship> avlMmsi = new AVL<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            Ship ship = new Ship(Integer.parseInt(read[0]), read[7], read[8], read[9], Integer.parseInt(read[10]),
                    Integer.parseInt(read[11]), Integer.parseInt(read[12]), Float.parseFloat(read[13]), read[14]);
            avlMmsi.insert(ship);
        }
        return avlMmsi;
    }

    public static AVL<Ship> loadShipsByCallSign(String fileName) throws FileNotFoundException {
        AVL<Ship> avlCallSign = new AVL<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            ShipOrderedByCallSign ship = new ShipOrderedByCallSign(Integer.parseInt(read[0]), read[7], read[8], read[9], Integer.parseInt(read[10]),
                    Integer.parseInt(read[11]), Integer.parseInt(read[12]), Float.parseFloat(read[13]), read[14]);
            avlCallSign.insert(ship);
        }
        return avlCallSign;
    }


    public static AVL<Ship> loadShipsByIMO(String fileName) throws FileNotFoundException {
        AVL<Ship> avlIMO = new AVL<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            ShipOrderedByIMO shipIMO = new ShipOrderedByIMO(Integer.parseInt(read[0]), read[7], read[8], read[9], Integer.parseInt(read[10]),
                    Integer.parseInt(read[11]), Integer.parseInt(read[12]), Float.parseFloat(read[13]), read[14]);
            avlIMO.insert(shipIMO);
        }
        return avlIMO;
    }

    public static TwoDTree<Port> loadPortsTwoDTree(String fileName) throws FileNotFoundException {
        TwoDTree<Port> doisDCallSign = new TwoDTree<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String skipHeader = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            Port port = new Port((read[0]),read[1],Integer.parseInt(read[2]),read[3],Double.parseDouble(read[4]),Double.parseDouble(read[5]));
            doisDCallSign.insert(port);
        }
        return doisDCallSign;
    }

    public static List<ShipDynamicFields> loadDynamicFields(String fileName) throws FileNotFoundException {
        List<ShipDynamicFields> listaShipD = new ArrayList<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            ShipDynamicFields ship = new ShipDynamicFields(Integer.parseInt(read[0]), read[1], Double.parseDouble(read[2]), Double.parseDouble(read[3]), Double.parseDouble(read[4]), Double.parseDouble(read[5]), Integer.parseInt(read[6]), read[15]);
            listaShipD.add(ship);
        }
        return listaShipD;

    }


    public static HashMap<Ship, List<ShipDynamicFields>> mapShipData(List<ShipDynamicFields> list, AVL<Ship> avl) {
        HashMap<Ship, List<ShipDynamicFields>> map = new HashMap<>();
        Iterable<Ship> avlList = avl.preOrder();
        for (Ship ship : avlList) {
            List<ShipDynamicFields> aux = new ArrayList<>();
            for (ShipDynamicFields sdf : list) {
                if (ship.getMmsi() == sdf.getMMSI()) {
                    aux.add(sdf);
                }
            }
            map.put(ship, aux);
        }
        return map;


    }

        public static List<Country> loadCountry(String fileName) throws FileNotFoundException {
            List<Country> listCountry = new ArrayList<>();
            File file = new File(fileName);

            Scanner in = new Scanner(file);
            String line = in.nextLine();

            while (in.hasNextLine()) {
                String read[] = in.nextLine().trim().split(",");
                Country country = new Country(read[0],read[1],read[2],read[3],read[4],read[5],Double.parseDouble(read[6]),Double.parseDouble(read[7]));
                listCountry.add(country);
            }
            return listCountry;

    }

    public static Country matchCountry(String strNome, List<Country> lstCountries) {
        for (Country oPais : lstCountries) {
            if (oPais.getName().equalsIgnoreCase(strNome)) {
                return oPais;
            }
        }
        return null;
    }

    public static void loadBorders(String fileName, List<Country> lstCountries) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();
        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(", ");
            String pais1 = read[0];
            String pais2 = read[1].replaceAll(",","");
            Country oPais1 = matchCountry(pais1, lstCountries);
            Country oPais2 = matchCountry(pais2, lstCountries);
            if ((oPais1 != null && oPais2 != null) && oPais1 != oPais2) {
                Country.addBorder(oPais1, oPais2);
            }
        }
    }

    public static List<SeaDist> loadDist(String fileName) throws FileNotFoundException {
        List<SeaDist> listDist = new ArrayList<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        String line = in.nextLine();

        while (in.hasNextLine()) {
            String read[] = in.nextLine().trim().split(",");
            SeaDist seaDist = new SeaDist(read[0],read[1],read[2],read[3],read[4],read[5],Integer.parseInt(read[6]));
            listDist.add(seaDist);
        }
        return listDist;
    }

    public static List<Port> loadPorts(String fileName) throws FileNotFoundException{
        List<Port> portList = new ArrayList<>();
        File file = new File(fileName);

        Scanner in = new Scanner(file);
        Scanner in2= new Scanner(file);
        String line = in.nextLine();
            while (in.hasNextLine()) {
                String read[] = in.nextLine().trim().split(",");
                Port port = new Port((read[0]),read[1],Integer.parseInt(read[2]),read[3],Double.parseDouble(read[4]),Double.parseDouble(read[5]));
                portList.add(port);
            }
            while (in2.hasNextLine()) {
            String read[] = in2.nextLine().trim().split(",");
                Port port = new Port((read[0]),read[1],Integer.parseInt(read[2]),read[3],Double.parseDouble(read[4]),Double.parseDouble(read[5]));
            portList.add(port);
            }
            return portList;
    }
    public static HashMap<Country, List<Port>> mapPortCountry (List<Country> c, List<Port> p){
        HashMap<Country, List<Port>> map = new HashMap<>();
        for (Country country : c) {
            List<Port> aux = new ArrayList<>();
            for (Port port : p) {
                if (country.getName() == port.getCountry()) {
                    aux.add(port);
                }
            }
            map.put(country, aux);
        }
        return map;
    }

}
