package com.wenqi.yellowbike.v1;

public class Passenger {
    private Route route;
    private int remainingDistance;

    public Passenger(Route route, int remainingDistance) {
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

    public void decr() {
        remainingDistance--;
    }
}
