package com.ericliu.developer.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ericliu on 7/05/2016.
 */
public class ArrayListTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testOperations(){

        ArrayList<String> arrayList = new ArrayList<>(2);

        arrayList.add("one");
        arrayList.add("four");
        arrayList.add("five");

        arrayList.add(1, "two");
        arrayList.add(2, "three");


        assertEquals("one", arrayList.get(0));
        System.out.println(arrayList);

        arrayList.remove(2);
        System.out.println(arrayList);
    }
}