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
        int pivotIndex = start; // notice it IS NOT 0 here, but start
        for (int i = start; i < end; i++) {
            if (array[i] < pivotValue) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, end, pivotIndex);


        return pivotIndex;
    }

    private static void swap(int[] array, int x, int y) {
        if (x == y) {
            return;
        }

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


    /**
     *  3-way quick sort
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi)
    {  // See page 289 for public sort() that calls this method.
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }





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
     * @param a An integer array.
     * @param lo0 Left boundary of array partition.
     * @param hi0 Right boundary of array partition.
     */
    static void QuickSort(int a[], int lo0, int hi0) {
        int low = lo0;
        int high = hi0;
        int mid;

        if ( hi0 > lo0) {

            /* Arbitrarily establishing partition element as the midpoint of
             * the array.
             */
            mid = a[ ( lo0 + hi0 ) / 2 ];

            // loop through the array until indices cross
            while( low <= high ) {
                /* find the first element that is greater than or equal to
                 * the partition element starting from the left Index.
                 */
                while( ( low < hi0 )  && ( a[low] < mid ))
                    ++low;

                /* find an element that is smaller than or equal to
                 * the partition element starting from the right Index.
                 */
                while( ( high > lo0 ) && ( a[high] > mid ))
                    --high;

                // if the indexes have not crossed, swap
                if( low <= high ) {
                    swap(a, low, high);
                    ++low;
                    --high;
                }
            }

            /* If the right index has not reached the left side of array
             * must now sort the left partition.
             */
            if( lo0 < high )
                QuickSort( a, lo0, high );

            /* If the left index has not reached the right side of array
             * must now sort the right partition.
             */
            if( low < hi0 )
                QuickSort( a, low, hi0 );

        }
    }
}
