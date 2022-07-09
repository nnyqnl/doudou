package com.wenqi.yellowbike.v2;

public class TransportVehicle {
    private Route route;
    private int remainingDistance;

    public TransportVehicle(Route route, int remainingDistance) {
        this.route = route;
        this.remainingDistance = remainingDistance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getRemainingDistance() {
        return remainingDistance;
    }

    public void setRemainingDistance(int remainingDistance) {
        this.remainingDistance = remainingDistance;
    }

    public void decrDistance(int distance) {
        if (remainingDistance - distance >= 0) {
            remainingDistance -= distance;
            return;
        }
        remainingDistance = 0;
    }
}
