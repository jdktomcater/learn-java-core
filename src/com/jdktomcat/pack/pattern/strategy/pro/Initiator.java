package com.jdktomcat.pack.pattern.strategy.pro;

/**
 * 初始化器
 */
public class Initiator {

    private Prize prize;

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public void init(){
        prize.init();
    }
}
