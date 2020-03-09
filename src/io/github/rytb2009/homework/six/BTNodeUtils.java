package io.github.rytb2009.homework.six;

import io.github.rytb2009.homework.five.BTNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTNodeUtils {

    public static <T> T leftMost(BTNode<T> root) {
        T leftMostData = null;
        BTNode<T> curLeft = root.getLeft();
        while (curLeft != null) {
            leftMostData = curLeft.getData();
            curLeft = curLeft.getLeft();
        }
        return leftMostData;
    }

    public static <T> List<T> preorder(BTNode<T> root) {
        Deque<BTNode<T>> dq = new ArrayDeque<>();
        dq.push(root);
        List<T> list = new LinkedList<>();
        while (!dq.isEmpty()) {
            BTNode<T> last = dq.pop();
            list.add((last.getData()));
            if (last.getRight() != null) {
                dq.push(last.getRight());
            }
            if (last.getLeft() != null) {
                dq.push(last.getLeft());
            }
        }
        return list;
    }

    public static <T> List<T> layer(BTNode<T> root, int n) {
        int visitedNodeCount = 0;
        int preLevelNodesCount = 1;
        int levelCounter = 1;
        Deque<BTNode<T>> dq = new ArrayDeque<>();
        dq.add(root);
        List<T> list = null;
        while (!dq.isEmpty()) {
            BTNode<T> last = dq.remove();
            if (list != null) list.add(last.getData());
            if (last.getLeft() != null) {
                dq.add(last.getLeft());
                visitedNodeCount++;
            }
            if (last.getRight() != null) {
                dq.add(last.getRight());
                visitedNodeCount++;
            }
            preLevelNodesCount--;
            if (preLevelNodesCount == 0) {
                levelCounter++;
                if (list != null) {
                    break;
                } else if (levelCounter == n) {
                    list = new LinkedList<>();
                }
                preLevelNodesCount = visitedNodeCount;
            }
        }
        return list;
    }

    public static <T> List<T> bfsOrder(BTNode<T> root) {
        Deque<BTNode<T>> dq = new ArrayDeque<>();
        dq.add(root);
        List<T> list = new LinkedList<>();
        while (!dq.isEmpty()) {
            BTNode<T> last = dq.remove();
            list.add((last.getData()));
            if (last.getLeft() != null) {
                dq.add(last.getLeft());
            }
            if (last.getRight() != null) {
                dq.add(last.getRight());
            }
        }
        return list;
    }
    public static <T extends Comparable<T>> boolean occurs(BTNode<T> root, T elm) {
        if (elm == null) {
            return false;
        }
        BTNode<T> cur = root;
        while (cur != null) {
            T data = cur.getData();
            if (elm.compareTo(data) == 0) {
                return true;
            }
            cur = elm.compareTo(data) == 1 ? cur.getRight() : cur.getLeft();
        }
        return false;
    }

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private static final char OPEN_SQR_BRACKET = '[';
    private static final char CLOSE_SQR_BRACKET = ']';
    private static final char OPEN_CURLY_BRACKET = '{';
    private static final char CLOSE_CURLY_BRACKET = '}';

    public static boolean wellFormed(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            switch(c) {
                case OPEN_BRACKET:
                case OPEN_SQR_BRACKET:
                case OPEN_CURLY_BRACKET:
                    dq.push(c);
                    continue;
                case CLOSE_BRACKET:
                     if (OPEN_BRACKET != dq.pop()) {
                         return false;
                     }
                    continue;
                case CLOSE_SQR_BRACKET:
                    if (OPEN_SQR_BRACKET != dq.pop()) {
                        return false;
                    }
                    continue;
                case CLOSE_CURLY_BRACKET:
                    if (OPEN_CURLY_BRACKET != dq.pop()) {
                        return false;
                    }
                    continue;
                default:
                    break;
            }
        }
        return true;
    }
}
