package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class InsertionSort extends Sort {
    @Override
    public int[] sort(int[] array) {
        int current, holeIndex;

        // i=1, start from the second position
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            holeIndex = i;

            while (holeIndex > 0 && array[holeIndex - 1] > current) {

                array[holeIndex] = array[holeIndex - 1];
                holeIndex--;
            }

            array[holeIndex] = current;
        }

        return array;
    }


    // production grade implementation

    public int[] insertionSort(int[] array) {

        for (int i = 0; i < array.length; i++)
            for (int j = i; j > 0 &&
                    array[j-1] > array[j] ; j--)
                swap(array, j, j - 1);
        return array;
    }

    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(int[] x, int a, int b) {
        if (a == b) {
            return;
        }
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
