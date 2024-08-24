package com.jdktomcat.pack.pattern.strategy;

public class TravelByAirStrategy implements TravelStrategy{
    @Override
    public void travelMode() {
        System.out.println("travel by air");
    }
}
