package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.hard;

/**
 * 买卖股票的最佳时机 III
 */
public class StockMaxProfit {

    /**
     * 买卖股票的最大收益
     * 只进行过一次买操作；
     * 进行了一次买操作和一次卖操作，即完成了一笔交易；
     * 在完成了一笔交易的前提下，进行了第二次买操作；
     * 完成了全部两笔交易。
     * buy1=max{buy1,−prices[i]}
     * sell1=max{sell1,buy1+prices[i]}
     * buy2=max{buy2,sell1−prices[i]}
     * sell2=max{sell2,buy2+prices[i]}
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
