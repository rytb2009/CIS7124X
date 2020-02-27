package io.github.rytb2009.homework.four;

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

    }

    @Test
    public void testHasCycle() {

    }

    @Test
    public void testRemoveDuplicate() {

    }

    @Test
    public void testIsPalindromic() {

    }
}
