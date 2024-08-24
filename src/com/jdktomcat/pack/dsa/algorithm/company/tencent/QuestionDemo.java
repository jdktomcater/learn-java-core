package com.jdktomcat.pack.dsa.algorithm.company.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDemo {


    private static Integer find(List<Integer> list) {
        if (list != null && list.size() != 0) {
            int midIndex = list.size() / 2;
            if (midIndex != 0 && midIndex < list.size() - 1) {
                if (Math.abs(list.get(midIndex - 1)) < Math.abs(list.get(midIndex))) {
                    return find(list.subList(0, midIndex));
                } else if (Math.abs(list.get(midIndex + 1)) < Math.abs(list.get(midIndex))) {
                    return find(list.subList(midIndex + 1, list.size()));
                }
            }
            return list.get(midIndex);
        }
        return -1;
    }

    Integer getM(ArrayList<Integer> list) {
        return 0;
    }

    private static List<Integer> merge(List<List<Integer>> lists) {
        List<Integer> targetList = new ArrayList<>();
        boolean isContinue = true;
        while (isContinue) {
            Integer target = Integer.MAX_VALUE;
            Integer index = -1;
            boolean hasNumber = false;
            for (int i = 0; i < lists.size(); i++) {
                List<Integer> list = lists.get(i);
                if (list != null && list.size() != 0 && list.get(0) < target) {
                    target = list.get(0);
                    index = i;
                    hasNumber = true;
                }
            }
            if (hasNumber) {
                targetList.add(target);
                List<Integer> inList = lists.get(index);
                inList.remove(0);
                continue;
            }
            isContinue = false;
        }
        return targetList;
    }

    private static List<Integer> merge(List<Integer> targetList, List<Integer> sourceList) {
        int indexTarget = 0;
        int indexSource = 0;
        List<Integer> temp = new ArrayList<>();
        while (indexTarget < targetList.size() && indexSource < sourceList.size()) {
            temp.add(targetList.get(indexTarget) < sourceList.get(indexSource) ? targetList.get(indexTarget++) : sourceList.get(indexSource++));
        }
        if (indexTarget < targetList.size()) {
            temp.addAll(targetList.subList(indexTarget, targetList.size()));
        }
        if (indexSource < sourceList.size()) {
            temp.addAll(sourceList.subList(indexSource, sourceList.size()));
        }
        return temp;
    }

    private static List<Integer> merge2(List<List<Integer>> lists) {
        List<Integer> targetList = new ArrayList<>();
        for (List<Integer> list : lists) {
            targetList = merge(targetList, list);
        }
        return targetList;
    }


    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{-20, -13, -4, 6, 77, 200};
        Integer[] array2 = new Integer[]{-21, -12, -3, 7, 78, 201};
        Integer[] array3 = new Integer[]{-22, -14, -5, 8, 79, 202};
        Integer[] array4 = new Integer[]{-23, -15, -2, 9, 80, 203};
        List<List<Integer>> dataList = new ArrayList<>();
        dataList.add(new ArrayList<>(Arrays.asList(array1)));
        dataList.add(new ArrayList<>(Arrays.asList(array2)));
        dataList.add(new ArrayList<>(Arrays.asList(array3)));
        dataList.add(new ArrayList<>(Arrays.asList(array4)));
        System.out.println(merge2(dataList));

    }
}
