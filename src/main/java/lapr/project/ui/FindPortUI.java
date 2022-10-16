package lapr.project.ui;

import lapr.project.controller.LoaderController;
import lapr.project.controller.PortController;
import lapr.project.model.Ports.Port;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class FindPortUI {

    final LoaderController controller = new LoaderController();
    PortController portController = new PortController();

    public FindPortUI() throws FileNotFoundException {


/*
    public void FindPortUI() throws ParseException, FileNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        System.out.println("Insira o call sign");
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        System.out.println("Insira o ano com o seguinte formato dd/MM/yyyy");
        Scanner year = new Scanner(System.in);
        String years = year.nextLine();
        Date date = sdf.parse(years);
        System.out.println("Insira as horas com o seguinte formato hh:mm");
        Scanner hour = new Scanner(System.in);
        LocalTime time = LocalTime.parse(hour.nextLine());
        Port port = portController.findClosestPortToShip(op,date,time);

        System.out.print(port);
    }

}

 */
    }
}