package com.wenqi.yellowbike.v1;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Service {


    private static PassengerService passengerService = new PassengerService();


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        List<Passenger> passengers = passengerService.getPassengers();

        StationService stationService = passengerService.getStationService();

        Station aStation = stationService.getaStation();
        Station bStation = stationService.getbStation();
        Station cStation = stationService.getcStation();

        System.out.println(0 + "s A Station " + aStation.getBikeNum() + ",B station " + bStation.getBikeNum() + ",C station " + cStation.getBikeNum() + ",bike on the way " + passengers.size());

        for (int i = 1; i < 200; i++) {

            CountDownLatch latch = new CountDownLatch(2);
            Thread.sleep(1000);

            Route route = generateRoute();

            Passenger passenger = new Passenger(route, route.getDistance());

            passengerService.managePassengers(passenger);

            System.out.println(i + "s A Station " + aStation.getBikeNum() + ",B station " + bStation.getBikeNum() + ",C station " + cStation.getBikeNum() + ",bike on the way " + passengers.size());

        }


    }


    public static Route generateRoute() {
        Random random = new Random();
        int i = random.nextInt(6);
        boolean b = random.nextBoolean();

        Route type;
        switch (i) {
            case 0:
                type = b ? Route.A_TO_B_1 : Route.A_TO_B_2;
                break;
            case 1:
                type = b ? Route.A_TO_C_1 : Route.A_TO_C_2;
                break;
            case 2:
                type = b ? Route.B_TO_C_1 : Route.B_TO_C_2;
                break;
            case 3:
                type = b ? Route.B_TO_A_1 : Route.B_TO_A_2;
                break;
            case 4:
                type = b ? Route.C_TO_A_1 : Route.C_TO_A_2;
                break;
            case 5:
                type = b ? Route.C_TO_B_1 : Route.C_TO_B_2;
                break;
            default:
                type = Route.A_TO_B_1;
                break;
        }
        return type;
    }
}
