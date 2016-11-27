package com.ericliu.developer.interview;

import com.ericliu.developer.tree.BinarySearchTree;
import com.ericliu.developer.tree.BstNode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by ericliu on 27/11/16.
 */

public final class SumOfTree {

    private BinarySearchTree tree;


    @Before
    public void setUp() {
        tree = new BinarySearchTree();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int data = random.nextInt(10);
            tree.insert(data);
            System.out.print(data + ", ");
        }
        System.out.println();

    }

    @After
    public void tearDown() {
        tree = null;
    }

    @Test
    public void testSumOfTree() {
        int sum = sumOfTree(tree.root);
        System.out.println("Sum is: " + sum);
        assertTrue(sum > 0);
    }


    public int sumOfTree(BstNode root) {
        if (root == null) {
            return 0;
        }

        int sumLeft = sumOfTree(root.left);
        int sumRight = sumOfTree(root.right);

        return sumLeft + sumRight + root.data;
    }
}
