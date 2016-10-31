package com.ericliu.developer.interview;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 31/10/16.
 * <p>
 * Dutch national flag. Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
 * <p>
 * void swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
 * int color(i): color of pebble in bucket i.
 * The performance requirements are as follows:
 * <p>
 * At most n calls to color().
 * At most n calls to swap().
 * Constant extra space.
 */
public class DutchNationalFlag {

    private static final int ARRAY_LENGTH = 30;

    private enum Peddle {
        BLUE, WHITE, RED;
    }

    private Peddle[] array = new Peddle[ARRAY_LENGTH];

    @Before
    public void setUp() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = Peddle.values()[random.nextInt(Peddle.values().length)];
        }
    }

    @Test
    public void testSorting() {
        sort(array);


        for (Peddle peddle : array) {
            System.out.print(peddle + " ");
        }
    }


    public static void sort(Peddle[] array) {
        int cursor = 0, bluePivot = 0, redPivot = array.length - 1;

        while (cursor < redPivot ) {
            if (array[cursor] == Peddle.BLUE) {
                swap(array, cursor, bluePivot);
                bluePivot++;
                cursor ++;
            } else if (array[cursor] == Peddle.RED) {
                while (array[redPivot] == Peddle.RED && redPivot > cursor) {
                    redPivot--;
                }
                swap(array, cursor, redPivot);
            } else {
                cursor++;
            }
        }
        System.out.println("cursor: " + cursor + "; bluePivot: " + bluePivot + "; redPivot: " + redPivot);
    }

    private static void swap(Peddle[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        Peddle temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @After
    public void tearDown() {

        array = null;
    }
}
