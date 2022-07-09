package com.wenqi.yellowbike.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Data {

    public static Station A_STATION = new Station(new AtomicInteger(30), "A");

    public static Station B_STATION = new Station(new AtomicInteger(40), "B");

    public static Station C_STATION = new Station(new AtomicInteger(30), "C");

    public static List<Station> STATIONS = new ArrayList<>();

    static {
        STATIONS.add(A_STATION);
        STATIONS.add(B_STATION);
        STATIONS.add(C_STATION);
    }

    public static List<Passenger> PASSENGERS = new CopyOnWriteArrayList<>();

    public static List<TransportVehicle> TRANSPORT_VEHICLES = new CopyOnWriteArrayList<>();
    public static int TRANSPORT_BIKE_NUM = 5; //how many bike that the vehicle load, simple deal that here.
    public static int MIN_FOR_VEHICLE_TRANSPORT = 20; //when the station bike number less than this number, the vehicle may be to work
    public static int SPEED_FOR_PASSENGER = 1;
    public static int SPEED_FRO_VEHICLE = 3;


}
