package com.jdktomcat.pack.dsa.algorithm.book.offer.list.p27;

import com.jdktomcat.pack.dsa.algorithm.book.offer.list.ListNode;
import com.jdktomcat.pack.dsa.algorithm.book.offer.list.p26.ReorderList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PalindromeListTest {

    @Test
    public void isPalindromeTrue() {
        int[] target = {1, 2, 3, 2, 1};
        ListNode node = ListNode.build(target);
        Assert.assertTrue(PalindromeList.isPalindrome(node));
    }

    @Test
    public void isPalindromeFalse() {
        int[] target = {1, 2, 3, 4, 5};
        ListNode node = ListNode.build(target);
        Assert.assertFalse(PalindromeList.isPalindrome(node));
    }
}