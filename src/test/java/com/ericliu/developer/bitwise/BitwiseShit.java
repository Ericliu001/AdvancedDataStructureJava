package com.ericliu.developer.bitwise;

import org.junit.Test;

/**
 * Created by ericliu on 18/11/16.
 */

public class BitwiseShit {

    @Test
    public void testShift(){
        int i = 4;
        int a = i >>> 1;
        System.out.printf("a: " + Integer.toBinaryString(a) + ", i: " + Integer.toBinaryString(i));
    }
}
