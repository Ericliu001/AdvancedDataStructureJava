package com.ericliu.developer.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ericliu on 4/08/2016.
 */
public class KadaneTest {
    private int[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new int[]{2, 3, -2, -1, 10};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void findMaxSumSubArray() throws Exception {
        Kadane.Result result = Kadane.findMaxSumSubArray(mArray);

        assertEquals(result.maxSum, 12);

        mArray = new int[]{1, -3, 2, 1, -1};

        Kadane.Result result1 = Kadane.findMaxSumSubArray(mArray);

        assertEquals(result1.maxSum, 3);

        mArray = new int[]{-3};

        Kadane.Result result2 = Kadane.findMaxSumSubArray(mArray);

        assertEquals(-3, result2.maxSum);
        assertEquals(result2.startIndex, 0);
        assertEquals(result2.endIndex, 0);

        mArray = new int[]{2, -3};
        Kadane.Result result3 = Kadane.findMaxSumSubArray(mArray);

        assertEquals(2, result3.maxSum);
        assertEquals(0, result3.startIndex);
        assertEquals(0, result3.endIndex);
    }

}