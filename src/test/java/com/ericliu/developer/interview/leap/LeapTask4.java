package com.ericliu.developer.interview.leap;

import java.util.Arrays;

/**
 * Created by ericliu on 15/07/2016.
 */
public class LeapTask4 {


    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null || A.length < 2) {
            return -2;
        }

        Arrays.sort(A);
        int[] differences = new int[A.length - 1];

        for (int i = 0; i + 1 < A.length; i++) {
            differences[i] = Math.abs(A[i] - A[i + 1]);
        }

        Arrays.sort(differences);

        int maximumDistance = differences[0];

        if (maximumDistance > 100000000) {
            return -1;
        }

        return maximumDistance;
    }
}
