package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p117;

/**
 * 相似字符串组
 */
public class SimilarStringGroup {

    /**
     * 相似字符串组数
     *
     * @param A 字符串数组
     * @return 组数
     */
    public static int numSimilarGroups(String[] A) {
        int[] fathers = new int[A.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        int group = fathers.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (similar(A[i], A[j]) && union(fathers, i, j)) {
                    group--;
                }
            }
        }
        return group;
    }

    /**
     * 字符串相似判断
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return true：相似 false：不相似
     */
    private static boolean similar(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 2;
    }

    /**
     * 合并集合并
     *
     * @param fathers 集合
     * @param i       索引1
     * @param j       索引2
     * @return true:成功 false：失败
     */
    private static boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    /**
     * 查找节点的根节点
     *
     * @param fathers 数组
     * @param i       节点
     * @return 父节点
     */
    private static int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            return findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    public static void main(String[] args) {
        String[] targets = new String[]{"tars", "rats", "arts", "star"};
        int number = numSimilarGroups(targets);
        System.out.println("相似字符串数组个数：" + number);
    }

}
