package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class MergeSort extends Sort {
    @Override
    public int[] sort(int[] array) {
        if (array.length < 2) { // notice it's the array's length, not sub array's length
            return array;
        }
        int subLength = array.length/2;

        int[] left = new int[subLength];
        int[] right = new int[array.length - subLength]; // notice the length here
        for (int i = 0; i < subLength; i++) {
            left[i] = array[i];
        }

        for (int i = subLength; i < array.length; i++) {
            right[i - subLength] = array[i]; // notice the right array's index here
        }

        sort(left);
        sort(right);
        merge(left, right, array);

        return array;
    }


    public void merge(int[] left, int[] right, int[] merged) {
        int i = 0, j = 0,  k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                k++;
                i++;
            } else {
                merged[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < left.length) {
            merged[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            merged[k] = right[j];
            k++;
            j++;
        }

    }
}
