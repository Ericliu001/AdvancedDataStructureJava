package com.ericliu.developer.examples;

/**
 * Created by ericliu on 17/07/2016.
 */
public class QuickSort {


    /**
     * This is a generic version of C.A.R Hoare's Quick Sort
     * algorithm.  This will handle arrays that are already
     * sorted, and arrays with duplicate keys.
     *
     * If you think of a one dimensional array as going from
     * the lowest index on the left to the highest index on the right
     * then the parameters to this function are lowest index or
     * left and highest index or right.  The first time you call
     * this function it will be with the parameters 0, a.length - 1.
     *
     * @param data An integer array.
     * @param low Left boundary of array partition.
     * @param high Right boundary of array partition.
     */
    static void quickSort(int data[], int low, int high) {
        int leftPointer = low;
        int rightPointer = high;
        int mid;

        if ( high > low) {

            /* Arbitrarily establishing partition element as the midpoint of
             * the array.
             */
            mid = data[ ( low + high ) / 2 ];

            // loop through the array until indices cross
            while( leftPointer <= rightPointer ) {
                /* find the first element that is greater than or equal to
                 * the partition element starting from the left Index.
                 */
                while( ( leftPointer < high )  && ( data[leftPointer] < mid ))
                    ++leftPointer;

                /* find an element that is smaller than or equal to
                 * the partition element starting from the right Index.
                 */
                while( ( rightPointer > low ) && ( data[rightPointer] > mid ))
                    --rightPointer;

                // if the indexes have not crossed, swap
                if( leftPointer <= rightPointer ) {
                    swap(data, leftPointer, rightPointer);
                    ++leftPointer;
                    --rightPointer;
                }
            }

            /* If the right index has not reached the left side of array
             * must now sort the left partition.
             */
            if( low < rightPointer )
                quickSort( data, low, rightPointer );

            /* If the left index has not reached the right side of array
             * must now sort the right partition.
             */
            if( leftPointer < high )
                quickSort( data, leftPointer, high );

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
}
