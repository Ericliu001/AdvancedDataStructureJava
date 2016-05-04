package com.ericliu.developer.sorting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ericliu on 4/05/2016.
 */
public class SortingTest {
    int[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new int[]{1, 3, 10, 5, 6, 4, 8, 9, 2, 7};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testSelectionSort() throws Exception {
        System.out.println("Selection sort: ");

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(mArray);
        selectionSort.print(mArray);
    }

    @Test
    public void testBubbleSort() {
        System.out.println("Bubble sort: ");

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(mArray);
        bubbleSort.print(mArray);
    }

    @Test
    public void testInsertionSort() {
        System.out.println("Insertion sort: ");

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(mArray);
        insertionSort.print(mArray);
    }



    @Test
    public void testMergeArrays() {
        int[] left = new int[]{2, 3, 5};
        int[] right = new int[]{1, 4, 5};
        int[] merged = new int[6];

        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(left, right, merged);

        int[] result = new int[]{1,2,3,4,5,5};
        for (int i = 0; i < merged.length; i++) {
            assertEquals("The merge result is wrong!", merged[i], result[i]);
        }
    }


    @Test
    public void testMergeSort(){
        System.out.println("Merge sort: ");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mArray);
        mergeSort.print(mArray);

    }


}