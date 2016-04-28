package com.ericliu.developer.queue;

/**
 * Created by ericliu on 27/04/2016.
 */
public class QueueArrayImpl implements Queue<String> {


    private static final int size = 5;
    private String[] array = new String[size];
    private int front = -1, rear = -1;

    @Override
    public void dequeue() {
        if (isEmpty()) {
                System.out.println("empty queue");

        } else if (rear == front) {

            rear = front = -1;
        } else {
            front++;
        }


    }

    private boolean isFull() {
        if (rear + 1 - front == size) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        if (rear == -1 || front == -1) {
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
            front = rear = 0;
            array[rear] = s;
        } else {
            rear++;
            int realLast = rear % size;
            array[realLast] = s;
        }
    }

    @Override
    public String front() {
        if (front == -1) {
            System.out.println("empty queue");
            return null;
        }

        return array[front % size];
    }

    @Override
    public void printQueue() {
        if (front == rear && front == -1) {
            return;
        }

        for (int i = 0; i < rear + 1 - front; i++) {
            System.out.print(array[(front + i) % size] + ", ");
        }
        System.out.print("\n");
    }
}
