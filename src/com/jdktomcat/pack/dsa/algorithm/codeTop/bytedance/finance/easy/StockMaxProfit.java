package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.easy;

/**
 * 买卖股票的最佳时机
 */
public class StockMaxProfit {

    /**
     * 股票最大收益
     *
     * @param prices 股票价格信息
     * @return 最大收益
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
