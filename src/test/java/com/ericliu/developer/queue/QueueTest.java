package com.ericliu.developer.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 27/04/2016.
 */
public class QueueTest {

    private Queue mQueue;

    @Before
    public void setUp() throws Exception {
        mQueue = new QueueLinkedListImpl();
    }

    @After
    public void tearDown() throws Exception {

        mQueue = null;
    }

    @Test
    public void testDequeue() throws Exception {

        mQueue.dequeue();

        mQueue.enqueue("hello");
        mQueue.printQueue();

        mQueue.dequeue();
        mQueue.printQueue();

        mQueue.dequeue();


    }

    @Test
    public void testEnqueue() throws Exception {
        mQueue.enqueue("first");
        mQueue.enqueue("second");
        mQueue.enqueue("third");
        mQueue.enqueue("fourth");
        mQueue.enqueue("fifth");
        mQueue.printQueue();

        mQueue.dequeue();

        mQueue.enqueue("sixth");
        mQueue.printQueue();

        mQueue.enqueue("seventh");
        mQueue.printQueue();

    }

    @Test
    public void testFront() throws Exception {

    }
}