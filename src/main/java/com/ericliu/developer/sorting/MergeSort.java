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




    /**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort.
     * To be removed in a future release.
     */
    private static final int INSERTIONSORT_THRESHOLD = 7;

    /**
     * Src is the source array that starts at index 0
     * Dest is the (possibly larger) array destination with a possible offset
     * low is the index in dest to start sorting
     * high is the end index in dest to end sorting
     * off is the offset to generate corresponding low, high in src
     * To be removed in a future release.
     */
    private static void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < INSERTIONSORT_THRESHOLD) {
            for (int i=low; i<high; i++)
                for (int j=i; j>low &&
                        ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
                    swap(dest, j, j-1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow  = low;
        int destHigh = high;
        low  += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }

    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
