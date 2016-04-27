package com.ericliu.developer.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 27/04/2016.
 */
public class QueueTest {

    private QueueArrayImplementation mQueueArrayImplementation;

    @Before
    public void setUp() throws Exception {
        mQueueArrayImplementation = new QueueArrayImplementation();
    }

    @After
    public void tearDown() throws Exception {

        mQueueArrayImplementation = null;
    }

    @Test
    public void testDequeue() throws Exception {

        mQueueArrayImplementation.dequeue();

        mQueueArrayImplementation.enqueue("hello");
        mQueueArrayImplementation.printQueue();

        mQueueArrayImplementation.dequeue();
        mQueueArrayImplementation.printQueue();

        mQueueArrayImplementation.dequeue();


    }

    @Test
    public void testEnqueue() throws Exception {
        mQueueArrayImplementation.enqueue("first");
        mQueueArrayImplementation.enqueue("second");
        mQueueArrayImplementation.enqueue("third");
        mQueueArrayImplementation.enqueue("fourth");
        mQueueArrayImplementation.enqueue("fifth");
        mQueueArrayImplementation.printQueue();

        mQueueArrayImplementation.dequeue();

        mQueueArrayImplementation.enqueue("sixth");
        mQueueArrayImplementation.printQueue();

        mQueueArrayImplementation.enqueue("seventh");


    }

    @Test
    public void testFront() throws Exception {

    }
}