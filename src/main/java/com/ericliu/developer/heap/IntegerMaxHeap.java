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
    }


    public int poll() {
        if (size == 0) {
            return -1;
        }

        int max = queue[0];
        siftDown(0);
        size--;
        return max;
    }

    private void heapify() {
        for (int i = (size/2) - 1; i >= 0 ; i--) {
            siftDown(i);
        }

    }


    private void siftUp(int index) {
        while (index > 0) {

            int parent = (index - 1)/2;
            if (queue[parent] >= queue[index]) {
                break;
            }
            int temp = queue[index];
            queue[index] = queue[parent];
            queue[parent] = temp;
            index = parent;
        }

    }

    private void siftDown(int index) {
        while (index < size / 2) {
            int child = index*2 + 1; // left Child
            if (child + 1 < size && queue[child] < queue[child + 1]) { // it is important to check if (child + 1) is out of boundary or not
                child += 1; // right child
            }
            if (queue[index] >= queue[child]) {
                break; // the the parent's data is better than the child's, stop sifting down.
            }

            // swap data between 2 nodes
            int temp = queue[index];
            queue[index] = queue[child];
            queue[child] = temp;
            index = child;
        }

    }

}
