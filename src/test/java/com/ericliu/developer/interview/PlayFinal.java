package com.ericliu.developer.interview;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by ericliu on 23/11/16.
 */

public class PlayFinal {


    @Test
    public void testFinal(){
        int num = getNum();
        assertTrue(num == 0);
    }


    private int getNum(){
        int i = 0;
        try{
            return i++;
        }finally {
            i += 2;
        }
    }
}
