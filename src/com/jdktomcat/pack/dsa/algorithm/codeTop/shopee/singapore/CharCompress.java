package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

public class CharCompress {

    /**
     * 压缩
     *
     * @param chars 字符串数组
     * @return 压缩后长度
     */
    public static int compress(char[] chars) {
        // 长度
        int n = chars.length;
        // 读写索引
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            // 边界
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 字符数组压缩
     *
     * @param chars 字符数组
     * @return 压缩后长度
     */
    public static int compressL0(char[] chars) {
        int index = 0, left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (right == chars.length - 1 || chars[right] != chars[right + 1]) {
                chars[index++] = chars[right];
                int dis = right - left + 1;
                if (dis > 1) {
                    int start = index;
                    while (dis > 0) {
                        chars[index++] = (char) (dis % 10 + '0');
                        dis /= 10;
                    }
                    reverseL0(chars, start, index - 1);
                }
                left = right + 1;
            }
        }
        return index;
    }

    private static void reverseL0(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
