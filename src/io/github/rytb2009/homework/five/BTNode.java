package io.github.rytb2009.homework.five;

import java.util.LinkedList;
import java.util.List;

public class BTNode<T> {
    T data;
    BTNode<T> left, right;

    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BTNode(T data, BTNode<T> left, BTNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    // root - left - right
    public static <T> List<T> traversalPreOrder(BTNode<T> node) {
        if (node == null) {
            return null;
        }
        List<T> list = new LinkedList<>();
        list.add(node.data);
        List<T> leftList = traversalPreOrder(node.left);
        if (leftList != null) list.addAll(leftList);
        List<T> rightList = traversalPreOrder(node.right);
        if (rightList != null) list.addAll(rightList);
        return list;
    }

    // left - root - right
    public static <T> List<T> traversalInOrder(BTNode<T> node) {
        if (node == null) {
            return null;
        }
        List<T> list = new LinkedList<>();
        List<T> leftList = traversalInOrder(node.left);
        if (leftList != null) list.addAll(leftList);
        list.add(node.data);
        List<T> rightList = traversalInOrder(node.right);
        if (rightList != null) list.addAll(rightList);
        return list;
    }

    // left - right - root
    public static <T> List<T> traversalPostOrder(BTNode<T> node) {
        if (node == null) {
            return null;
        }
        List<T> list = new LinkedList<>();
        List<T> leftList = traversalPostOrder(node.left);
        if (leftList != null) list.addAll(leftList);
        List<T> rightList = traversalPostOrder(node.right);
        if (rightList != null) list.addAll(rightList);
        list.add(node.data);
        return list;
    }

    public static boolean isSymmetric(BTNode<? extends Comparable> node1, BTNode<? extends Comparable> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if((node1 != null && node2 == null)
                || (node1 == null && node2 != null)
                || (node1.data.compareTo(node2.data) != 0)) {
            return false;
        }
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public static int findMaxPathSum(BTNode<Integer> node) {
        return 0;
    }

    public static boolean isBST(BTNode<? extends Comparable> root) {
        return false;
    }

    public static <T extends Comparable>  BTNode<T> insert(BTNode<T> root, T value) {

        return root;
    }
}
