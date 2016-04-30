package com.ericliu.developer.tree;

/**
 * Created by ericliu on 30/04/2016.
 */
public class BinarySearchTree {
    private BstNode root;


    public void insert(int data) {
        BstNode node = new BstNode();
        node.data = data;
        node.left = node.right = null;

        if (root == null) {
            root = node;
            return;
        }

        BstNode temp = root;
        while (temp != null) {
            if (node.data <= temp.data) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                }
                temp = temp.right;
            }
        }
    }


}
