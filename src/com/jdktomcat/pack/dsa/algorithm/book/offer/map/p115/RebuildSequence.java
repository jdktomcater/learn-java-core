package com.jdktomcat.pack.dsa.algorithm.book.offer.map.p115;

import java.util.*;

/**
 * 重建序列
 */
public class RebuildSequence {

    /**
     * 是否序列创建
     *
     * @param org  排列
     * @param seqs 序列
     * @return true：可重建 false：不可重建
     */
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }
                graph.putIfAbsent(num, new HashSet<>());
                inDegrees.putIfAbsent(num, 0);
            }
            for (int i = 0; i < seq.size() - 1; i++) {
                int num1 = seq.get(i);
                int num2 = seq.get(i + 1);
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.add(num);
            }
        }
        List<Integer> built = new LinkedList<>();
        while (queue.size() == 1) {
            int num = queue.remove();
            built.add(num);
            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        int[] result = built.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(result, org);
    }

    public static void main(String[] args) {
        int[] org = new int[]{4, 1, 5, 2, 6, 3};
        int[][] seqs = {{5, 2, 6, 3}, {4, 1, 5, 2}};
        List<List<Integer>> seqList = new ArrayList<>();
        for (int[] seq : seqs) {
            seqList.add(Arrays.asList(Arrays.stream(seq).boxed().toArray(Integer[]::new)));
        }
        boolean enable = sequenceReconstruction(org, seqList);
        System.out.println("是否能重建：" + enable);

        org = new int[]{1,2,3};
        int[][] seqs1 = {{1,2}, {1,3}};
         seqList = new ArrayList<>();
        for (int[] seq : seqs1) {
            seqList.add(Arrays.asList(Arrays.stream(seq).boxed().toArray(Integer[]::new)));
        }
        enable = sequenceReconstruction(org, seqList);
        System.out.println("是否能重建：" + enable);
    }
}
