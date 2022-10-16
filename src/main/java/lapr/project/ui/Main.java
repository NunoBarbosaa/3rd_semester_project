package lapr.project.ui;


import lapr.project.controller.CountryController;
import lapr.project.data.ShipOccupancyController;
import lapr.project.data.SinkController;
import lapr.project.ui.TwoDTree.TwoDTree;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ParseException {
        CountryController countryController = new CountryController();
        Scanner ler = new Scanner(System.in);




        int opcao = 0;
        do {
            System.out
                    .println("\n\n### Ship Analysis ###");
            System.out.println("\n                  ===========================================================================================================");
            System.out.println("                  |     1 - Import ships and your respective codes                                                          |");
            System.out.println("                  |     2 - Find a ship by MMSI or IMO or Call Sign and your details                                        |");
            System.out.println("                  |     3 - Position of a ship in a date period                                                             |");
            System.out.println("                  |     4 - Summary of a ship's movements                                                                   |");
            System.out.println("                  |     5 - List for all ships the MMSI, the total number movements, Travelled Distance and Delta Distance. |");
            System.out.println("                  |     6 - Get the top-N ships with the most kilometres travelled and their average speed                  |");
            System.out.println("                  |     7 - Return pairs of ships with routes with close departure/arrival coordinates                      |");
            System.out.println("                  |     8 - Show the data of the 2d tree                                                                    |");
            System.out.println("                  |     9 - Return port closest to the ship by Call Sign                                                    |");
            System.out.println("                  |     10 - Get container location                                                                         |");
            System.out.println("                  |     11 - Get a certain ship occupancy rate for CargoManifest                                            |");
            System.out.println("                  |     12 - Get a certain ship occupancy rate for a given Moment                                           |");
            System.out.println("                  |     13 - Get available ships next Monday                                                                |");
            System.out.println("                  |     14 - Import data from countries, ports, borders and seadists files to build a freight network       |");
            System.out.println("                  |     15 - Colour the matrix                                                                              |");
            System.out.println("                  |     16 - Closeness ports                                                                                |");
            System.out.println("                  |     17 - Get WareHouse information                                                                      |");
            System.out.println("                  |     18 - Get Audit Trail                                                                                |");
            System.out.println("                  |     19 - Get Resource List during a month                                                               |");
            System.out.println("                  |     21 - Know which ports are more critical (have greater centrality) in the freight network            |");
            System.out.println("                  |     22 - Get the shortest land path between 2 locals                                                    |");
            System.out.println("                  |     23 - Get the shortest path between two ports                                                        |");
            System.out.println("                  |     24 - Get the shortest path between two locals                                                       |");
            System.out.println("                  |     25 - Get the shortest path between two locals with intermediate locals                              |");
            System.out.println("                  |     27 - Get average occupancy rate                                                                     |");
            System.out.println("                  |     28 - Get trips below threshold                                                                      |");
            System.out.println("                  |     29 - Get Loading Map                                                                                |");
            System.out.println("                  |     30 - US420                                                                                          |");
            System.out.println("                  |     0 - Exit                                                                                            |");
            System.out.println("                  ===========================================================================================================\n");

            opcao = ler.nextInt();

            System.out.print("\n");
            switch (opcao) {
                case 1:
                    LoadShipUI loadShipUI = new LoadShipUI();
                    loadShipUI.loadingShipsUI();
                    break;
                case 2:
                    FindShipUI fUI = new FindShipUI();
                    fUI.findShipUI();
                    break;
                case 3:


                    break;

                case 4:


                    break;

                case 5:
                    /*
                    OrderShipsUI orderShipsUI = new OrderShipsUI();
                    orderShipsUI.OrderShips();

                    break;
                    */

/*
                case 6:
                    GetTopNShipsByMostKmFastShipsUI getTop = new GetTopNShipsByMostKmFastShipsUI();
                    getTop.OrderShipByMostKmFastShips();

                    break;
*/
                case 7:
                    ShipRouteUI shipRouteUI = new ShipRouteUI();
                    shipRouteUI.RouteUI();
                    break;
                case 8:
                    ImportPortUI ui = new ImportPortUI();
                    TwoDTree tree = ui.loadPortsTwoDTree();
                    if(tree.isEmpty()){
                        System.out.println("A 2d tree esta vazia");
                    }
                    System.out.println(tree.toString());
                    break;
                    /*
                case 9:
                    FindPortUI findPortUI = new FindPortUI();
                    findPortUI.FindPortUI();
                    break;
*/
                case 10:
                    FindContainerUI findContainerUI = new FindContainerUI();
                    findContainerUI.containerNumberInput();
                    break;

                case 11:
                    OccupancyShipUI occupancyShipUI = new OccupancyShipUI();
                    occupancyShipUI.getShipOccupancy();
                    break;

                case 12:
                    System.out.println("What's the ship MMSI?");
                    int MMSI = ler.nextInt();
                    ShipOccupancyMomentUI occupancyShipUI1 = new ShipOccupancyMomentUI();
                    occupancyShipUI1.getShipOccupancyByMoment(MMSI);
                    break;

                case 13:
                    ShipAvailabilityUI shipAvailabilityUI = new ShipAvailabilityUI();
                    shipAvailabilityUI.getAvailableShips();
                    break;

                case 14:
                    countryController.buildGraph(5);
                    break;

                case 15:
                    countryController.ColorirMatrix();
                    break;

                case 16:
                    countryController.closestPlacesByContinent(10);
                    break;
                case 17:
                    WareHouseUI warehouseUI = new WareHouseUI();
                    warehouseUI.getWareHouseOccupancy();
                    warehouseUI.getWareHouseEstimation();
                    break;

                case 18:
                    AuditTrailUI auditTrailUI = new AuditTrailUI();
                    auditTrailUI.getAuditTrail();
                    break;
                case 19:
                    System.out.println("Qual o Id do Port?");
                    Scanner in = new Scanner(System.in);
                    int portId = in.nextInt();
                    WareHouseUI wareHouseui2 = new WareHouseUI();
                    wareHouseui2.getResourceList(portId);
                    break;

                case 21:
                    ArrayList<String> finalList=countryController.getCentrality(10);
                    System.out.println(finalList);
                    break;

                case 22:
                    CountryController c = new CountryController();
                    System.out.println("Qual é o porto de origem ?");
                    Scanner input = new Scanner(System.in);
                    String portOrig = input.nextLine();
                    System.out.println("Qual é o porto de destino ?");
                    String portDest = input.nextLine();
                    countryController.landPath(portOrig,portDest);

                    break;
                case 23:
                    System.out.println("Qual é o porto de origem ?");
                    Scanner input1 = new Scanner(System.in);
                    String portOrig1 = input1.nextLine();
                    System.out.println("Qual é o porto de destino ?");
                    String portDest1 = input1.nextLine();
                    countryController.seaPath(portOrig1,portDest1);

                    break;
                case 24:
                    System.out.println("Qual é o porto de origem ?");
                    Scanner input2 = new Scanner(System.in);
                    String portOrig2 = input2.nextLine();
                    System.out.println("Qual é o porto de destino ?");
                    String portDest2 = input2.nextLine();
                    countryController.seaLandPath(portOrig2,portDest2);

                    break;
                case 25:
                    System.out.println("Qual é o porto de origem ?");
                    Scanner input3 = new Scanner(System.in);
                    String portOrig4 = input3.nextLine();
                    System.out.println("Qual é o porto de destino ?");
                    String portDest4 = input3.nextLine();
                    System.out.println("Quantas locais intermédios pretende inserir?");
                    int n = ler.nextInt();
                    ArrayList<String> arrayPaises = new ArrayList<>();
                    for(int i=0;i<=n;i++){
                        System.out.println("Insira o local");
                        String local= ler.nextLine();
                        arrayPaises.add(local);
                    }
                    countryController.throughDestination(portOrig4,portDest4,arrayPaises);

                    break;

                case 26:
                    break;

                case 27:
                    Scanner in2 = new Scanner (System.in);
                    System.out.println("What is the ship MMSI?");
                    int mmsi = in2.nextInt();
                    ShipOccupancyController shipOccupancyController1 = new ShipOccupancyController();
                    shipOccupancyController1.averageOccupancyRate(mmsi);
                    break;
                case 28:
                    Scanner in3 = new Scanner(System.in);
                    System.out.println("What's the ship MMSI?");
                    int mmsi2 = in3.nextInt();
                    ShipOccupancyController shipOccupancyController2 = new ShipOccupancyController();
                    shipOccupancyController2.tripsBelowThreshHold(mmsi2);
                    break;

                case 29:
                    ShipOccupancyController shipOccupancyController =  new ShipOccupancyController();
                    shipOccupancyController.getLoadingMap();
                    break;


                case 30:
                    SinkController sinkController = new SinkController();
                    Scanner in4 = new Scanner(System.in);
                    String answer = "";
                    int shipMass=0;
                    int comp=0;
                    int larg=0;
                    while (!answer.equals("smallShip") && !answer.equals("mediumShip") && !answer.equals("largeShip")){
                        System.out.println("What type of ship do you choose?");
                        answer = in4.next();
                    }

                    if (answer.equals("smallShip")){
                        shipMass= 5000;
                        comp=20;
                        larg=10;
                    } else if(answer.equals("mediumShip")) {
                         shipMass= 9000;
                         comp=60;
                         larg=40;
                    } else if(answer.equals("largeShip")) {
                         shipMass= 11000;
                         comp=80;
                         larg=60;
                    }
                    System.out.println("How many containers exists in the ship?");
                    int numContainers = in4.nextInt();
                    System.out.println("What is the container weight?");
                    int containerMass=in4.nextInt();
                    String afundou = sinkController.Sink(shipMass, comp, larg, containerMass, numContainers);
                    System.out.println(afundou);
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);



    }
}