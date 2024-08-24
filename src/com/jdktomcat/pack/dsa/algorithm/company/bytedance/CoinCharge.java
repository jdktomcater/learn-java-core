package com.jdktomcat.pack.dsa.algorithm.company.bytedance;

import java.util.*;

/**
 * 类描述：换零钱
 *
 * @author 汤旗
 * @date 2019-08-02 17:22
 */
public class CoinCharge {

    private int min = Integer.MAX_VALUE;

    private boolean isCan = false;

    /**
     * 换零钱
     *
     * @param units 单元
     * @param total 总值
     * @param line  链表
     * @return 换钱结果 -1 不可 0 刚好 1 还可以再换
     */
    private int change(int[] units, int total, List<Integer> line) {
        if (line == null) {
            line = new ArrayList<>();
        }
        if (total < 0) {
            line.remove(line.size() - 1);
            return -1;
        } else if (total > 0) {
            for (int unit : units) {
                line.add(unit);
                int result = change(units, total - unit, line);
                if (result == 0 || result == -1) {
                    break;
                }
            }
            if (line.size() != 0) {
                line.remove(line.size() - 1);
            }
        } else {
            isCan = true;
            min = Integer.min(min, line.size());
            line.remove(line.size() - 1);
            return 0;
        }
        return 1;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        change(coins, amount, null);
        if (isCan) {
            return min;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] units = new int[]{1};
        int total = 0;
        CoinCharge coinCharge = new CoinCharge();
        System.out.println(coinCharge.coinChange(units, total));
    }
}
