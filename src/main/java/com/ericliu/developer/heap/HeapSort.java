package com.ericliu.developer.heap;

/**
 * Created by ericliu on 12/07/2016.
 */
public class HeapSort {

    public static void heapSort(int[] src) {
        IntegerMaxHeap heap = new IntegerMaxHeap(src);
        for (int i = src.length - 1; i >= 0; i--) {
            src[i] = heap.poll();
        }
    }

}
