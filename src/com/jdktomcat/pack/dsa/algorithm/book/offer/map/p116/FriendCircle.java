package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p116;

/**
 * 朋友圈
 */
public class FriendCircle {

    /**
     * 计算朋友圈个数
     *
     * @param M 朋友信息
     * @return 朋友圈个数
     */
    public static int findCircleNum(int[][] M) {
        int[] fathers = new int[M.length];
        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        int count = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
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
        int[][] M = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(M));
    }

}
