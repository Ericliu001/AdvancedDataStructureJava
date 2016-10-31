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

    private char calculateClosest(String colorString) {
        int color = Integer.parseInt(colorString, 16);
        int reminder = color % 17;
        int roundup = reminder > 8 ? 16 - reminder : 0;
        int index = (color + roundup) / 17;
        return digits[index];
    }


    private char calculateClosestBitwise(String colorStr) {
        int color = Integer.parseInt(colorStr, 16);
        if (color > Integer.parseInt("ff", 16) - 8) {
            return 'f';
        }

        char[] results = new char[2];
        int mask = 32 - 1;
        int charPos = 2;

        do {
            results[--charPos] = (char)( color & mask);
            color >>>= 4;
        }while (charPos > 0);

        return digits[results[0] < results[1] ? results[0] : results[1]];
    }




    @Test
    public void testCalculation(){

        String hex1 = "9a9a9a";
        String result1 = shortenRGB(hex1);
        assertEquals("999", result1);

    }


    @Test
    public void testCalculateBitwise(){
        String hex1 = "fa";
        char result1 = calculateClosestBitwise(hex1);
        assertEquals('f', result1);


        String hex2 = "9a";
        char result2 = calculateClosestBitwise(hex2);
        assertEquals('9', result2);
    }
}
