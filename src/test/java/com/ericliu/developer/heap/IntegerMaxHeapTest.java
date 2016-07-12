package com.ericliu.developer.heap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 12/07/2016.
 */
public class IntegerMaxHeapTest {

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
    public void testAdd() throws Exception {
        mMaxHeap.add(3);
        mMaxHeap.add(5);
        mMaxHeap.add(8);
        mMaxHeap.add(2);
        mMaxHeap.add(6);
        mMaxHeap.add(7);
        mMaxHeap.add(4);


        assertTrue(mMaxHeap.poll() == 8);
        assertTrue(mMaxHeap.poll() == 7);
        assertTrue(mMaxHeap.poll() == 6);
        assertTrue(mMaxHeap.poll() == 5);
        assertTrue(mMaxHeap.poll() == 4);
        assertTrue(mMaxHeap.poll() == 3);
        assertTrue(mMaxHeap.poll() == 2);
    }

    @Test
    public void testPoll() throws Exception {

    }
}