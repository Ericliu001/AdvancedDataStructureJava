package com.ericliu.developer.binarysearch;

/**
 * Created by ericliu on 13/07/2016.
 */
public class BinarySearch {

    /**
     * To find if the key exists
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearch(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


    /**
     * to find the first occurrance of the key
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearchFirst(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int result = -1;
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                result = mid; // key found
                high = mid - 1;
            }

        }
        return result;
    }


    /**
     * to find the last occurrance of the key
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearchLast(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int result = -1;
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                result = mid; // key found
                low = mid + 1;
            }

        }
        return result;
    }



    /**
     * to find the lower bound of the bracket where the key falls
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearchLowerBound(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int result = -1;
        int low = fromIndex;
        int high = toIndex - 1;

        while ( high - low > 1) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid;
            } else if (midVal > key) {
                high = mid;
            } else {
                return mid; // key found
            }

        }
        return low;  // return the lower bound.
    }


    /**
     * to find the upper bound of the bracket where the key falls
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    public static int binarySearchUpperBound(int[] a, int fromIndex, int toIndex,
                                              int key) {
        int result = -1;
        int low = fromIndex;
        int high = toIndex - 1;

        while ( high - low > 1) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid;
            } else if (midVal > key) {
                high = mid;
            } else {
                return mid; // key found
            }

        }
        return high;  // return the upper bound
    }
}
