package com.ericliu.developer.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 12/06/2016.
 */
public class AVLTreeTest {

    AVLTree<Integer, String> mAVLTree;

    @Before
    public void setUp() throws Exception {
        mAVLTree = new AVLTree<>();
    }




    @After
    public void tearDown() throws Exception {
        mAVLTree = null;
    }


    @Test
    public void testBalancing(){
        mAVLTree.root = new AVLTree.Node<>(null, 2);


        AVLTree.Node<Integer, String> node1 = new AVLTree.Node<>(mAVLTree.root, 3);
        mAVLTree.root.right = node1;
        mAVLTree.rebalance(mAVLTree.root, true);


        AVLTree.Node<Integer, String> node2 = new AVLTree.Node<>(node1, 6);
        node1.right = node2;
        mAVLTree.rebalance(node1, true);
    }
}