package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class SelectionSort extends Sort {


    @Override
    public int[] sort(int[] array) {
        int minIndex, temp = 0;
        for (int i = 0; i < array.length -1 ; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }


        }



        return array;
    }


}
