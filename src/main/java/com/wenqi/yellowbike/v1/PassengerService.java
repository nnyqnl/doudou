package com.wenqi.yellowbike.v1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PassengerService {

    private StationService stationService  = new StationService();

    private List<Passenger> passengers = new CopyOnWriteArrayList<>();



    public void managePassengers(Passenger passenger) {
        for (Passenger p : passengers) {
            p.decr();
            if (0 == p.getRemainingDistance()) {
                stationService.manageStations(p);
                passengers.remove(p);
            }
        }
        passengers.add(passenger);
        stationService.manageStations(passenger);

    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public StationService getStationService() {
        return stationService;
    }

    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }
}
