package com.ericliu.developer.heap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 13/07/2016.
 */
public class HeapSortTest {

    private IntegerMaxHeap mMaxHeap;


    @Before
    public void setUp() throws Exception {
        mMaxHeap = new IntegerMaxHeap();
    }

    @After
    public void tearDown() throws Exception {
        mMaxHeap = null;
    }

    @Test
    public void testHeapSort() throws Exception {
        int[] srcArray = {3, 5, 8, 2, 6, 7, 4};
        HeapSort.heapSort(srcArray);
        System.out.print("\n");
        for (int i : srcArray) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");

    }
}