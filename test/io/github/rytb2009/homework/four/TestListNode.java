package io.github.rytb2009.homework.four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestListNode {

    @Test
    public void testIsSortedAscending_Failed() {
        ListNode<Integer> first = new ListNode<>(4);
        ListNode<Integer> second = new ListNode<>(4);
        ListNode<Integer> third = new ListNode<>(3);
        ListNode<Integer> fourth = new ListNode<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        assertFalse(first.isSortedAscending());
    }

    @Test
    public void testIsSortedAscending_Success() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(2);
        ListNode<Integer> fourth = new ListNode<>(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        assertTrue(first.isSortedAscending());
    }

    @Test
    public void testMerge() {
        ListNode<Integer> firstListNodeOne = new ListNode<>(1);
        ListNode<Integer> firstListNodeTwo = new ListNode<>(3);
        ListNode<Integer> firstListNodeThree = new ListNode<>(5);
        firstListNodeOne.next = firstListNodeTwo;
        firstListNodeTwo.next = firstListNodeThree;

        ListNode<Integer> secondListNodeOne = new ListNode<>(1);
        ListNode<Integer> secondListNodeTwo = new ListNode<>(3);
        ListNode<Integer> secondListNodeThree = new ListNode<>(4);
        secondListNodeOne.next = secondListNodeTwo;
        secondListNodeTwo.next = secondListNodeThree;

        ListNode<Integer> result = firstListNodeOne.merge(secondListNodeOne);
        assertTrue(result.data == 1);
        assertTrue(result.next.data == 1);
        assertTrue(result.next.next.data == 3);
        assertTrue(result.next.next.next.data == 3);
        assertTrue(result.next.next.next.next.data == 4);
        assertTrue(result.next.next.next.next.next.data == 5);
    }

    @Test
    public void testHasCycle() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(2);
        first.next = second;
        second.next = third;
        assertFalse(first.hasCycle());

        third.next = first;
        assertTrue(first.hasCycle());
    }

    @Test
    public void testRemoveDuplicate() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(2);
        ListNode<Integer> fourth = new ListNode<>(1);
        first.next = second;
        second.next = third;
        third.next = fourth;
        first.removeDuplicate();
        assertTrue(first.next == second);
        assertNull(second.next);
    }

    @Test
    public void testIsPalindromic() {
        ListNode<Integer> first = new ListNode<>(1);
        ListNode<Integer> second = new ListNode<>(2);
        ListNode<Integer> third = new ListNode<>(3);
        first.next = second;
        second.next = third;
        assertFalse(first.isPalindromic());
        // odd
        ListNode<Integer> fourth = new ListNode<>(2);
        ListNode<Integer> fifth = new ListNode<>(1);
        third.next = fourth;
        fourth.next = fifth;
        assertTrue(first.isPalindromic());
        // even
        fourth.data = 3;
        fifth.data = 2;
        ListNode sixth = new ListNode<>(1);
        fifth.next = sixth;
        assertTrue(first.isPalindromic());
    }
}
