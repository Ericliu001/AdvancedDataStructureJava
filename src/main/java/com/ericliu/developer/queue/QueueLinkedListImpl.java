package com.ericliu.developer.queue;

/**
 * Created by ericliu on 28/04/2016.
 */
public class QueueLinkedListImpl implements Queue<String> {


    private static class Node {
        String data;
        Node next;
    }

    private Node front, rear;

    @Override
    public void dequeue() {
        if (front == null && rear == null) {
            System.out.println("Empty queue!");
        } else if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
    }

    @Override
    public void enqueue(String s) {
        Node node = new Node();
        node.data = s;
        node.next = null;
        if (front == null && rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    @Override
    public String front() {
        return front.data;
    }

    @Override
    public void printQueue() {
        System.out.print("\n");
        if (front == null && rear == null) {
            System.out.println("Empty queue");
        } else {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
        }
        System.out.print("\n");
    }
}
