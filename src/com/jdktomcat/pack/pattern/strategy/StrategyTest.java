package com.jdktomcat.pack.pattern.strategy;

import com.jdktomcat.pack.pattern.strategy.pro.*;

public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context();
        TravelByAirStrategy travelByAirStrategy = new TravelByAirStrategy();
        context.setTravelStrategy(travelByAirStrategy);
        context.travelMode();

        TravelByCarStrategy travelByCarStrategy = new TravelByCarStrategy();
        context.setTravelStrategy(travelByCarStrategy);
        context.travelMode();

        Prize randomPrize = new RandomPrize();
        Prize fixedPrize = new FixedPrize();

        // 奖品初始化
        Initiator initiator = new Initiator();
        initiator.setPrize(randomPrize);
        initiator.init();
        initiator.setPrize(fixedPrize);
        initiator.init();

        // 奖品抽奖
        DrawHandler drawHandler = new DrawHandler();
        drawHandler.setPrize(randomPrize);
        drawHandler.draw();
        drawHandler.setPrize(fixedPrize);
        drawHandler.draw();
    }
}
