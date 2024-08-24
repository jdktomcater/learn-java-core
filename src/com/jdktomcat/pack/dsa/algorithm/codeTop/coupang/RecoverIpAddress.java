package com.jdktomcat.pack.dsa.algorithm.codeTop.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 复原 IP 地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和
 * "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.'
 * 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class RecoverIpAddress {

    /**
     * 恢复ip地址
     *
     * @param address 地址信息
     * @return 可能ip地址列表
     */
    public static List<String> restoreIpAddresses(String address) {
        List<String> result = new ArrayList<>();
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
            if (isValidSeg(seg + ch)) {
                helper(address, index + 1, segI, seg + ch, ip, result);
            }
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
        String target = "25525511135";
        System.out.println(Arrays.toString(restoreIpAddresses(target).toArray()));
    }

}
