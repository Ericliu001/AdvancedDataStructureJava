package com.ericliu.developer;

import com.ericliu.developer.tree.BstNode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ericliu on 18/07/2016.
 */
public class Exercises {

    //=====================Quick Sort=================================
    public void quickSort(int[] src, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = partition(src, start, end);
        quickSort(src, start, partitionIndex - 1);
        quickSort(src, partitionIndex + 1, end);

    }

    private int partition(int[] src, int start, int end) {
        if (start >= end) {
            return start; // notice it is start, NOT 0
        }

        int partitionIndex = start;

        for (int i = start; i < end; i++) {
            if (src[i] < src[end]) {

                swap(src, i, partitionIndex);

                partitionIndex++;
            }
        }

        swap(src, partitionIndex, end);

        return partitionIndex;
    }

    private void swap(int[] src, int x, int y) {
        if (x == y) {
            return;
        }

        int temp = src[x];
        src[x] = src[y];
        src[y] = temp;
    }


    @Test
    public void testQuickSort() {

        int[] srcArray = new int[]{6, 2, 1, 5, 6, 9, 3, 7, 4, 8};
        quickSort(srcArray, 0, srcArray.length - 1);
        printArray(srcArray);
    }


    private void printArray(int[] srcArray) {
        System.out.print("\n");
        for (int i : srcArray) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }


    //=====================Merge Sort=================================

    public void mergeSort(int[] array) {
        int[] src = array.clone();
        mergeSort(src, array, 0, array.length - 1);
    }

    private void mergeSort(int[] src, int[] dest, int start, int end) {
        if (end - start < 2) {
            if (dest[end] < dest[start]) {
                swap(dest, start, end);
            }
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(dest, src, start, mid - 1);
        mergeSort(dest, src, mid, end);

        if (src[mid - 1] < src[mid]) {
            // array sorted already
            System.arraycopy(src, start, dest, start, end - start + 1);
            return;
        }


        for (int write = start, readLeft = start, readRight = mid; write <= end; write++) {
            if (readRight > end || (readLeft < mid && src[readLeft] < src[readRight])) {
                dest[write] = src[readLeft++];
            } else {
                dest[write] = src[readRight++];
            }

        }


    }

    @Test
    public void testMergeSort() {

        int[] srcArray = new int[]{6, 2, 1, 5, 6, 9, 3, 7, 4, 8};
        mergeSort(srcArray);
        printArray(srcArray);
    }


    //=====================Binary Search Tree=================================
    public BstNode insertBst(BstNode root, int data) {
        BstNode node = new BstNode();
        node.data = data;
        node.left = null;
        node.right = null;

        if (root == null) {
            return node;
        }


        BstNode current = root;
        while (current != null) {
            if (data <= current.data) {
                if (current.left == null) {
                    current.left = node;
                    return root;
                } else {
                    current = current.left;
                }


            } else {

                if (current.right == null) {
                    current.right = node;
                    return root;
                } else {
                    current = current.right;
                }

            }


        }

        return root;
    }

    public void preorderNonRecursive(BstNode root) {
        if (root == null) {
            return;
        }

        Deque<BstNode> stack = new ArrayDeque<>();
        stack.push(root);
        BstNode current = null;

        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(" " + current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

        }
    }

    @Test
    public void testBst(){
        BstNode root = insertBst(null, 5);
        insertBst(root, 3);
        insertBst(root, 7);
        insertBst(root, 2);
        insertBst(root, 1);
        insertBst(root, 6);
        insertBst(root, 8);
        insertBst(root, 9);
        insertBst(root, 10);
        insertBst(root, 4);

        preorderNonRecursive(root);

    }


}
