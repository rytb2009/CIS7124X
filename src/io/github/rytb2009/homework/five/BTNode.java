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
        return findMaxPathSumHelper(node, 0);
    }
    
    private static int findMaxPathSumHelper(BTNode<Integer> node, int result) {
		if (node == null) {
			return result;
		}
		result += node.data;
		return Math.max(findMaxPathSumHelper(node.left, result), findMaxPathSumHelper(node.right, result));
	}

    public static <T extends Comparable> boolean isBST(BTNode<T> node) {
        return isBSTHelper(node, null, null);
    }

    private static <T extends Comparable> boolean isBSTHelper(BTNode<T> node, T maximum, T minimum) {
        if (node == null) {
            return true;
        }
        T data = node.data;
        boolean leftOK = node.getLeft() == null || node.getLeft().getData() == null
                || data.compareTo(node.getLeft().getData()) == 1;
        leftOK = leftOK && (maximum == null || data.compareTo(maximum) == -1);
        boolean rightOK = node.getRight() == null || node.getRight().getData() == null
                || data.compareTo(node.getRight().getData()) == -1;
        rightOK = rightOK && (minimum == null || data.compareTo(minimum) == 1);
        return leftOK && rightOK && isBSTHelper(node.left, data, minimum) && isBSTHelper(node.right, maximum, data);
    }

    public static <T> boolean isExist(BTNode<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (node.data.equals(value)) {
            return true;
        }
        return isExist(node.right, value) || isExist(node.left, value);
    }

    public static <T extends Comparable>  BTNode<T> insert(BTNode<T> node, T value) {
        if (node == null) {
            return new BTNode<T>(value);
        }
        if (value.compareTo(node.getData()) == 1) {
            node.setRight(insert(node.getRight(), value));
        } else if (value.compareTo(node.getData()) == -1) {
            node.setLeft(insert(node.getLeft(), value));
        }
        return node;
    }
}
