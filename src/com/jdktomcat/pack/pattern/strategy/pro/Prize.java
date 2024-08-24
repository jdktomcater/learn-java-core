package com.jdktomcat.pack.pattern.strategy.pro;

/**
 * 奖品接口
 */
public interface Prize {
    // 初始化
    void init();

    // 抽奖逻辑
    void draw();
}



