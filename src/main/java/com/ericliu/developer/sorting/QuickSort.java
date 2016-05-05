package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 5/05/2016.
 */
public class QuickSort extends Sort {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }


    private void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotingIndex = partition(array, start, end);
        quickSort(array, start, pivotingIndex - 1);
        quickSort(array, pivotingIndex + 1, end);

    }


    private int partition(int[] array, int start, int end) {
        if (start >= end) {
            return start; // notice it is start, NOT 0
        }

        int pivotValue = array[end]; // notice it is end here, NOT array.length
        int pivotingIndex = start; // notice it IS NOT 0 here, but start
        for (int i = start; i < end; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, pivotingIndex);
                pivotingIndex++;
            }
        }
        swap(array, end, pivotingIndex);


        return pivotingIndex;
    }

    private void swap(int[] array, int x, int y) {
        if (x == y) {
            return;
        }

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
