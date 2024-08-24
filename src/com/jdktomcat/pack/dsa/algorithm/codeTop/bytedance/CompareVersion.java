package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance;

/**
 * 比较版本号
 */
public class CompareVersion {

    /**
     * 比较版本号
     *
     * @param version1 版本号1
     * @param version2 版本号2
     * @return 1：大于 -1：小于 0：等于
     */
    public static int compareVersion(String version1, String version2) {
        String[] subVerArr1 = version1.split("\\.");
        String[] subVerArr2 = version2.split("\\.");
        int index1 = 0, index2 = 0;
        while (index1 < subVerArr1.length || index2 < subVerArr2.length) {
            Integer subVer1 = parseVersion((index1 >= subVerArr1.length) ? null : subVerArr1[index1]);
            Integer subVer2 = parseVersion((index2 >= subVerArr2.length) ? null : subVerArr2[index2]);
            if (subVer1 < subVer2) {
                return -1;
            } else if (subVer1 > subVer2) {
                return 1;
            } else {
                index1++;
                index2++;
            }
        }
        return 0;

    }

    /**
     * 版本号去除左边0
     *
     * @param version 版本号
     * @return 去除处理后字符串
     */
    private static Integer parseVersion(String version) {
        if (version == null) {
            return 0;
        }
        if (version.length() <= 1) {
            return Integer.parseInt(version);
        }
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) != '0') {
                return Integer.parseInt(version.substring(i));
            }
        }
        return Integer.parseInt(version);
    }

}
