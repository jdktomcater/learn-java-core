package com.jdktomcat.pack.pattern.strategy.pro;

/**
 * 抽奖处理器
 */
public class DrawHandler {

    private Prize prize;

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public void draw() {
        prize.draw();
    }
}
