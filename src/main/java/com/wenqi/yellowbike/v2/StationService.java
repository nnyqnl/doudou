package com.wenqi.yellowbike.v2;

import static com.wenqi.yellowbike.v2.Data.*;

public class StationService {

    private static volatile StationService stationService;

    private StationService() {
    }

    public static StationService getInstance() {
        if (stationService == null) {
            synchronized (StationService.class) {
                if (stationService == null) {
                    stationService = new StationService();
                }
            }
        }
        return stationService;
    }

    public void manageStations(Passenger p) {
        if (p == null) return;

        Route route = p.getRoute();
        if (route.getDistance() == p.getRemainingDistance()) {
            //Passenger leave station
            if (route.name().startsWith("A")) {
                A_STATION.decrByNum(SPEED_FOR_PASSENGER);
            } else if (route.name().startsWith("B")) {
                B_STATION.decrByNum(SPEED_FOR_PASSENGER);
            } else if (route.name().startsWith("C")) {
                C_STATION.decrByNum(SPEED_FOR_PASSENGER);
            }
            return;
        }

        if (0 == p.getRemainingDistance()) {
            //Passenger arrive destination
            char c = p.getRoute().name().charAt(5); // A_TO_B_1
            if (c == 'A') {
                A_STATION.incrByNum(SPEED_FOR_PASSENGER);
            } else if (c == 'B') {
                B_STATION.incrByNum(SPEED_FOR_PASSENGER);
            } else if (c == 'C') {
                C_STATION.incrByNum(SPEED_FOR_PASSENGER);
            }
        }


    }

    public void manageStations(TransportVehicle t) {
        if (t == null) return;

        int num = TRANSPORT_BIKE_NUM;
        Route route = t.getRoute();
        if (route.getDistance() == t.getRemainingDistance()) {
            //Passenger leave station
            if (route.name().startsWith("A")) {
                A_STATION.decrByNum(num);
            } else if (route.name().startsWith("B")) {
                B_STATION.decrByNum(num);
            } else if (route.name().startsWith("C")) {
                C_STATION.decrByNum(num);
            }
            return;
        }

        if (0 == t.getRemainingDistance()) {
            //Passenger arrive destination
            char c = t.getRoute().name().charAt(5); // A_TO_B_1
            if (c == 'A') {
                A_STATION.incrByNum(num);
            } else if (c == 'B') {
                B_STATION.incrByNum(num);
            } else if (c == 'C') {
                C_STATION.incrByNum(num);
            }
        }


    }

}
