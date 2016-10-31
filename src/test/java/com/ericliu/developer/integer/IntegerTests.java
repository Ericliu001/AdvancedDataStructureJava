package com.ericliu.developer.integer;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ericliu on 4/10/16.
 */

public class IntegerTests {

    @Test
    public void testConvert2Octal(){

        String octalString = Integer.toOctalString(1000);

        assertNotNull("The octal string is null", octalString);

    }

    @Test
    public void testConvertTernary(){

        String ternary = Integer.toString(10, 3);

        assertNotNull("The ternary string is null", ternary);

        int i = Float.floatToIntBits(21.28f);
        String s = Integer.toBinaryString(i);
        assertNotNull("The ternary string is null", s);
    }
}
