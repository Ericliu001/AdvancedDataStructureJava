package com.ericliu.developer.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 19/06/2016.
 */
public class String2 {



    @Test
    public void testOneEdit(){

        String str1 = "this";
        String str2 = "this1";

        assertTrue(isOneEditAway(str1, str1));

        assertTrue(isOneEditAway(str1, str2));
        assertTrue(isOneEditAway(str2, str1));

        str2 = "thisasfas";
        assertFalse(isOneEditAway(str1, str2));
        assertFalse(isOneEditAway(str2, str1));


        str1 = "hello";
        str2 = "1hello";
        assertTrue(isOneEditAway(str1, str2));
        assertTrue(isOneEditAway(str2, str1));
    }


    @Test
    public void testCompress(){
        String source = "abcdddddddd";
        String compressed = compressString(source);

        System.out.println(compressed);
    }





    public boolean isOneEditAway(String str1, String str2){
        if(str1 == null || str2 == null){
            throw new IllegalArgumentException("This is ok");
        }

        int length1 = str1.length();
        int length2 = str2.length();

        if(Math.abs(length1 - length2) > 1){
            return false;
        }

        String shorter = length1 > length2 ? str2 : str1;
        String longer = length1 > length2 ? str1 : str2;
        boolean isEditFound = false;

        for(int i = 0, j = 0; i < length1 && j < length2; i++){
            if(shorter.charAt(i) !=  longer.charAt(j)){
                if(isEditFound){return false;}

                isEditFound = true;
                j++;
            }
            j++;
        }
        return true;

    }




    public String compressString(String source){
        String compressed = "";
        int count = 0;

        for(int i = 0; i < source.length(); i++){
            count ++ ;

            if(i + 1 >= source.length() || source.charAt(i) != source.charAt(i + 1)){

                compressed += "" + source.charAt(i) + count;
                count = 0;
            }

        }

        return source.length() >= compressed.length() ? compressed : source;

    }
}
