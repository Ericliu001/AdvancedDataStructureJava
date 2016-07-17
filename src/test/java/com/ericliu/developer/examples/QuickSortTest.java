package com.ericliu.developer.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 17/07/2016.
 */
public class QuickSortTest {

    private int[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new int[]{6, 2, 1, 5, 6, 9, 3, 7, 4, 8};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testQuickSort() throws Exception {
        QuickSort.quickSort(mArray, 0, mArray.length - 1);
        printArray(mArray);
    }


    private void printArray(int[] srcArray) {
        System.out.print("\n");
        for (int i : srcArray) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
}