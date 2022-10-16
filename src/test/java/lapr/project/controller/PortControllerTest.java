package lapr.project.controller;

import lapr.project.model.Ports.Port;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class PortControllerTest {

    PortControllerTest() throws FileNotFoundException {
    }



/*
    @Test
    void findClosestPortToShip() throws ParseException, FileNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date year = sdf.parse("31/12/2020");
        LocalTime hours = LocalTime.parse("17:17");
        String callSign = "C4SQ2";
        Port result = new PortController().findClosestPortToShip(callSign, year, hours);
        Port expected = new Port("America", "Canada", 22226, "Halifax", 44.65, -63.56666667);

       assertEquals(result, expected);
    }
*/

}