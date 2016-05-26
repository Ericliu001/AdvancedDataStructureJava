package com.ericliu.developer.pracises;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 26/05/2016.
 */
public class SortingPractiseTest {
    Integer[] mArray;

    @Before
    public void setUp() throws Exception {
        mArray = new Integer[]{1, 3, 10, 5, 6, 4, 8, 9, 2, 7};
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testSort() throws Exception {
        SortingPractise.sort(mArray);
        print(mArray);
    }





    public static void print(Object[] array) {
        System.out.print("\n");
        for (Object i : array) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
}