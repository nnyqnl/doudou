package com.wenqi.yellowbike.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class StationService {

    private Station aStation = new Station(new AtomicInteger(30));
    private Station bStation = new Station(new AtomicInteger(40));
    private Station cStation = new Station(new AtomicInteger(30));

    public void manageStations(Passenger p) {
        if (p == null) return;

        Route route = p.getRoute();
        if (route.getDistance() == p.getRemainingDistance()) {
            //Passenger leave station
            if (route.name().startsWith("A")) {
                aStation.decr();
            } else if (route.name().startsWith("B")) {
                bStation.decr();
            } else if (route.name().startsWith("C")) {
                cStation.decr();
            }
            return;
        }

        if (0 == p.getRemainingDistance()) {
            //Passenger arrive destination
            char c = p.getRoute().name().charAt(5); // A_TO_B_1
            if (c == 'A') {
                aStation.incr();
            } else if (c == 'B') {
                bStation.incr();
            } else if (c == 'C') {
                cStation.incr();
            }
        }


    }

    public Station getaStation() {
        return aStation;
    }

    public void setaStation(Station aStation) {
        this.aStation = aStation;
    }

    public Station getbStation() {
        return bStation;
    }

    public void setbStation(Station bStation) {
        this.bStation = bStation;
    }

    public Station getcStation() {
        return cStation;
    }

    public void setcStation(Station cStation) {
        this.cStation = cStation;
    }
}
