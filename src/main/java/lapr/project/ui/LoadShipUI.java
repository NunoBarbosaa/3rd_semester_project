package lapr.project.ui;

import lapr.project.controller.LoaderController;
import lapr.project.model.Ship.Ship;
import lapr.project.data.AVL;

import java.io.IOException;
import java.util.Scanner;


public class LoadShipUI {

    private final LoaderController controller= new LoaderController();

    AVL<Ship> avlByMMSI = new AVL<>();
    AVL<Ship> avlByIMO = new AVL<>();
    AVL<Ship> avlByCallSign = new AVL<>();

    public AVL<Ship> loadingShipsUI() throws IOException {
        AVL<Ship> avl = new AVL<>();
        Scanner scanner = new Scanner(System.in);
        String fileName;
        int opt;
        try {
            System.out.println("Qual o caminho do ficheiro que deseja importar?");
            fileName = scanner.nextLine();
            System.out.println("\nQual o código a introduzir para a ordenação dos navios? :\n1 - MMSI\n2 - IMO\n3 - CALL SIGN");
            opt = scanner.nextInt();
            switch (opt) {
                case (1):
                    avlByMMSI = controller.loadShipsByMmsi("sships.csv");
                    System.out.println("\n"+"AVL sorted by MMSI" + avlByMMSI.toString() + "\n");
                    System.out.println("\n Barcos importados e odenados com sucesso pelo respetivo código");
                    break;
                case (2):
                    avlByIMO = controller.loadShipsByIMO("sships.csv");
                    System.out.println("\n"+"AVL sorted by imo " + avlByIMO.toString() + "\n");
                    System.out.println("\n Barcos importados e odenados com sucesso pelo respetivo código");
                    break;
                case (3):
                    avlByCallSign = controller.loadShipsByCallSign("sships.csv");
                    System.out.println("\n"+"AVL sorted by CallSign " + avlByCallSign.toString() + "\n");
                    System.out.println("\n Barcos importados e odenados com sucesso pelo respetivo código");
                    break;
            }
            return avl;
        } catch (Exception exception) {
            throw new IllegalArgumentException("Ficheiro não encontrado");
        }
    }
}
