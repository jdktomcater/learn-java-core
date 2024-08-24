package com.jdktomcat.pack.pattern.strategy.pro;

/**
 * 奖品工厂
 */
public class PrizeFactory {

    /**
     * 奖品工厂模式
     *
     * @param type 类型
     * @return 奖品
     */
    public static Prize generate(String type) {
        if ("random".equalsIgnoreCase(type)) {
            return new RandomPrize();
        } else if ("fixed".equalsIgnoreCase(type)) {
            return new FixedPrize();
        }
        return null;
    }
}
