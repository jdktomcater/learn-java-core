package com.jdktomcat.pack.dsa.algorithm.book.offer.sort.p78;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortListTest {

    @Test
    public void mergeKListsMinHeap() {
        int[][] datas = {{10, 7, 1, 234, 65, 956}, {0, 12120, 12, 23, 4, 78}, {8, 99, 45456}};
        ListNode[] heads = new ListNode[datas.length];
        for (int i = 0; i < datas.length; i++) {
            heads[i] = ListNode.build(datas[i]);
        }
        ListNode head = MergeSortList.mergeKListsMinHeap(heads);
        System.out.println(Arrays.toString(ListNode.rebuild(head)));
    }


    @Test
    public void mergeKListsMerge() {
    }
}