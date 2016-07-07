package com.ericliu.developer.interview;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 7/07/2016.
 * <p/>
 * You are given a matrix with N rows and N columns. Elements in matrix can be either 1 or 0. Each row and column of matrix is sorted in ascending order.
 * Find number of 0-s in the given matrix.
 * Example:
 * <p/>
 * <p/>
 * 0 0 1
 * 0 1 1
 * 1 1 1
 * Answer: 3
 * <p/>
 * 0 0
 * 0 0
 * Answer: 4
 */
public class Matrix1 {


    private int findZeroCount(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }

        int sumZeros = 0;
        int indexOfLastZero = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            indexOfLastZero = findIndexOfLastZero(matrix[i], 0, indexOfLastZero);
            if (indexOfLastZero >= 0) {
                sumZeros += (indexOfLastZero + 1);
            }
        }

        return sumZeros;
    }


    private int findIndexOfLastZero(int[] array, int left, int right) {
        int mid = 0;
        while (right - left > 1) {
            mid = (left + right) / 2;
            if (array[mid] == 0) {
                left = mid;
            } else {
                right = mid;
            }
        }


        if (array[right] == 0) {
            return right;
        } else if (array[left] == 0) {
            return left;
        } else {
            return -1;
        }

    }


    @Test
    public void testCountZeros() {
        int[][] data = new int[][]{
                {0, 0, 1},
                {0, 1, 1},
                {1, 1, 1}
        };

        int zeroCount = findZeroCount(data);
        assertTrue(zeroCount == 3);
    }
}
