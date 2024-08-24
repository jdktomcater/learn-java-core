package com.jdktomcat.pack.dsa.algorithm.company.mihoyo.mid;

/**
 * Z字形变换
 */
public class ZStringConvert {

    /**
     * Z字形变换
     *
     * @param source  字符串
     * @param numRows 行数
     * @return 转换后字符串
     */
    public static String convert(String source, int numRows) {
        if (numRows < 2) {
            return source;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < stringBuilders.length; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int i = 0, flag = -1;
        for (char ch : source.toCharArray()) {
            stringBuilders[i].append(ch);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : stringBuilders) {
            res.append(row);
        }
        return res.toString();
    }
}
