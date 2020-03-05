package io.github.rytb2009.homework.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        next = null;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public boolean isSortedAscending() {
        if (!(data instanceof Comparable)) {
            return false;
        }
        Comparable preData = null;
        ListNode<T> cur = this;
        while (cur != null) {
            Comparable curData = (Comparable) cur.data;
            if (preData != null && preData.compareTo(curData) >= 1) {
                return false;
            }
            preData = curData;
            cur = cur.next;
        }
        return true;
    }

    public <S extends Comparable> ListNode<S> merge(ListNode<S> ln) {
        if (!(data instanceof Comparable)) {
            throw new RuntimeException("Node must be Comparable");
        }
        ListNode<S> c = (ListNode<S>) this;
        return sortedMerge(c, ln);
    }

    private static <S extends Comparable> ListNode<S> sortedMerge(ListNode<S> a, ListNode<S> b) {
        if (b == null) {
            return a;
        }
        if (a == null) {
            return b;
        }
        ListNode<S> result = null;
        if (a.data.compareTo(b.data) <= 0) {
            result = new ListNode<>(a.data, sortedMerge(a.next, b));
        } else {
            result = new ListNode<>(b.data, sortedMerge(a, b.next));
        }
        return result;
    }

    public boolean hasCycle() {
        Set<ListNode<T>> set = new HashSet<>();
        ListNode<T> cur = this;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }

    // Could use Mark and Sweep method adding additional information during traversal
    public void removeDuplicate() {
        Set<T> set = new HashSet<>();
        ListNode<T> pre = null;
        ListNode<T> cur = this;
        while (cur != null) {
            if (set.contains(cur.data)) {
                pre.next = cur.next;
            } else {
                set.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public boolean isPalindromic() {
        List<T> valueList = new ArrayList<>();
        ListNode<T> cur = this;
        while (cur != null) {
            valueList.add(cur.data);
            cur = cur.next;
        }
        int size = valueList.size();
        for (int i = 0; i < size / 2; i++) {
            if (!valueList.get(i).equals(valueList.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
