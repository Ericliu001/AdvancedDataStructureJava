package com.ericliu.developer.pracises;

/**
 * Created by ericliu on 26/05/2016.
 */
public class SortingPractise {

    public static <E> void sort(E[] array) {
        Object[] aux = array.clone();
        mergeSort(aux, array, 0, array.length);
    }

    private static int INSERTION_SORT_THRESHOLD = 4;


    private static void mergeSort(
            Object[] src
            , Object[] dest
            , int low
            , int high
    ) {

        int length = high - low;
        int mid = (low + high) >>> 1;


        if (length < INSERTION_SORT_THRESHOLD) {
            for (int i = low + 1; i < high; i++) {
                for (int j = i; j > low && ((Comparable)dest[j]).compareTo(dest[j - 1]) < 0; j--) {
                    swap(dest, j, j-1);
                }
            }
            return;
        }


        mergeSort(dest, src, low, mid);
        mergeSort(dest, src, mid, high);


        if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, 0, dest, 0, src.length);
            return;
        }

        for (int i = low, leftFinger = low, rightFinger = mid; i < high; i++) {
            if (rightFinger == high || leftFinger < mid && ((Comparable) src[leftFinger]).compareTo(src[rightFinger]) < 0) {
                dest[i] = src[leftFinger++];
            } else {
                dest[i] = src[rightFinger++];
            }

        }


    }


    private static void swap(Object[] array, int x, int y){
        Object temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
