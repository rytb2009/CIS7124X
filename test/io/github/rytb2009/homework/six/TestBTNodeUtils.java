package io.github.rytb2009.homework.six;

import io.github.rytb2009.homework.five.BTNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBTNodeUtils {

    @Test
    void leftMost() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);

        assertEquals(5, BTNodeUtils.leftMost(node1));
    }


    @Test
    void preorder() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);
        List<Integer> preorderList = BTNodeUtils.preorder(node1);
        assertEquals(preorderList, new LinkedList<Integer>(){
            { add(20);add(10);add(5);add(6);add(3); }
        });
    }

    @Test
    void layer() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);
        BTNode<Integer> node1RightLeft = new BTNode<>(1);
        node1Right.setLeft(node1RightLeft);
        BTNode<Integer> node1RightRight = new BTNode<>(2);
        node1Right.setRight(node1RightRight);
        List<Integer> layerList = BTNodeUtils.layer(node1, 3);
        assertEquals(layerList, new LinkedList<Integer>(){
            { add(5);add(6);add(1);add(2); }
        });
    }

    @Test
    void bfsOrder() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(6);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(3);
        node1.setRight(node1Right);
        List<Integer> bfsList = BTNodeUtils.bfsOrder(node1);
        assertEquals(bfsList, new LinkedList<Integer>(){
            { add(20);add(10);add(3);add(5);add(6); }
        });
    }

    @Test
    void occurs() {
        BTNode<Integer> node1 = new BTNode<>(20);
        BTNode<Integer> node1Left = new BTNode<>(10);
        node1.setLeft(node1Left);
        BTNode<Integer> node1LeftLeft = new BTNode<>(5);
        node1Left.setLeft(node1LeftLeft);
        BTNode<Integer> node1LeftRight = new BTNode<>(16);
        node1Left.setRight(node1LeftRight);
        BTNode<Integer> node1Right = new BTNode<>(30);
        node1.setRight(node1Right);
        BTNode<Integer> node1RightLeft = new BTNode<>(25);
        node1Right.setLeft(node1RightLeft);
        BTNode<Integer> node1RightRight = new BTNode<>(35);
        node1Right.setRight(node1RightRight);
        BTNode<Integer> node1RightRightLeft = new BTNode<>(32);
        node1RightRight.setLeft(node1RightRightLeft);
        assertFalse(BTNodeUtils.occurs(node1, 9));
        assertTrue(BTNodeUtils.occurs(node1, 32));
    }

    @Test
    void wellFormed() {
        assertFalse(BTNodeUtils.wellFormed("{(sdsdaf])}"));
        assertTrue(BTNodeUtils.wellFormed("{([sds[AA]daf])}"));
        assertTrue(BTNodeUtils.wellFormed("{([sds([{a}](d)daf])}"));
    }
}