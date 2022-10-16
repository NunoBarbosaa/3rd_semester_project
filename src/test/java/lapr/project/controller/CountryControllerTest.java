package lapr.project.controller;

import lapr.project.model.Country.Country;
import lapr.project.model.Ports.Port;
import lapr.project.utils.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryControllerTest {

    final MatrixGraph<String,Double> completeMap = new MatrixGraph<>(false);
    MatrixGraph<String,Double> completeMapClone = new MatrixGraph<>(false);
    CountryController countryC = new CountryController();

    CountryControllerTest() throws FileNotFoundException {
    }

    @BeforeEach
    public void setUp() throws FileNotFoundException {

        completeMap.addVertex("Porto");
        completeMap.addVertex("Braga");
        completeMap.addVertex("Vila Real");
        completeMap.addVertex("Aveiro");
        completeMap.addVertex("Coimbra");
        completeMap.addVertex("Leiria");

        completeMap.addEdge("Porto", "Aveiro", 75.0);
        completeMap.addEdge("Porto", "Braga", 60.0);
        completeMap.addEdge("Porto", "Vila Real", 100.0);
        completeMap.addEdge("Aveiro", "Coimbra", 60.0);
        completeMap.addEdge("Coimbra", "Leiria", 80.0);
        completeMap.addEdge("Aveiro", "Leiria", 120.0);

        completeMapClone = completeMap.clone();

        countryC.buildGraph(5);
    }

    @Test
    void colorirMatrix() {
        countryC.setMatrixGraph(completeMapClone);
        System.out.println("Os Paises adjacentes a porto são Aveiro,Braga,Vila Real\n");
        System.out.println("Porto tem uma cor e como os outros paises não são adjacentes entre eles tem a mesma cor\n");
        System.out.println("Os paises adjacentes a aveiro são leiria e coimbra\n");
        System.out.println("Logo aveiro tem cor diferente  a leiria e coimbra\n");
        System.out.println("como coimbra e leira são adjacentes tem cores diferentes\n");

        countryC.ColorirMatrix();

    }

    @Test
    void colorirMapa1() {
        countryC.setMatrixGraph(null);
        System.out.println("Vai a mostra uma menssagem que diz ->  matriz vazia por favor preencher a matriz !!\n");

        countryC.ColorirMatrix();

    }

    @Test
    void getCountryByCap() {
        List<Country> lsCountry = countryC.listCountry();
        Country pais = countryC.getCountryByCap("Madrid",lsCountry);
        String paisR = pais.getName();
        String paisEx = "Spain";
        assertEquals(paisEx,paisR);
    }

    @Test
    void getCountryByCap1() {
        List<Country> lsCountry = countryC.listCountry();
        Country pais = countryC.getCountryByCap("Lisbon",lsCountry);
        String paisR = pais.getName();
        String paisEx = "Portugal";
        assertEquals(paisEx,paisR);
    }



    @Test
    void getCountryByCap2() {
        List<Country> lsCountry = countryC.listCountry();
        Country pais = countryC.getCountryByCap("Tirana",lsCountry);
        String paisR = pais.getName();
        String paisEx = "Albania";
        assertEquals(paisEx,paisR);
    }

    @Test
    void getPortByName() {
        List<Port> lstPort = countryC.listPorts();
        Port port = countryC.getPortByName("Larnaca",lstPort);
        String portR = port.getPort();
        String portP = port.getCountry();
        assertEquals("Larnaca",portR);
        assertEquals("Cyprus",portP);

    }

    @Test
    void getPortByName1() {
        List<Port> lstPort = countryC.listPorts();
        Port port = countryC.getPortByName("Marsaxlokk",lstPort);
        String portR = port.getPort();
        String portP = port.getCountry();
        assertEquals("Marsaxlokk",portR);
        assertEquals("Malta",portP);

    }

    @Test
    void listCountry() throws FileNotFoundException {
        List<Country> lstCountryExp = LoaderController.loadCountry("countries.csv");
        List<Country> lsCountryResult = countryC.listCountry();
        lstCountryExp.equals(lsCountryResult);
    }

    @Test
    void listPorts() throws FileNotFoundException {
        List<Port> lstPortExp = LoaderController.loadPorts( "bports.csv");
        List<Port> lsPortResult = countryC.listPorts();
        lstPortExp.equals(lsPortResult);
    }

    @Test
    void setMatrixGraph() {
        MatrixGraph<String, Double> matrix = countryC.getMatrix();
        countryC.setMatrixGraph(completeMapClone);
        matrix.equals(completeMapClone);
    }


 /*   @Test
    void buildGraph() throws FileNotFoundException {
        countryC.buildGraph(2);
        MatrixGraph<String,Double> res= countryC.getMatrixGraph();
        MatrixGraph<String,Double> exp = new MatrixGraph<>(false);
        exp.addVertex("Lisbon");
        exp.addVertex("Madrid");
        exp.addVertex("Paris");
        exp.addVertex("Leixoes");
        exp.addVertex("Setubal");
        exp.addVertex("Barcelona");
        exp.addVertex("Horta");
        exp.addVertex("Ponta Delgada");
        exp.addVertex("Valencia");
        exp.addVertex("Funchal");
        exp.addEdge("Lisbon", "Madrid",503206.50841593044 );
        exp.addEdge("Madrid", "Paris", 1054165.6571748783);
        exp.addEdge("Leixoes", "Barcelona", 907905.0641587445);
        exp.addEdge("Leixoes", "Setubal", 298945.61008204427);
        exp.addEdge("Leixoes", "Ponta Delgada", 1503559.016783181);
        exp.addEdge("Leixoes", "Funchal", 1196220.2266439092);
        exp.addEdge("Leixoes", "Horta", 1721420.6564798946);
        exp.addEdge("Leixoes", "Barcelona",907905.0641587445);
        exp.addEdge("Barcelona", "Valencia", 295770.089409461);
        exp.addEdge("Lisbon", "Horta",1689456.1161494716);
        exp.addEdge("Barcelona", "Madrid",502644.56016177934);
        exp.addEdge("Horta", "Setubal",1710645.7302179313);
        exp.addEdge("Funchal", "Ponta Delgada",974824.0114952982);
        exp.addEdge("Setubal", "Horta",1710645.7302179313);
        exp.addEdge("Ponta Delgada", "Horta",272904.8012705913);
        assertEquals(res, exp);
    }

*/

    @Test
    void closestPlacesByContinent() throws FileNotFoundException {
        countryC.buildGraph(3);
        HashMap<String, LinkedList<String>> res = countryC.closestPlacesByContinent(2);
        HashMap<String, LinkedList<String>> exp = new HashMap<>();
        LinkedList<String> aux1 = new LinkedList<>();
        LinkedList<String> aux2 = new LinkedList<>();
        aux1.add("Marsaxlokk");
        aux1.add("Belgrade");
        aux2.add("Cutuco");
        aux2.add("Puerto Quetzal");
        exp.put("Europe",aux1);
        exp.put("America", aux2);
        assertEquals(exp,res);
    }

    @Test
    void closestPlacesByContinent2() throws FileNotFoundException {
        countryC.buildGraph(3);
        HashMap<String, LinkedList<String>> res = countryC.closestPlacesByContinent(3);
        HashMap<String, LinkedList<String>> exp = new HashMap<>();
        LinkedList<String> aux1 = new LinkedList<>();
        LinkedList<String> aux2 = new LinkedList<>();
        aux1.add("Galatz");
        aux1.add("Marsaxlokk");
        aux1.add("Belgrade");
        aux2.add("Panama City");
        aux2.add("Cutuco");
        aux2.add("Puerto Quetzal");
        exp.put("Europe",aux1);
        exp.put("America", aux2);
        assertEquals(exp,res);
    }

    @Test
    void closestPlacesByContinent3() throws FileNotFoundException {
        countryC.buildGraph(3);
        HashMap<String, LinkedList<String>> res = countryC.closestPlacesByContinent(5);
        HashMap<String, LinkedList<String>> exp = new HashMap<>();
        LinkedList<String> aux1 = new LinkedList<>();
        LinkedList<String> aux2 = new LinkedList<>();
        aux1.add("Izola");
        aux1.add("Bucharest");
        aux1.add("Galatz");
        aux1.add("Marsaxlokk");
        aux1.add("Belgrade");
        aux2.add("Cristobal");
        aux2.add("Cartagena");
        aux2.add("Panama City");
        aux2.add("Cutuco");
        aux2.add("Puerto Quetzal");
        exp.put("Europe",aux1);
        exp.put("America", aux2);
        assertEquals(exp,res);
    }


//    @Test
//    void getCentralityLittle() throws FileNotFoundException {
//        ArrayList<String> result = new ArrayList<>();
//        ArrayList<String> exp = countryC.getCentrality(3);
//        result.add("Leixoes");
//        result.add("Horta");
//        result.add("Ponta Delgada");
//        assertEquals(exp,result);
//    }
    @Test
    void getCentrality() throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> exp = countryC.getCentrality(3);
        result.add("Larnaca");
        result.add("Galatz");
        result.add("Guayaquil");
        assertEquals(exp,result);
    }

    @Test
    void getCentrality2() throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> exp = countryC.getCentrality(5);
        result.add("Larnaca");
        result.add("Galatz");
        result.add("Guayaquil");
        result.add("Cartagena");
        result.add("Salvador");
        assertEquals(exp,result);
    }

    @Test
    void getCentrality3() throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> exp = countryC.getCentrality(8);
        result.add("Larnaca");
        result.add("Galatz");
        result.add("Guayaquil");
        result.add("Cartagena");
        result.add("Salvador");
        result.add("Setubal");
        result.add("Ponta Delgada");
        result.add("Horta");
        assertEquals(exp,result);
    }

    @Test
    void seaPath() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.seaPath("Rio Grande",  "Santos");
        res.addFirst("Rio Grande");
        res.addLast("Salvador");
        res.addLast("Santos");
        assertEquals(expected,res);
    }

    @Test
    void seaPath2() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.seaPath("Leixoes",  "Ponta Delgada");
        res.addFirst("Leixoes");
        res.addLast("Setubal");
        res.addLast("Horta");
        res.addLast("Ponta Delgada");
        assertEquals(expected,res);
    }



    @Test
    void seaLandPath() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.seaLandPath("Madrid",  "Valencia");
        res.addFirst("Madrid");
        res.addLast("Barcelona");
        res.addLast("Valencia");
        assertEquals(expected,res);
    }

    @Test
    void seaLandPath2() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.seaLandPath("Tirana",  "Aspropyrgos");
        res.addFirst("Tirana");
        res.addLast("Athens");
        res.addLast("Piraeus");
        res.addLast("Aspropyrgos");
        assertEquals(expected,res);
    }

    @Test
    void throughDestination() {
        LinkedList<String> res = new LinkedList<>();
        ArrayList<String> pais = new ArrayList<>();
        pais.add("Barcelona");
        LinkedList<String> expected = countryC.throughDestination("Madrid",  "Valencia",pais);
        res.addFirst("Madrid");
        res.addLast("Barcelona");
        res.addLast("Valencia");
        assertEquals(expected,res);
    }

    @Test
    void throughDestination2() {
        LinkedList<String> res = new LinkedList<>();
        ArrayList<String> pais = new ArrayList<>();
        pais.add("Barcelona");
        pais.add("Valencia");
        LinkedList<String> expected = countryC.throughDestination("Lisbon",  "Paris",pais);
        res.addFirst("Lisbon");
        res.addLast("Madrid");
        res.addLast("Barcelona");
        res.addLast("Valencia");
        res.addLast("Paris");
        assertEquals(expected,res);
    }

    @Test
    void landPath() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.landPath("Lisbon",  "Barcelona");
        res.addFirst("Lisbon");
        res.addLast("Madrid");
        res.addLast("Barcelona");
        assertEquals(expected,res);
    }

    @Test
    void landPath2() {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> expected = countryC.landPath("Lisbon",  "Vlissingen");
        res.addFirst("Lisbon");
        res.addLast("Madrid");
        res.addLast("Paris");
        res.addLast("Brussels");
        res.addLast("Amsterdam");
        res.addLast("Vlissingen");
        assertEquals(expected,res);
    }
}