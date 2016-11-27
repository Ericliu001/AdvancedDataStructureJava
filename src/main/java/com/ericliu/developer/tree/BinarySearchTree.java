package com.ericliu.developer.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by ericliu on 30/04/2016.
 */
public class BinarySearchTree {
    public BstNode root;


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


    public void traverseBFS() {
        System.out.print("\n");
        Queue<BstNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        BstNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }

            System.out.print(current.data + ", ");


        }
        System.out.print("\n");
    }

    public void preorder() {
        if (root == null) {
            return;
        }
        System.out.print("\n");

        Stack<BstNode> stack = new Stack<>();
        BstNode current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.data + ", ");

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }


        }

        System.out.print("\n");
    }

    public void inorder() {
        if (root == null) {
            return;
        }
        System.out.print("\n");

        Stack<BstNode> stack = new Stack<>();
        BstNode current = root;

        while (!stack.empty() || current != null) {

            if (current != null) {
                stack.push(current);
                current = current.left;

            } else {
                current = stack.pop();
                System.out.print(current.data + ", ");
                current = current.right;
            }

        }

        System.out.print("\n");

    }


    public void postorder(BstNode root) {
        if (root == null) return;

        Stack<BstNode> s = new Stack<BstNode>();
        BstNode current = root;

        while (true) {

            if (current != null) {
                if (current.right != null)
                    s.push(current.right);
                s.push(current);
                current = current.left;
                continue;
            }

            if (s.isEmpty())
                return;
            current = s.pop();

            if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
                s.pop();
                s.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        }
    }


    public void recursiveInorder() {
        System.out.println();
        recursiveTraverse(root);
    }

    /**
     * Traverse the tree recursively
     * @param root
     */
    private void recursiveTraverse(BstNode root) {
        if (root == null) {
            return;
        }

        recursiveTraverse(root.left);

        System.out.print(root.data + ", ");

        recursiveTraverse(root.right);
    }

}
