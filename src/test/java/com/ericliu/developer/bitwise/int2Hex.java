package com.ericliu.developer.bitwise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ericliu on 17/10/16.
 */

public class int2Hex {


    /**
     * All possible chars for representing a hex number as a String
     */
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f'
    };



    private String shortenRGB(String hexStr){
        hexStr = removePrefix(hexStr);

        char[] result = new char[3];
        for (int i = 0; i < 3; i++) {
            int index2 = 2*i + 2;
            int index1 = 2*i;
            char a = calculateClosest(hexStr.substring(index1, index2));
            result[i] = a;
        }
        return String.valueOf(result);
    }

    private String removePrefix(String hexStr) {
        if (hexStr.startsWith("0x")){
            hexStr.substring(2);
        }
        return hexStr;
    }

    private char calculateClosest(String substring) {
        int color = Integer.parseInt(substring, 16);
        int reminder = color % 17;

        int roundup = reminder > 8 ? 16 - reminder : 0;

        int index = (color + roundup) / 17;

        return digits[index];
    }




    @Test
    public void testCalculation(){

        String hex1 = "9a9a9a";
        String result1 = shortenRGB(hex1);
        assertEquals("999", result1);

    }
}
