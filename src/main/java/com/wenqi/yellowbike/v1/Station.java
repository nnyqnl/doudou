package com.wenqi.yellowbike.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class Station {
    private AtomicInteger bikeNum;

    public Station(AtomicInteger bikeNum) {
        this.bikeNum = bikeNum;
    }

    public AtomicInteger getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(AtomicInteger bikeNum) {
        this.bikeNum = bikeNum;
    }

    public void decr(){
        bikeNum.decrementAndGet();
    }

    public void incr(){
        bikeNum.incrementAndGet();
    }
}
