package io.github.rytb2009.homework.five;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBTNode {

    @Test
    public void testTraversal() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);
        List<Integer> preorderList = BTNode.traversalPreOrder(node1);
        System.out.println(preorderList);
        assertEquals(preorderList, new LinkedList<Integer>(){
            { add(20);add(10);add(5);add(6);add(3); }
        });
        List<Integer> inorderList = BTNode.traversalInOrder(node1);
        System.out.println(inorderList);
        assertEquals(inorderList, new LinkedList<Integer>(){
            { add(5);add(10);add(6);add(20);add(3); }
        });
        List<Integer> postorderList = BTNode.traversalPostOrder(node1);
        System.out.println(postorderList);
        assertEquals(postorderList, new LinkedList<Integer>(){
            { add(5);add(6);add(10);add(3);add(20); }
        });
    }

    @Test
    public void testIsSymmetric() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);

        BTNode<Integer> node2 = new BTNode<>(20);
        BTNode<Integer> node2Left = new BTNode<>(3);
        node2.setLeft(node2Left);
        BTNode<Integer> node2Right = new BTNode<>(10);
        node2.setRight(node2Right);
        BTNode<Integer> node2RightLeft = new BTNode<>(6);
        node2Right.setLeft(node2RightLeft);
        BTNode<Integer> node2RightRight = new BTNode<>(5);
        node2Right.setRight(node2RightRight);
        assertTrue(BTNode.isSymmetric(node1, node2));
    }

    @Test
    public void testIsBST() {

    }

    @Test
    public void testInsert() {

    }
}
