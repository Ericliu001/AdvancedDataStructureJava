package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public class SelectionSort implements Sort {


    @Override
    public int[] sort(int[] array) {
        int minIndex = 0;
        for (int i = 0; i < array.length -1 ; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }


        }



        return array;
    }

    @Override
    public void print(int[] array) {
        System.out.print("\n");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
}
