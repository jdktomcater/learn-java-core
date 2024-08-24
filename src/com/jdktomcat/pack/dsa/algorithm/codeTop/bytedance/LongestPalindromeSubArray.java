package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 最长回文子串
 */
public class LongestPalindromeSubArray {

    /**
     * 最长回文子串（回溯法：效率低）
     *
     * @param string 目标字符串
     * @return 最长回文子串
     */
    public static String longestPalindromeL1(String string) {
        int[] pair = maxPalindromeIndex(string, 0, string.length() - 1);
        return string.substring(pair[0], pair[1] + 1);
    }

    /**
     * 最长回文索引
     *
     * @param string 目标字符串
     * @param left   左索引
     * @param right  右索引
     * @return 最长回文索引
     */
    private static int[] maxPalindromeIndex(String string, int left, int right) {
        if (left <= right) {
            if (isPalindrome(string, left, right)) {
                return new int[]{left, right};
            }
            int[] leftPair = maxPalindromeIndex(string, left + 1, right);
            int[] rightPair = maxPalindromeIndex(string, left, right - 1);
            return (leftPair[1] - leftPair[0]) > (rightPair[1] - rightPair[0]) ? leftPair : rightPair;
        }
        return new int[]{0, 0};
    }


    /**
     * 判断是否为回文
     *
     * @param string 目标字符串
     * @param left   左索引
     * @param right  右索引
     * @return true：是 false：否
     */
    private static boolean isPalindrome(String string, int left, int right) {
        while (left <= right) {
            if (string.charAt(left++) != string.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长回文子串(动态规划)
     *
     * @param string 目标字符串
     * @return 最长回文子串
     */
    public static String longestPalindromeL0(String string) {
        int len = string.length();
        if (len < 2) {
            return string;
        }
        // 最大长度
        int maxLen = 1;
        // 开始索引
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = string.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    // 最大长度
                    maxLen = j - i + 1;
                    // 最大长度起始位置
                    begin = i;
                }
            }
        }
        return string.substring(begin, begin + maxLen);
    }

    /**
     * 最长回文子串(中心扩展)
     *
     * @param string 目标字符串
     * @return 最长回文子串
     */
    public static String longestPalindromeL2(String string) {
        if (string == null || string.length() < 1) {
            return "";
        }
        // 左右索引
        int left = 0, right = 0;
        // 遍历
        for (int i = 0; i < string.length(); i++) {
            // 比较奇数回文扩展与偶数回文拓展长度，取较大者
            int len = Math.max(expandAroundCenter(string, i, i), expandAroundCenter(string, i, i + 1));
            // 判断长度是否大于原先值
            if (len > right - left) {
                // 计算其下标
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return string.substring(left, right + 1);
    }

    /**
     * 中心扩展
     *
     * @param string 目标字符串
     * @param left   左索引
     * @param right  右索引
     * @return 扩展长度
     */
    public static int expandAroundCenter(String string, int left, int right) {
        while (left >= 0 && right < string.length() && string.charAt(left) == string.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String string = "babaddtattarrattatddetartrateedredividerb";
        System.out.println(longestPalindromeL2(string));
    }
}
