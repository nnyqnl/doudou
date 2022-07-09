package com.wenqi.yellowbike.v2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Service {


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        ExecutorService passengerExecutor = Executors.newCachedThreadPool();// Threads for each passenger
        ExecutorService transportExecutor = Executors.newFixedThreadPool(2);// Threads for 2 transport vehhicle

        List<Passenger> passengers = Data.PASSENGERS;
        List<TransportVehicle> transportVehicles = Data.TRANSPORT_VEHICLES;
        Station aStation = Data.A_STATION;
        Station bStation = Data.B_STATION;
        Station cStation = Data.C_STATION;
        int transportBikeNum = Data.TRANSPORT_BIKE_NUM;

        System.out.println(0 + "s A Station " + aStation.getBikeNum() + ", B station " + bStation.getBikeNum() + ", C station " + cStation.getBikeNum() + ", bike on the way " + passengers.size());

        for (int i = 1; i < 200; i++) {

            Thread.sleep(1000);

            Route route = generateRoute();

            Passenger passenger = new Passenger(route, route.getDistance());

            passengerExecutor.execute(new PassengerWorker(passenger));

            transportExecutor.execute(new TransportVehicleWorker());

            //A_TO_B_1
            String transportStr = transportVehicles.stream()
                    .map(it -> it.getRoute().name() + " " + transportBikeNum)
                    .collect(Collectors.joining(", "));
            String s = i + "s A Station " + aStation.getBikeNum() +
                    ", B station " + bStation.getBikeNum() +
                    ", C station " + cStation.getBikeNum() +
                    ", bike on the way " + passengers.size();


            if (transportStr.length() > 0) {
                s = s + ", vehicle " + transportStr;
            }

            System.out.println(s);

        }
        passengerExecutor.shutdown();
        transportExecutor.shutdown();


    }


    public static Route generateRoute() {
        Random random = new Random();
        int i = random.nextInt(10);
        boolean b = random.nextBoolean();

        Route type;
        switch (i) {
            case 0:
            case 6:
            case 7:// Increase the probability from A station
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
            case 8:
            case 9:// Increase the probability from C station
                type = b ? Route.C_TO_B_1 : Route.C_TO_B_2;
                break;
            default:
                type = Route.A_TO_B_1;
                break;
        }
        return type;
    }
}
