package io.github.rytb2009.homework.five;

import java.util.List;

public class BTNodeUtils {

    public static void main(String[] args) {

    }

    static <T extends Comparable> List<T> traverseInOrder(BTNode<T> head) {
        return null;
    }

    static boolean isSymmetric(BTNode<Comparable> head) {
        return false;
    }

    static int maxPathSum(BTNode<Comparable> head) {
        return 0;
    }

    class BTNode<T> {
        T data;
        BTNode<T> left, right;

        public BTNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }

        public BTNode(T data, BTNode<T> left, BTNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
