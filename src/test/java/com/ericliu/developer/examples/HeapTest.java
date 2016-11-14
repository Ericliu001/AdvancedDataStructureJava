package com.ericliu.developer.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ericliu on 14/11/16.
 */
public class HeapTest {

    private int[] mArray = new int[30];
    @Before
    public void setUp() throws Exception {
        Random random = new Random();
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = random.nextInt(100);
        }
    }

    @After
    public void tearDown() throws Exception {
        mArray = null;
    }

    @Test
    public void testHeap() throws Exception {
        Heap<Integer> heap = new Heap<>();

        System.out.println(" Heap offer: ");
        for (int i = 0; i < mArray.length; i++) {
            heap.offer(mArray[i]);
            System.out.print(mArray[i] + ", ");
        }

        System.out.println("\nHeap poll: ");
        for (int i = 0; i < mArray.length; i++) {
            int num = heap.poll();
            System.out.print(num + ", ");
        }
    }


}