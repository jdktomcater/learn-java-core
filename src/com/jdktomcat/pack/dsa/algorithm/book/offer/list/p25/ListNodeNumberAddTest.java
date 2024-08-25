package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p25;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ListNodeNumberAddTest {

    @Test
    public void addTwoNumbers() {
        int[] target = {1, 2, 3, 4, 5, 6};
        ListNode head1 = ListNode.build(target);
        ListNode head2 = ListNode.build(target);
        ListNode head = ListNodeNumberAdd.addTwoNumbers(head1, head2);
        String result = Arrays.toString(ListNode.rebuild(head));
        Assert.assertEquals("[2, 4, 6, 9, 1, 2]", result);
    }
}