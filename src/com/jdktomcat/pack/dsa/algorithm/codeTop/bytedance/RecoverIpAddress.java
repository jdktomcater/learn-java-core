package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 恢复IP地址
 */
public class RecoverIpAddress {
    /**
     * 将数字字符串恢复成ip地址
     *
     * @param address 数字字符串
     * @return ip地址列表
     */
    public static List<String> recoverIpAddress(String address) {
        List<String> result = new LinkedList<>();
        helper(address, 0, 0, "", "", result);
        return result;
    }

    /**
     * 逻辑计算体
     *
     * @param address 原始地址
     * @param index   索引
     * @param segI    片段索引
     * @param seg     片段
     * @param ip      ip
     * @param result  结果列表
     */
    private static void helper(String address, int index, int segI, String seg, String ip, List<String> result) {
        if (index == address.length() && segI == 3 && isValidSeg(seg)) {
            result.add(ip + seg);
        } else if (index < address.length() && segI <= 3) {
            char ch = address.charAt(index);
            // 作为目前ip段结尾
            if (isValidSeg(seg + ch)) {
                helper(address, index + 1, segI, seg + ch, ip, result);
            }
            // 作为下一个ip段开始
            if (seg.length() > 0 && segI < 3) {
                helper(address, index + 1, segI + 1, "" + ch, ip + seg + ".", result);
            }
        }
    }

    /**
     * 判断是否是合法ip片段
     *
     * @param seg 片段
     * @return true：是 false：否
     */
    private static boolean isValidSeg(String seg) {
        return Integer.parseInt(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }

    public static void main(String[] args) {
        String address = "10203040";
        List<String> result = recoverIpAddress(address);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
