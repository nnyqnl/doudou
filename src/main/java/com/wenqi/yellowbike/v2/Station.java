package com.wenqi.yellowbike.v2;

import java.util.concurrent.atomic.AtomicInteger;

public class Station {
    private AtomicInteger bikeNum;

    private String name;

    public Station(AtomicInteger bikeNum, String name) {
        this.bikeNum = bikeNum;
        this.name = name;
    }

    public AtomicInteger getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(AtomicInteger bikeNum) {
        this.bikeNum = bikeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void decr() {
        bikeNum.decrementAndGet();
    }

    public void decrByNum(int i) {
        bikeNum.addAndGet(-i);
    }

    public void incr() {
        bikeNum.incrementAndGet();
    }

    public void incrByNum(int i) {
        bikeNum.addAndGet(i);
    }
}
