package com.ericliu.developer.queue;

/**
 * Created by ericliu on 27/04/2016.
 */
public class QueueArrayImplementation implements Queue<String> {


    private static final int size = 5;
    private String[] array = new String[size];
    private int first = -1, last = -1;

    @Override
    public void dequeue() {
        if (isEmpty()) {
                System.out.println("empty queue");

        } else if (last == first) {

            last = first = -1;
        } else {
            first++;
        }


    }

    private boolean isFull() {
        if (last + 1 - first == size) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        if (last == -1 || first == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void enqueue(String s) {

        if (isFull()) {
            System.out.println("full queue");
        } else if (isEmpty()) {
            first = last = 0;
            array[last] = s;
        } else {
            last++;
            int realLast = last % size;
            array[realLast] = s;
        }
    }

    @Override
    public String front() {
        if (first == -1) {
            System.out.println("empty queue");
            return null;
        }

        return array[first % size];
    }

    @Override
    public void printQueue() {
        if (first == last && first == -1) {
            return;
        }

        for (int i = 0; i < last + 1 - first; i++) {
            System.out.print(array[(first + i) % size] + ", ");
        }
        System.out.print("\n");
    }
}
