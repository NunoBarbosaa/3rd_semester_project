package lapr.project.controller;

import lapr.project.data.ShipRouteController;
import lapr.project.mocks.ShipPairMock;
import lapr.project.mocks.ShipRouteMock;
import lapr.project.model.Ship.ShipMovement;
import lapr.project.data.ShipPair;
import lapr.project.model.Ship.ShipRoute;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipRouteControllerTest {
  static ShipRouteController LoaderShipController = new ShipRouteController();
  static List<ShipMovement> shipMovementList;

  static {
    try {
      shipMovementList = LoaderShipController.loadCsvFile("pairstestfile.csv");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testShipPairs() {
    final int expectedPairs = 1;

    final ShipRouteController shipPairController = new ShipRouteController();
    final List<ShipRoute> shipRouteList = shipPairController.calculateShipRoute(shipMovementList);
    final List<ShipPair> shipPairList =  shipPairController.filterShipRoutesByPairs(shipRouteList, 5000);
    assertEquals(expectedPairs, shipPairList.size());
  }

  @Test
  public void testShipfilter() {
    final int expectedSize = 2;

    final ShipRouteController shipPairController = new ShipRouteController();
    final List<ShipRoute> shipRouteList = shipPairController.calculateShipRoute(shipMovementList);
    final List<ShipRoute> shipPairList =  shipPairController.filterShipRoutesByTravelDistance(shipRouteList,1000);
    assertEquals(expectedSize,shipPairList.size());
  }

  @Test
  public void testShipPairSorting() {
    final int mmsi1Pair1 = 1000;
    final int mmsi1Pair2 = 1000;

    final int mmsi2Pair1 = 1002;
    final int mmsi2Pair2 = 1001;
    final double travelDistance1Pair1 = 15000;
    final double travelDistance2Pair1 = 17000;
    final double travelDistance1Pair2 = 18000;
    final double travelDistance2Pair2 = 21000;

    final ShipPair shipPair1 = ShipPairMock.generate(mmsi1Pair1, mmsi2Pair1, travelDistance1Pair1, travelDistance2Pair1);
    final ShipPair shipPair2 = ShipPairMock.generate(mmsi1Pair2, mmsi2Pair2, travelDistance1Pair2, travelDistance2Pair2);
    final List<ShipPair> shipPairList = Arrays.asList(shipPair1, shipPair2);

    ShipPair.order(shipPairList);

    assertEquals(mmsi1Pair2, shipPairList.get(0).getMmsi1());
    assertEquals(mmsi2Pair2, shipPairList.get(0).getMmsi2());
    assertEquals(mmsi1Pair1, shipPairList.get(1).getMmsi1());
    assertEquals(mmsi2Pair1, shipPairList.get(1).getMmsi2());
  }

  @Test
  public void testSameShipRoutes() {
    final ShipRoute shipRoute1 = ShipRouteMock.generate(1000, 15000);
    final ShipRoute shipRoute2 = ShipRouteMock.generate(1000, 15000);

    final ShipRouteController shipPairController = new ShipRouteController();
    final List<ShipRoute> shipRouteList = Arrays.asList(shipRoute1, shipRoute2);
    final List<ShipPair> shipPairList = shipPairController.filterShipRoutesByPairs(shipRouteList, 5000);

    assertEquals(shipPairList, new ArrayList<>());
  }
}
