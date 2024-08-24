package com.jdktomcat.pack.pattern.strategy;

/**
 * 策略设计模式
 */
public class Context {

    private TravelStrategy travelStrategy;


    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travelMode(){
        this.travelStrategy.travelMode();
    }
}
