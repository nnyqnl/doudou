package com.wenqi.yellowbike.v2;

import java.util.List;

public class PassengerWorker implements Runnable{

    private Passenger passenger;

    public PassengerWorker(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public void run() {
        List<Passenger> passengers = Data.PASSENGERS;
        passengers.add(passenger);
        //start station bike --
        StationService.getInstance().manageStations(passenger);

        while (passenger.getRemainingDistance() > 0) {
            passenger.decrDistance();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //arrive destination bike++
        passengers.remove(passenger);
        StationService.getInstance().manageStations(passenger);


    }
}
