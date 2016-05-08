package com.ericliu.developer.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 8/05/2016.
 */
public class LinkedListTest {

    private LinkedList<String> mLinkedList;

    @Before
    public void setUp() throws Exception {
        mLinkedList = new LinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        mLinkedList = null;
    }


    @Test
    public void testLinkedList(){
        mLinkedList.insert(0, "First");
        mLinkedList.insert(1, "Second");
        mLinkedList.insert(2, "Fourth");
        mLinkedList.insert(2, "Third");

        mLinkedList.print();

        mLinkedList.delete(0);
        mLinkedList.delete(2);
        mLinkedList.print();
    }
}