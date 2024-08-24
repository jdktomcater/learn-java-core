package com.jdktomcat.pack.dsa.algorithm.codeTop.shopee.singapore;

import java.util.LinkedList;
import java.util.List;

/**
 * 恢复IP地址
 */
public class RecoverIpAddress {

    public static List<String> restoreIpAddresses(String address) {
        List<String> result = new LinkedList<>();
        dfs(address, 0, 0, "", "", result);
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
    private static void dfs(String address, int index, int segI, String seg, String ip, List<String> result) {
        if (index == address.length() && segI == 3 && isValidSeg(seg)) {
            result.add(ip + seg);
        } else if (index < address.length() && segI <= 3) {
            char ch = address.charAt(index);
            if (isValidSeg(seg + ch)) {
                dfs(address, index + 1, segI, seg + ch, ip, result);
            }
            if (seg.length() > 0 && segI < 3) {
                dfs(address, index + 1, segI + 1, "" + ch, ip + seg + ".", result);
            }
        }
    }

    private static boolean isValidSeg(String seg){
        return Integer.parseInt(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }
}


