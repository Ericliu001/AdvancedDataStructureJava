package com.ericliu.developer.queue;

/**
 * Created by ericliu on 27/04/2016.
 */
public interface Queue<T> {

    void dequeue();
    void enqueue(T t);
    T front();

    void printQueue();
}
