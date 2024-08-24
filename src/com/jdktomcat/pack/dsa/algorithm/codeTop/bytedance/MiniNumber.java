package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最多 K 次交换相邻数位后得到的最小整数
 */
public class MiniNumber {

    /**
     * 最多 K 次交换相邻数位后得到的最小整数
     *
     * @param num 数字
     * @param k   转换次数
     * @return 最小整数
     */
    public static String minInteger(String num, int k) {
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; ++i) {
            pos[i] = new LinkedList<>();
        }
        for (int i = 0; i < num.length(); ++i) {
            pos[num.charAt(i) - '0'].offer(i + 1);
        }
        StringBuffer ans = new StringBuffer();
        BIT bit = new BIT(num.length());
        for (int i = 1; i <= num.length(); ++i) {
            for (int j = 0; j < 10; ++j) {
                if (!pos[j].isEmpty()) {
                    int behind = bit.query(pos[j].peek() + 1, num.length());
                    int dist = pos[j].peek() + behind - i;
                    if (dist <= k) {
                        bit.update(pos[j].poll());
                        ans.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        public int query(int x, int y) {
            return query(y) - query(x - 1);
        }
    }
}
