package com.ericliu.developer.interview;

import org.junit.Test;

/**
 * Created by ericliu on 4/07/2016.
 *
 * # take an array and print non over lapping in order pairs. example:


 # [1,2,3,4] => input

 # output below is in order combination

 # (1234)
 # (1)(234)
 # (1)(23)(4)
 # (1)(2)(34)
 # (12)(34)
 # (12)(3)(4)
 # (123)(4)
 # (1)(2)(3)(4)
 */
public class Iteration {


    public <E> void findCombination(E[] array) {
        int gapNumber = array.length - 1;
        boolean[] gaps = new boolean[gapNumber];

        for (int i = 0; i < Math.pow(2, gapNumber); i++) {
            for (int gapIndex = 0; gapIndex < gaps.length; gapIndex++) {
                //reset value
                gaps[gapIndex] = false;
            }

            for (int gapIndex = 0; gapIndex < gapNumber; gapIndex++) {
                if (getBit(i, gapIndex) > 0) {
                    gaps[gapIndex] = true;
                }
            }

            printCombination(array, gaps);
        }

    }

    private <E> void printCombination(E[] array, boolean[] gaps) {
        System.out.print("(");

        for (int i = 0; i < array.length; i++) {
            if (i < gaps.length && gaps[i] == true) {
                System.out.print(array[i]);
                System.out.print(")(");
            } else {
                System.out.print(array[i]);
            }

        }

        System.out.print(")\n");
    }

    public int getBit(int n, int k) {
        return (n >> k) & 1;
    }


    @Test
    public void testPrintCombination() {
        Integer[] data = {1, 2, 3, 4};
        findCombination(data);
    }

}
