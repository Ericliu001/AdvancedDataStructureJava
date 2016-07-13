package com.ericliu.developer.heap;

/**
 * Created by ericliu on 12/07/2016.
 */
public class IntegerMaxHeap {

    private static final int INITIAL_CAPACITY = 4;
    private int[] queue;
    private int size;

    public IntegerMaxHeap() {
        queue = new int[INITIAL_CAPACITY];
    }

    public IntegerMaxHeap(int[] array) {
        queue = array;
        size = array.length;
        heapify();
    }


    public void add(int data) {
        if (size == queue.length) {
            growSpace();
        }

        queue[size] = data;
        siftUp(size);
        size++;
    }

    private void growSpace() {
        int[] newArray = new int[queue.length * 2];
        for (int i = 0; i < queue.length; i++) {
            newArray[i] = queue[i];
        }
        queue = newArray;
    }


    public int poll() {
        if (size == 0) {
            return -1;
        }

        int max = queue[0];
        swap(0, --size);
        siftDown(0);
        return max;
    }

    private void heapify() {
        for (int i = (size/2) - 1; i >= 0 ; i--) { // skip all the leaf nodes, k >= size/2
            siftDown(i);
        }

    }


    private void siftUp(int index) {
        while (index > 0) {

            int parent = (index - 1)/2;
            if (queue[parent] >= queue[index]) {
                break;
            }
            swap(index, parent);
            index = parent;
        }

    }

    private void siftDown(int index) {
        while (index < size / 2) { // index is not a leaf node
            int child = index*2 + 1; // left Child
            if (child + 1 < size && queue[child] < queue[child + 1]) { //it is important to check if (child + 1) is out of boundary
                child ++; // right child
            }
            if (queue[index] >= queue[child]) {
                break;
            }
            swap(index, child);
            index = child;
        }


    }

    private void swap(int a, int b) {
        // swap data between 2 nodes
        int temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }

}
