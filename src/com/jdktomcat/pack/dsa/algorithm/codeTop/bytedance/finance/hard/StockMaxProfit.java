package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

/**
 * 买卖股票的最佳时机 III
 */
public class StockMaxProfit {
    /**
     * 买卖股票的最佳时机
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


    /**
     * 买卖股票的最佳时机
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfitL1(int[] prices) {
        int buy1 = -prices[0], buy2 = -prices[0], sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
