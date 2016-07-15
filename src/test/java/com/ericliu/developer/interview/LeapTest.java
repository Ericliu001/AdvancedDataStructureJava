package com.ericliu.developer.interview;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 15/07/2016.
 */
public class LeapTest {


    public int solutionTask1(int[] A) {
        // write your code in Java SE 8


        int i = 0;
        int count = 0;

        while (i != -1) {
            int index = A[i];
            count++;
            i = A[index];
            count++;
            if (i < 0) {
                break;
            }
        }


        return count;
    }


    @Test
    public void testTask1() {
        int[] src = {1, 4, -1, 3, 2};
        int length = solutionTask1(src);

        assertTrue(length == 4);


        int[] src2 = {3, 4, 5, 1, 2, -1};

        int length2 = solutionTask1(src2);

        assertTrue(length2 == 6);
    }



}
