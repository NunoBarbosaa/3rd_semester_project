package lapr.project.data;

import com.opencsv.bean.CsvToBeanBuilder;
import lapr.project.model.Ship.ShipMovement;
import lapr.project.data.ShipPair;
import lapr.project.model.Ship.ShipRoute;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShipRouteController {
    public List<ShipRoute> calculateShipRoute(List<ShipMovement> shipMovementList) {
        final List<ShipRoute> shipRouteList = new ArrayList<>();
        final Map<Integer, List<ShipMovement>> shipMovementsByMMSI =
                shipMovementList
                        .stream()
                        .collect(Collectors.groupingBy(shipMovement -> shipMovement.getMmsi()));

        for (Map.Entry<Integer, List<ShipMovement>> pair : shipMovementsByMMSI.entrySet()) {
            shipRouteList.add(ShipRoute.calculateShipRouteDetails(pair.getValue()));
        }

        return shipRouteList;
    }

    public List<ShipRoute> filterShipRoutesByTravelDistance(List<ShipRoute> shipRouteList,
                                                            int minTravelDistance) {
        final List<ShipRoute> filteredShipRoutes = shipRouteList
                .stream()
                .filter(shipRoute -> shipRoute.getTravelDistance() > minTravelDistance)
                .collect(Collectors.toList());

        return filteredShipRoutes;
    }

    public List<ShipPair> filterShipRoutesByPairs(List<ShipRoute> shipRouteList, int minDistanceDifference){
        final List<ShipPair> shipPairList = new ArrayList<>();
        final List<Integer> checkedMmsi = new ArrayList<>();
        for (ShipRoute shipRoute1 : shipRouteList){
            for (ShipRoute shipRoute2 : shipRouteList){
                final boolean isNotSameShip = shipRoute1.getMmsi() != shipRoute2.getMmsi();
                final boolean alreadyCheckedShip =
                        checkedMmsi.contains(shipRoute1.getMmsi()) || checkedMmsi.contains(shipRoute2.getMmsi());
                if(isNotSameShip && !alreadyCheckedShip){
                    final double departureDistance = ShipRoute.distance(
                            shipRoute1.getDepartureLat(), shipRoute2.getDepartureLat(),
                            shipRoute1.getDepartureLong(), shipRoute2.getDepartureLong()
                    );
                    final double arrivalDistance = ShipRoute.distance(
                            shipRoute1.getArrivalLat(), shipRoute2.getArrivalLat(),
                            shipRoute1.getArrivalLong(), shipRoute2.getArrivalLong()
                    );
                    final boolean haveCloseRoutes = (arrivalDistance < minDistanceDifference) && (departureDistance < minDistanceDifference);
                    final boolean haveDifferentTravelDistance = shipRoute1.getTravelDistance() != shipRoute2.getTravelDistance();
                    final double travelDistanceDifferential = Math.abs(shipRoute1.getTravelDistance() - shipRoute2.getTravelDistance());
                    if (haveCloseRoutes && haveDifferentTravelDistance) {
                        final ShipPair shipPair = new ShipPair();
                        shipPair.setMmsi1(shipRoute1.getMmsi());
                        shipPair.setMmsi2(shipRoute2.getMmsi());
                        shipPair.setTravelDistance1(shipRoute1.getTravelDistance());
                        shipPair.setTravelDistance2(shipRoute2.getTravelDistance());
                        shipPair.setArrivalDistance(arrivalDistance);
                        shipPair.setDepartureDistance(departureDistance);
                        shipPair.setTravelDistanceDifferential(travelDistanceDifferential);

                        shipPairList.add(shipPair);
                    }
                }
            }
            checkedMmsi.add(shipRoute1.getMmsi());
        }
        ShipPair.order(shipPairList);
        return shipPairList;
    }


    public List<ShipMovement> loadCsvFile(final String filePath) throws FileNotFoundException {
        final List<ShipMovement> shipMovementList = new CsvToBeanBuilder(new FileReader(filePath))
                .withType(ShipMovement.class).build().parse();
        return shipMovementList;
    }

}


