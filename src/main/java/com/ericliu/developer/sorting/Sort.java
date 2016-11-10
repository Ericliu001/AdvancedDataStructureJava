package com.ericliu.developer.sorting;

/**
 * Created by ericliu on 4/05/2016.
 */
public abstract class Sort{

   public abstract int[] sort(int[] array);

    public static void print(int[] array) {
        System.out.print("\n");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
}
