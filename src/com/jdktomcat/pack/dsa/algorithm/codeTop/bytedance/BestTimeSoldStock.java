package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 买卖股票的最佳时机
 */
public class BestTimeSoldStock {

    /**
     * 最大收益
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfitL3(int[] prices) {
        int max = 0;
        if (prices.length < 2) {
            return max;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 最大收益
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfitL2(int[] prices) {
        // 最低价格
        int minPrice = Integer.MAX_VALUE;
        // 最大收益
        int maxProfit = 0;
        // 遍历全部
        for (int price : prices) {
            // 如果价格小于最小价格
            minPrice = Math.min(price, minPrice);
            // 取差价最大者
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * 最大收益
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfitL1(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int left = 0, right = 1, max = 0;
        while (right < prices.length) {
            if (prices[right] <= prices[right - 1]) {
                max += (Math.max(prices[right - 1] - prices[left], 0));
                left = right;
            }
            if (right == prices.length - 1) {
                max += (Math.max(prices[right] - prices[left], 0));
            }
            right++;
        }
        return max;
    }

    /**
     * 最大收益(动态规划)
     *考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     *
     * 定义状态 \textit{dp}[i][0]dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，\textit{dp}[i][1]dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）。
     *
     * 考虑 \textit{dp}[i][0]dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，这时候我们要将其卖出，并获得 \textit{prices}[i]prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：
     *
     * \textit{dp}[i][0]=\max\{\textit{dp}[i-1][0],\textit{dp}[i-1][1]+\textit{prices}[i]\}
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
     *
     * 再来考虑 \textit{dp}[i][1]dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，或者前一天结束时还没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，这时候我们要将其买入，并减少 \textit{prices}[i]prices[i] 的收益。可以列出如下的转移方程：
     * \textit{dp}[i][1]=\max\{\textit{dp}[i-1][1],\textit{dp}[i-1][0]-\textit{prices}[i]\}
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     * 对于初始状态，根据状态定义我们可以知道第 00 天交易结束的时候 \textit{dp}[0][0]=0dp[0][0]=0，\textit{dp}[0][1]=-\textit{prices}[0]dp[0][1]=−prices[0]。
     * 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 \textit{dp}[n-1][0]dp[n−1][0] 的收益必然是大于 \textit{dp}[n-1][1]dp[n−1][1] 的，最后的答案即为 \textit{dp}[n-1][0]dp[n−1][0]。
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfileL0(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    /**
     * 最大收益(动态规划)
     *考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
     *
     * 定义状态 \textit{dp}[i][0]dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，\textit{dp}[i][1]dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（ii 从 00 开始）。
     *
     * 考虑 \textit{dp}[i][0]dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，这时候我们要将其卖出，并获得 \textit{prices}[i]prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：
     *
     * \textit{dp}[i][0]=\max\{\textit{dp}[i-1][0],\textit{dp}[i-1][1]+\textit{prices}[i]\}
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
     *
     * 再来考虑 \textit{dp}[i][1]dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 \textit{dp}[i-1][1]dp[i−1][1]，或者前一天结束时还没有股票，即 \textit{dp}[i-1][0]dp[i−1][0]，这时候我们要将其买入，并减少 \textit{prices}[i]prices[i] 的收益。可以列出如下的转移方程：
     * \textit{dp}[i][1]=\max\{\textit{dp}[i-1][1],\textit{dp}[i-1][0]-\textit{prices}[i]\}
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
     * 对于初始状态，根据状态定义我们可以知道第 00 天交易结束的时候 \textit{dp}[0][0]=0dp[0][0]=0，\textit{dp}[0][1]=-\textit{prices}[0]dp[0][1]=−prices[0]。
     * 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 \textit{dp}[n-1][0]dp[n−1][0] 的收益必然是大于 \textit{dp}[n-1][1]dp[n−1][1] 的，最后的答案即为 \textit{dp}[n-1][0]dp[n−1][0]。
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public int maxProfitL5(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    /**
     * 最大收益 （贪心）
     *
     * @param prices 价格信息
     * @return 最大收益
     */
    public static int maxProfitL6(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices1 = {1};
        System.out.println(maxProfitL6(prices1));
    }

}
