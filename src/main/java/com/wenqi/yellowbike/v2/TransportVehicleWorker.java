package com.wenqi.yellowbike.v2;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.wenqi.yellowbike.v2.Data.MIN_FOR_VEHICLE_TRANSPORT;
import static com.wenqi.yellowbike.v2.Data.SPEED_FRO_VEHICLE;

public class TransportVehicleWorker implements Runnable {

    @Override
    public void run() {
        List<TransportVehicle> transportVehicles = Data.TRANSPORT_VEHICLES;


        List<Station> stations = Data.STATIONS;
        Optional<Station> first = stations.stream().min(Comparator.comparingInt(s -> s.getBikeNum().get()));


        Optional<Station> last = stations.stream().max(Comparator.comparingInt(s -> s.getBikeNum().get()));

        // assume when bike number lt 5, the vehicle run
        if (first.isPresent() && first.get().getBikeNum().get() >= MIN_FOR_VEHICLE_TRANSPORT || transportVehicles.size() >= 2) {
            return;
        }

        String firstStationName = first.get().getName();
        String lastStationName = last.get().getName();

        //A_TO_B_1
        int i = new Random().nextInt(2) + 1;
        String routeName = lastStationName + "_TO_" + firstStationName + "_" + i;
        Route route = Route.getRouteByName(routeName);
        TransportVehicle vehicle = new TransportVehicle(route, route.getDistance());

        // check again
        if (first.get().getBikeNum().get() >= MIN_FOR_VEHICLE_TRANSPORT || transportVehicles.size() >= 2) {
            return;
        }
        if (transportVehicles.size() == 1) {
            char destination = transportVehicles.get(0).getRoute().name().charAt(5);
            if (firstStationName.equals(String.valueOf(destination))) {
                return;
            }

        }

        transportVehicles.add(vehicle);

        //vehicles start
        StationService.getInstance().manageStations(vehicle);

        while (vehicle.getRemainingDistance() > 0) {
            vehicle.decrDistance(SPEED_FRO_VEHICLE);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        transportVehicles.remove(vehicle);
        StationService.getInstance().manageStations(vehicle);


    }
}
