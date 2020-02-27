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
            if (preData != null && preData.compareTo(curData) == 1) {
                return false;
            }
            preData = curData;
            cur = cur.next;
        }
        return true;
    }

    public ListNode<T> merge(ListNode<T> node) {
        return null;
    }

    public boolean hasCycle() {
        Set<T> set = new HashSet<>();
        ListNode<T> cur = this;
        while (cur != null) {
            if (set.contains(cur.data)) {
                return true;
            }
            set.add(cur.data);
            cur = cur.next;
        }
        return false;
    }

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
