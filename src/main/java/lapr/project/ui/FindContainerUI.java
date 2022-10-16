package lapr.project.ui;

import lapr.project.data.FindContainerController;

import java.util.Scanner;

public class FindContainerUI {

    public void containerNumberInput() {
        Scanner ler = new Scanner(System.in);
        System.out.println("What's your clientId?");
        int clientId = ler.nextInt();
        System.out.println("What's the containerNumber?");
        int containerNumber = ler.nextInt();
        FindContainerController findContainerController = new FindContainerController();
        try {
            String result = findContainerController.findContainer(clientId,containerNumber);
            System.out.println(result);

        } catch (Exception exception) {
        }
    }
}

