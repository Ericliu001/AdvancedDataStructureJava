package com.ericliu.developer.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 24/05/2016.
 */
public class SortingTest {

    private Integer[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new Integer[]{6, 2, 1, 9, 5, 7, 4, 8};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testMergeSort(){
        Sorting.legacyMergeSort(mArray);

    }
}