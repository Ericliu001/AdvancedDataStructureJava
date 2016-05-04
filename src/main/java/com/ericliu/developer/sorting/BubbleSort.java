package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class BubbleSort extends Sort {
    @Override
    public int[] sort(int[] array) {

        int temp;
        boolean hasSwapped = false;
        for (int i = 0; i < array.length; i++) {
            hasSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    hasSwapped = true;
                }
            }
            if (!hasSwapped) {
                break;
            }
        }


        return array;
    }


}
