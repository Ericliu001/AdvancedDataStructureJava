package com.ericliu.developer.binarysearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 13/07/2016.
 */
public class BinarySearchTest {

    int[] data = {1,2,3,4,6,6,6,6,6,7,8,9};

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBinarySearch() throws Exception {
        int result = BinarySearch.binarySearch(data, 0, data.length, 5);
        assertTrue(result < 0);

        int result1 = BinarySearch.binarySearch(data, 0, data.length, 4);
        assertTrue(result1 == 3);
    }

    @Test
    public void testBinarySearchFirst() throws Exception {
        int result = BinarySearch.binarySearchFirst(data, 0, data.length, 6);
        assertTrue(result == 4);
    }

    @Test
    public void testBinarySearchLast() throws Exception {
        int result = BinarySearch.binarySearchLast(data, 0, data.length, 6);
        assertTrue(result == 8);
    }

    @Test
    public void testBinarySearchLowerBound() throws Exception {
        int result = BinarySearch.binarySearchLowerBound(data, 0, data.length, 5);
        assertTrue(result == 3);
    }

    @Test
    public void testBinarySearchUpperBound() throws Exception {
        int result = BinarySearch.binarySearchUpperBound(data, 0, data.length, 5);
        assertTrue(result == 4);
    }
}