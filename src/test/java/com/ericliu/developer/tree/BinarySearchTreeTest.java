package com.ericliu.developer.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 30/04/2016.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree mTree;

    @Before
    public void setUp() throws Exception {
        mTree = new BinarySearchTree();
    }

    @After
    public void tearDown() throws Exception {
        mTree = null;
    }

    @Test
    public void testInsert() throws Exception {
        mTree.insert(5);
        mTree.insert(3);
        mTree.insert(7);
        mTree.insert(2);
        mTree.insert(1);
        mTree.insert(6);
        mTree.insert(8);
        mTree.insert(9);
        mTree.insert(10);
        mTree.insert(4);

    }
}