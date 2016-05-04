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

            while (holeIndex > 0 && array[holeIndex -1 ] > current) {

                array[holeIndex] = array[holeIndex -1];
                holeIndex --;
            }

            array[holeIndex] = current;
        }

        return array;
    }
}
