package com.jdktomcat.pack.dsa.algorithm.codeTop.bytedance.finance.hard;

/**
 * 情侣牵手
 */
public class HandCouple {

    /**
     * 最少交换次数
     *
     * @param row 信息
     * @return 最少交换次数
     */
    public static int minSwapsCouples(int[] row) {
        UnionFind unionFind = new UnionFind(row.length / 2);
        for (int i = 0; i < row.length; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return row.length / 2 - unionFind.getCount();
    }

    /**
     * 最少交换次数
     *
     * @param row 信息
     * @return 最少交换次数
     */
    public static int minSwapsCouplesL1(int[] row) {
        int count = row.length / 2;
        int[] parents = new int[row.length / 2];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            if(union(parents, row[i] / 2, row[i + 1] / 2)){
                count --;
            }
        }
        return count;
    }

    private static int getParent(int[] parents, int number) {
        if (number != parents[number]) {
            return getParent(parents, parents[number]);
        }
        return number;
    }
    private static boolean union(int[] parents, int odd, int even) {
        int po = getParent(parents, odd);
        int pe = getParent(parents, even);
        if (po == pe) {
            return false;
        }
        parents[odd] = pe;
        return true;
    }

    private static class UnionFind {

        private final int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5,4,2,6,3,1,0,7};
        System.out.println(minSwapsCouples(numbers));
    }
}
