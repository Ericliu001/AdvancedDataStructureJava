package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class MergeSort extends Sort {

    /**
     * Bad implementation, better implementation below
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length < 2) { // notice it's the array's length, not sub array's length
            return array;
        }
        int subLength = array.length / 2;

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
        int i = 0, j = 0, k = 0;

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


    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }


    /**
     * The production grade implementation
     * @param array
     */
    public static void mergeSort(int[] array) {
        int[] src = array.clone();
        mergeSort(src, array, 0, array.length - 1);
    }

    private static void mergeSort(int[] src, int[] dest, int start, int end) {
        if (end - start < 2) {
            if (dest[end] < dest[start]) {
                swap(dest, start, end);
            }
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(dest, src, start, mid);
        mergeSort(dest, src, mid + 1, end);

        if (src[mid] < src[mid + 1]) {
            // array sorted already
            System.arraycopy(src, start, dest, start, end - start + 1);
            return;
        }


        for (int write = start, readLeft = start, readRight = mid + 1; write <= end; write++) {
            if (readRight > end || (readLeft <= mid && src[readLeft] < src[readRight])) {
                dest[write] = src[readLeft++];
            } else {
                dest[write] = src[readRight++];
            }
        }
    }
}
