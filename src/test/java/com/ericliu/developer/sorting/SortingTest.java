package com.ericliu.developer.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 4/05/2016.
 */
public class SortingTest {
    int[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new int[]{4, 2, 6, 56, 57, 34, 2, 4, 0, 8, 2, 5};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testSelectionSort() throws Exception {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(mArray);
        selectionSort.print(mArray);
    }

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(mArray);
        bubbleSort.print(mArray);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(mArray);
        insertionSort.print(mArray);
    }


}