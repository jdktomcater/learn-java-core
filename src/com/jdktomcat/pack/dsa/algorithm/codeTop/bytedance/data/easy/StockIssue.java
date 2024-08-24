package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.data.easy;

/**
 * 买卖股票的最佳时机
 */
public class StockIssue {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,maxProfit = 0;
        for (int price : prices) {
            // 如果价格小于最小价格
            minPrice = Math.min(price, minPrice);
            // 取差价最大者
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
