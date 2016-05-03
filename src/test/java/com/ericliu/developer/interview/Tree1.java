package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by ericliu on 2/05/2016.
 * <p/>
 * <p/>
 * Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.
 * Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.
 * <p/>
 * <p/>
 * Input:
 * 6
 * / \
 * 3   4
 * / \   \
 * 5   1   0
 * / \     /
 * 9   2   8
 * \
 * 7
 * <p/>
 * Output:
 * 9 5 3 2 6 1 7 4 8 0
 * <p/>
 * Input:
 * 1
 * /   \
 * 2     3
 * / \   / \
 * 4   5 6   7
 * <p/>
 * When two nodes share the same position (e.g. 5 and 6), they may be printed in either order:
 * <p/>
 * Output:
 * 4 2 1 5 6 3 7
 * or:
 * 4 2 1 6 5 3 7
 */
public class Tree1 {
    private Node root;
    private List<Node> mNodeList = new ArrayList<>();

    private static class Node implements Comparable<Node> {
        public int x, y;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        public int data;
        public Node left, right;

        @Override
        public int compareTo(Node o) {
            if (x == o.x && y == o.y) {
                return 0;
            } else if (x > o.x) {
                return 1;
            } else if (x < o.x) {
                return -1;
            } else if (x == o.x && y > o.y) {
                return 1;
            } else if (x == o.x && y < o.y) {
                return -1;
            }

            return 0;
        }
    }


    public void traverse() {
        if (root == null) {
            return;
        }
        Node current = root;
        root.x = 0;
        root.y = 0;

        Stack<Node> stack = new Stack<>();
        stack.push(current);
        int x, y = 0;


        System.out.print("\n");
        while (stack.size() > 0) {
            current = stack.pop();
            mNodeList.add(current);
            System.out.print(current.data + " x:" + current.x + " y:" + current.y + ", ");


            x = current.x;
            y = current.y;


            if (current.right != null) {
                stack.push(current.right);
                current.right.x = x + 1;
                current.right.y = y - 1;
            }

            if (current.left != null) {
                stack.push(current.left);
                current.left.x = x - 1;
                current.left.y = y - 1;
            }
        }
        System.out.print("\n");

    }

    @Test
    public void testTree() {
        constructTheTree();

    }


    private void constructTheTree() {

        Node parent, childLeft, childRight;

        root = parent = new Node(6);
        childLeft = new Node(3);
        childRight = new Node(4);

        parent.left = childLeft;
        parent.right = childRight;

        parent = childLeft;

        childLeft = new Node(5);
        childRight = new Node(1);

        parent.left = childLeft;
        parent.right = childRight;

        parent = childLeft;
        childLeft = new Node(9);
        childRight = new Node(2);

        parent.left = childLeft;
        parent.right = childRight;

        parent = childRight;
        childRight = new Node(7);
        parent.right = childRight;

        parent = root.right;
        childRight = new Node(0);
        parent.right = childRight;

        parent = childRight;
        childLeft = new Node(8);

        parent.left = childLeft;

        traverse();

        Collections.sort(mNodeList);
        System.out.print("\n");

        for (Node node : mNodeList) {

            System.out.print(node.data + ", ");

        }

        System.out.print("\n");

    }
}
