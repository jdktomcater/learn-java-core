package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

/**
 * 有效的括号字符串
 */
public class CheckValidBrackets {

    /**
     * 校验有效括号字符串（递归）
     *
     * @param target 目标字符串
     * @return true：有效 false：无效
     */
    public static boolean checkValidStringBt(String target) {
        return check(target, 0, 0);
    }

    /**
     * 检查
     *
     * @param target 目标字符串
     * @param start  开始索引
     * @param count  计数（左括号数量）
     * @return true：是 false：否
     */
    private static boolean check(String target, int start, int count) {
        if (count < 0) {
            return false;
        }
        for (int i = start; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count-- == 0) {
                    return false;
                }
            } else if (c == '*') {
                return check(target, i + 1, count + 1) ||  // 作为 (
                        check(target, i + 1, count - 1) || // 作为 )，抵消一个左括号
                        check(target, i + 1, count);       // 作为 空
            }
        }
        return count == 0;
    }

    /**
     * 校验有效括号字符串（贪心）
     *
     * @param target 目标字符串
     * @return true：有效 false：无效
     */
    public static boolean checkValidStringGreedy(String target) {
        // possible range
        int min = 0, max = 0; // 维护当前左括号的数量范围：[min, max]
        for (char c : target.toCharArray()) {
            if (c == '(') {
                ++min;
                ++max;
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                if (max-- == 0) {
                    return false;// 左括号不够
                }
            } else {
                if (min > 0) {
                    min--; // 可作为右括号，抵消
                }
                ++max; // 可作为左括号
            }
        }
        return min == 0;
    }


    /**
     * 校验有效括号字符串（双向统计）
     *
     * @param target 目标字符串
     * @return true：有效 false：无效
     */
    public static boolean checkValidStringDouble(String target) {
        // all * for (, valid enough or not
        int lc = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != ')') {
                lc++;
            } else if (lc-- == 0) {
                return false;
            }
        }
        if (lc == 0) {
            return true; // 必须所有都 (，且刚好够，可提前结束无需再验
        }
        // all * for ), valid enough or not
        int rc = 0;
        for (int i = target.length() - 1; i >= 0; i--) {
            if (target.charAt(i) != '(') {
                rc++;
            } else if (rc-- == 0) {
                return false;
            }
        }
        return true;
    }
}
