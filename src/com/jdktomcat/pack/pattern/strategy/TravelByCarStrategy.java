package com.jdktomcat.pack.pattern.strategy;

public class TravelByCarStrategy implements TravelStrategy{
    @Override
    public void travelMode() {
        System.out.println("travel by car");
    }
}
