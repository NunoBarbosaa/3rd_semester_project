package lapr.project.ui;

import lapr.project.controller.FindShipController;
import lapr.project.controller.LoaderController;
import lapr.project.model.Ship.Ship;
import lapr.project.data.AVL;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindShipUI {

    AVL<Ship> avlByMMSI = new AVL<>();
    AVL<Ship> avlByIMO = new AVL<>();
    AVL<Ship> avlByCallSign = new AVL<>();

    FindShipController findShipController = new FindShipController();
    final LoaderController controller = new LoaderController();


    public FindShipUI() throws FileNotFoundException {
        this.avlByMMSI = controller.loadShipsByMmsi("sships.csv");
        this.avlByIMO = controller.loadShipsByIMO("sships.csv");
        this.avlByCallSign = controller.loadShipsByCallSign("sships.csv");
    }
    /**
     * Metodo utilizado para encontrar um barco por : MMSI ou IMO ou Call sign
     */
    public void findShipUI() throws FileNotFoundException {
        Ship ship = null;
        System.out.println("Deseja pesquisar o barco por : \n1)MMSI \n2)IMO \n3)CallSign \n4)Sair");
        Scanner in = new Scanner(System.in);
        int op = in.nextInt();
        in.nextLine();


        while (op != 4) {
            switch (op) {
                case 1:
                    System.out.println("Introduza o MMSI do barco que deseja encontrar : ");
                    int mmsi = in.nextInt();
                    ship = findShipController.findShipByMmsi(avlByMMSI, mmsi);
                    if (ship == null) {
                        System.out.println("O barco introduzido não existe");

                    } else {
                        System.out.println(avlByMMSI = controller.loadShipsByMmsi("sships.csv"));
                        System.out.println(ship.printDetails());

                    }
                    break;

                    case 2:
                        System.out.println("Introduza o IMO do barco que deseja encontrar : ");
                        String imo = in.nextLine().trim();
                        ship = findShipController.findShipByIMO(avlByIMO, imo);
                        if (ship == null) {
                            System.out.println("O barco introduzido não existe");
                        } else {
                            avlByIMO = controller.loadShipsByIMO("sships.csv");
                            System.out.println(ship.printDetails());
                        }
                            break;

                            case 3:
                                System.out.println("Introduza o Call Sign do barco que deseja encontrar : ");
                                String callSign = in.nextLine().trim();
                                ship = findShipController.findShipByCallSign(avlByCallSign, callSign);
                                if (ship == null)
                                    System.out.println("O barco introduzido não existe");
                                else
                                    avlByCallSign = controller.loadShipsByCallSign("sships.csv");
                                    System.out.println(ship.printDetails());
                                break;

                             case 4:
                             System.out.println("Sair");
                            default:
                                System.out.println("Opção invalida !!\n");
                                break;
                        }
            System.out.println("Deseja pesquisar o barco por : \n1)MMSI \n2)IMO \n3)CallSign \n4)Sair");
            op = in.nextInt();
            in.nextLine();


                }


            }
        }





