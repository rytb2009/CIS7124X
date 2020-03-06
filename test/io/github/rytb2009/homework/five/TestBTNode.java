package io.github.rytb2009.homework.five;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        BTNode<Integer> node1 = new BTNode<>(5);
        BTNode<Integer> node1Left = new BTNode<>(1);
        node1.setLeft(node1Left);
        BTNode<Integer> node1Right = new BTNode<>(6);
        node1.setRight(node1Right);
        BTNode<Integer> node1RightLeft = new BTNode<>(4);
        node1Right.setLeft(node1RightLeft);
        BTNode<Integer> node1RightRight = new BTNode<>(7);
        node1Right.setRight(node1RightRight);
        assertFalse(BTNode.isBST(node1));

        BTNode<Integer> node2 = new BTNode<>(20);
        BTNode<Integer> node2Left = new BTNode<>(10);
        node2.setLeft(node2Left);
        BTNode<Integer> node2LeftLeft = new BTNode<>(5);
        node2Left.setLeft(node2LeftLeft);
        BTNode<Integer> node2LeftRight = new BTNode<>(11);
        node2Left.setRight(node2LeftRight);
        BTNode<Integer> node2Right = new BTNode<>(25);
        node2.setRight(node2Right);
        assertTrue(BTNode.isBST(node2));
    }

    @Test
    public void testFindMaxPathSum() {
        BTNode<Integer> node = new BTNode<>(5);
        BTNode<Integer> node1Left = new BTNode<>(1);
        node.setLeft(node1Left);
        BTNode<Integer> node1Right = new BTNode<>(-6);
        node.setRight(node1Right);
        BTNode<Integer> node1RightLeft = new BTNode<>(-4);
        node1Right.setLeft(node1RightLeft);
        BTNode<Integer> node1RightRight = new BTNode<>(8);
        node1Right.setRight(node1RightRight);
        assertEquals(7, BTNode.findMaxPathSum(node));
    }

    @Test
    public void testIsExist() {
        BTNode<Integer> node = new BTNode<>(5);
        BTNode<Integer> node1Left = new BTNode<>(1);
        node.setLeft(node1Left);
        BTNode<Integer> node1Right = new BTNode<>(-6);
        node.setRight(node1Right);
        BTNode<Integer> node1RightLeft = new BTNode<>(-4);
        node1Right.setLeft(node1RightLeft);
        BTNode<Integer> node1RightRight = new BTNode<>(8);
        node1Right.setRight(node1RightRight);
        assertFalse(BTNode.isExist(node,10));
        assertTrue(BTNode.isExist(node,8));
    }

    @Test
    public void testInsert() {
        BTNode<Integer> node = new BTNode<>(20);
        BTNode.insert(node, 10);
        assertEquals(10, node.left.getData());
        BTNode.insert(node, 5);
        assertEquals(5, node.left.left.getData());
        BTNode.insert(node, 6);
        assertEquals(6, node.left.left.right.getData());
        BTNode.insert(node, 22);
        assertEquals(22, node.right.getData());
        BTNode.insert(node, 11);
        assertEquals(11, node.left.right.getData());
    }
}
