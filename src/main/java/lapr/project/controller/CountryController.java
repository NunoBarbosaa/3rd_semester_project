package lapr.project.controller;

import graph.Algorithms;
import lapr.project.model.Country.Country;
import lapr.project.model.Ports.Port;
import lapr.project.model.SeaDist.SeaDist;
import lapr.project.utils.GPS;
import lapr.project.utils.graph.matrix.MatrixGraph;


import java.io.FileNotFoundException;
import java.util.*;

public class CountryController {

    List<Country> lstCountry;
    List<SeaDist> lstDist;
    MatrixGraph<String, Double> matrixGraph = new MatrixGraph<>(false);
    List<Port> lstPorts;


    public CountryController() throws FileNotFoundException {
    }

    public void buildGraph(int numberOfPorts) throws FileNotFoundException {
//        lstCountry = LoaderController.loadCountry("countriest.csv");
//        lstDist = LoaderController.loadDist("seadistst.csv");
//        LoaderController.loadBorders("borderst.csv", lstCountry);
//        lstPorts = LoaderController.loadPorts( "bportst.csv");
        lstCountry = LoaderController.loadCountry("countries.csv");
        lstDist = LoaderController.loadDist("seadists.csv");
        LoaderController.loadBorders("borders.csv", lstCountry);
        lstPorts = LoaderController.loadPorts("bports.csv");
        HashMap<Country, List<Port>> map = LoaderController.mapPortCountry(lstCountry, lstPorts);
        for (Country cnt : lstCountry) {
            matrixGraph.addVertex(cnt.getCap());//n*n
            for (Country cnt2 : cnt.getFronteiras()) {
                matrixGraph.addEdge(cnt.getCap(), cnt2.getCap(), GPS.distanceBetweenCoordinates(cnt.getLat(), cnt.getLongi(), cnt2.getLat(), cnt2.getLongi()));
            }
        }
        for (Port port : lstPorts) { //n
            matrixGraph.addVertex(port.getPort());
        }
        for (Country c : map.keySet()) {//O(n aoquadrado)
            List<Port> aux = map.get(c);
            HashMap<String, Double> aux3 = new HashMap<>();
            for (int i = 0; i < aux.size() - 1; i++) {
                matrixGraph.addEdge(aux.get(i).getPort(), aux.get(i + 1).getPort(), GPS.distanceBetweenCoordinates(aux.get(i).getLat(), aux.get(i).getLon(), aux.get(i + 1).getLat(), aux.get(i + 1).getLon()));
            }
            for (Port port : aux) {
                double dist = GPS.distanceBetweenCoordinates(c.getLat(), c.getLongi(), port.getLat(), port.getLon());
                aux3.put(port.getPort(), dist);

            }
            sortByValue(aux3);
            for (String ports : aux3.keySet()) {
                matrixGraph.addEdge(c.getCap(), ports, aux3.get(ports));
                break;
            }
        }

        for (Port port : lstPorts) { //On ao quadrado
            HashMap<String, Double> aux = new HashMap<>();
            for (Port ports : lstPorts) {
                if (port.getCountry() != ports.getCountry()) {
                    double dist = GPS.distanceBetweenCoordinates(port.getLat(), port.getLon(), ports.getLat(), ports.getLon());
                    aux.put(ports.getPort(), dist);
                }
            }
            sortByValue(aux);
            for (String key : aux.keySet()) {
                if (numberOfPorts <= 0) {
                    break;
                }
                matrixGraph.addEdge(port.getPort(), key, aux.get(key));
                numberOfPorts--;
            }
        }
        System.out.println(matrixGraph.toString());//On ao quadrado
    }


    public static HashMap<String, Double>
    sortByValue(HashMap<String, Double> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double>> list
                = new LinkedList<Map.Entry<String, Double>>(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Double> temp
                = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    public MatrixGraph<String, Double> getMatrix() {
        return matrixGraph;
    }

    public List<Country> listCountry() {
        return lstCountry;
    }

    public List<Port> listPorts() {
        return lstPorts;
    }

    /**
     * @param
     */
    public void ColorirMatrix() {
        if (matrixGraph == null) {
            System.out.println("matriz vazia por favor preencher a matriz !!");
        } else {
            int v = matrixGraph.numVertices();
            int result[] = new int[v];

            // Inicializa todos os versos como unsigned
            Arrays.fill(result, -1);

            // Atribui a primeira cor ao primeiro vertice
            result[0] = 0;

            // m array temporário para armazenar cores.
            // valor de available[] falso significa que a cor está atribuida a um
            // dos vértices adjacentes
            boolean available[] = new boolean[v];

            // Inicialmente, não há cores indisponiveis
            Arrays.fill(available, true);

            //Obtemos todos os vertices da matriz
            ArrayList<String> vertices = matrixGraph.vertices();

            // Atribui cores aos vértices V-1 restantes
            for (int u = 1; u < v; u++) {
                // Deixa todos as cores dos vértices adjacentes como indisponíveis
                Iterator<String> it = matrixGraph.adjVertices(vertices.get(u)).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    int i = matrixGraph.key(next);
                    if (result[i] != -1) {
                        available[result[i]] = false;
                    }
                }

                // Encontra a primeira cor disponível
                int cor;
                for (cor = 0; cor < v; cor++) {
                    if (available[cor]) {
                        break;
                    }
                }

                result[u] = cor;


                // Deixa os valores a true para a próxima iteração
                Arrays.fill(available, true);
            }

            int u = 0;
            for (String oPais : matrixGraph.vertices()) {
                Country pais = getCountryByCap(oPais, lstCountry);
                if (pais != null) {
                    System.out.println("\nLugar: " + oPais + " ->  Cor:"
                            + result[u] + "\n");
                    u++;
                }
            }
        }

    }


    public HashMap<String, LinkedList<String>> closestPlacesByContinent(int numberOfPlaces) {
        Double zero = 0.0;
        HashMap<String, ArrayList<Double>> map = new HashMap<>();
        HashMap<String, ArrayList<LinkedList<String>>> map1 = new HashMap<>();
        HashMap<String, LinkedList<String>> countriesByContinent = new HashMap<>();
        for (String vert : matrixGraph.vertices()) {
            Country pais = getCountryByCap(vert, lstCountry);
            Port port = getPortByName(vert, lstPorts);
            if (pais != null) {
                LinkedList<String> aux9 = countriesByContinent.getOrDefault(pais.getContinent(), new LinkedList<>());
                aux9.push(vert);
                countriesByContinent.put(pais.getContinent(), aux9);
            } else {
                LinkedList<String> aux9 = countriesByContinent.getOrDefault(port.getContinent(), new LinkedList<>());
                aux9.push(vert);
                countriesByContinent.put(port.getContinent(), aux9);
            }
        }

        for (String conts : countriesByContinent.keySet()) {
            MatrixGraph<String, Double> clone = matrixGraph.clone();
            for (int i = 0; i < clone.vertices().size(); i++) {
                if (!countriesByContinent.get(conts).contains(clone.vertices().get(i))) {
                    clone.removeVertex(clone.vertices().get(i));
                    i--;
                }
            }
            for (String vert : countriesByContinent.get(conts)) {
                ArrayList<LinkedList<String>> aux = new ArrayList<>();
                ArrayList<Double> aux2 = new ArrayList<>();
                graph.Algorithms.shortestPaths(clone, vert, Double::compare, Double::sum, zero, aux, aux2);
                ArrayList<LinkedList<String>> aux3 = map1.getOrDefault(conts, new ArrayList<>());
                aux3.addAll(aux);
                map1.put(conts, aux);
                ArrayList<Double> aux4 = map.getOrDefault(conts, new ArrayList<>());
                aux4.addAll(aux2);
                map.put(conts, aux2);
            }
        }
        HashMap<String, LinkedList<String>> finalMap = new HashMap<>();

        for (String cont : map.keySet()) {
            int places = 0;
            double sum = 0;
            ArrayList<Double> valores = map.get(cont);

            for (Double valor : valores) {
                if (valor != null) {
                    sum += valor;
                }
            }
            double media = sum / valores.size();
            HashMap<String, Double> map3 = new HashMap<>();
            ArrayList<LinkedList<String>> pathsByContinent = map1.get(cont);
            for (int i = 0; i < pathsByContinent.size(); i++) {
                LinkedList<String> aux6 = pathsByContinent.get(i);
                if (aux6 != null && valores.get(i) < media) {

                    map3.put(aux6.getLast(), valores.get(i));
                }
            }
            sortByValue(map3);
            for (String local : map3.keySet()) {
                if (places < numberOfPlaces) {
                    LinkedList<String> aux5 = finalMap.getOrDefault(cont, new LinkedList<>());
                    aux5.push(local);
                    finalMap.put(cont, aux5);
                    places++;
                }
            }
        }
        System.out.println(finalMap);
        return finalMap;
    }

    public Country getCountryByCap(String cap, List<Country> lst) {
        for (Country c : lst) {
            if (c.getCap().equalsIgnoreCase(cap)) {
                return c;
            }
        }
        return null;
    }

    public Port getPortByName(String port, List<Port> lst) {
        for (Port p : lst) {
            if (p.getPort().equalsIgnoreCase(port)) {
                return p;
            }
        }
        return null;
    }

    public void setMatrixGraph(MatrixGraph<String, Double> matrixGraph) {
        this.matrixGraph = matrixGraph;
    }

    public MatrixGraph<String, Double> getMatrixGraph() {
        return matrixGraph;
    }

    public ArrayList<String> getCentrality(int numberOfPorts) throws FileNotFoundException {
        lstCountry = LoaderController.loadCountry("countries.csv");
        MatrixGraph<String, Double> cloneMatrix = matrixGraph.clone();
        Map<String, Integer> unSortedMap = new HashMap<>();

        for (Country country : lstCountry) {
            cloneMatrix.removeVertex(country.getCap());
        }
        for (String vert : cloneMatrix.vertices()) {
            Integer numberOfVerts = cloneMatrix.outDegree(vert);
            unSortedMap.put(vert, numberOfVerts);
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        ArrayList<String> finalList = new ArrayList<>();
        for (String e : reverseSortedMap.keySet()) {
            if (numberOfPorts > 0) {
                String port = e;
                finalList.add(port);
                numberOfPorts--;
            } else break;
        }
        System.out.println(finalList);
        return finalList;
    }


   public LinkedList<String> landPath(String origem,String dest){
       LinkedList<String> path = new LinkedList<>();
       MatrixGraph<String, Double> cloneMatrix = matrixGraph.clone();
       Port origem1 = getPortByName(origem, lstPorts);
       Port dest1 = getPortByName(dest, lstPorts);
       Country origem2 = getCountryByCap(origem, lstCountry);
       Country dest2 = getCountryByCap(dest, lstCountry);
       if ((origem2 == null && origem1 == null) || (dest1 == null && dest2 == null)) {
           System.out.println("Inválido");
           return null;
       }
       for (Port p : lstPorts){
           if(!(p.getPort().equals(origem) || p.getPort().equals(dest))){
               cloneMatrix.removeVertex(p.getPort());
           }
       }
       Algorithms.shortestPath(cloneMatrix,origem,dest,Double::compare,Double::sum,0.0,path);
       return path;
   }


    public LinkedList<String> seaPath(String origem, String dest) {
        LinkedList<String> path = new LinkedList<>();
        MatrixGraph<String, Double> cloneMatrix = matrixGraph.clone();

        for (Country s : lstCountry) {
            cloneMatrix.removeVertex(s.getCap());
        }
        Port origem1 = getPortByName(origem, lstPorts);
        Port dest1 = getPortByName(dest, lstPorts);
        if (origem1 == null || dest1 == null) {
            System.out.println("Inválido");
            return null;
        }
        graph.Algorithms.shortestPath(cloneMatrix, origem, dest, Double::compare, Double::sum, 0.0, path);
        return path;
    }


    public LinkedList<String> seaLandPath(String origem, String dest) {
        LinkedList<String> path = new LinkedList<>();
        Port origem1 = getPortByName(origem, lstPorts);
        Port dest1 = getPortByName(dest, lstPorts);
        Country origem2 = getCountryByCap(origem, lstCountry);
        Country dest2 = getCountryByCap(dest, lstCountry);
        if ((origem2 == null && origem1 == null) || (dest1 == null && dest2 == null)) {
            System.out.println("Inválido");
            return null;
        }
        Algorithms.shortestPath(matrixGraph, origem, dest, Double::compare, Double::sum, 0.0, path);
        return path;
    }

    public LinkedList<String> throughDestination(String origem, String dest, ArrayList<String> paises) {
        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> pathF = new LinkedList<>();
        Port origem1 = getPortByName(origem, lstPorts);
        Port dest1 = getPortByName(dest, lstPorts);
        Country origem2 = getCountryByCap(origem, lstCountry);
        Country dest2 = getCountryByCap(dest, lstCountry);
        if ((origem2 == null && origem1 == null) || (dest1 == null && dest2 == null)) {
            System.out.println("Inválido");
            return null;
        }
        String atual = origem;
        for (String s : paises) {
            Port dest3 = getPortByName(s, lstPorts);
            Country origem3 = getCountryByCap(s, lstCountry);
            if (dest3 != null || origem3 != null)
                Algorithms.shortestPath(matrixGraph, atual, s, Double::compare, Double::sum, 0.0, path);
            atual = s;
            for (String s1 : path) {
                if (!pathF.contains(s1))
                    pathF.addLast(s1);
            }
        }
        Algorithms.shortestPath(matrixGraph, atual, dest, Double::compare, Double::sum, 0.0, path);
        for (String s1 : path) {
            if (!pathF.contains(s1))
                pathF.addLast(s1);
        }
        return pathF;
    }

}
