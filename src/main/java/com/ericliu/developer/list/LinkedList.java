package com.ericliu.developer.list;

import java.util.Stack;

/**
 * Created by ericliu on 8/05/2016.
 */
public class LinkedList<E> {

    public Node<E> head;
    private int size;

    public static class Node<E> {
        public E data;
        public Node<E> next;
    }


    public void insertAtHead(E element) {
        Node<E> node = new Node<>();
        node.data = element;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }


    public void deleteAtHead() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }


    public E get(int index) {
        checkIndex(index, size);

        Node<E> pointer = head;

        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }

        return pointer.data;
    }

    private void checkIndex(int index, int n) {
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("invalid index: " + index + ", the size is: " + size);
        }
    }

    public void insert(int index, E element) {
        checkIndex(index, size + 1);  // notice it is size + 1 here, as we can insert after the last element
        if (index == 0) {
            insertAtHead(element);
            return;
        }

        Node<E> current = head, next = head;
        int i = 0;
        while (i < index) {
            current = next;
            next = next.next;
            i++;
        }

        Node<E> temp = new Node<>();
        temp.data = element;
        temp.next = next;
        current.next = temp;
        size++;
    }


    public void delete(int index) {
        checkIndex(index, size);
        if (index == 0) {
            deleteAtHead();
            return; // DO NOT miss the return statement!
        }

        Node<E> current = head;
        int i = 0;
        while (i < index - 1) { // notice it is minus one
            current = current.next;
            i++;
        }
        current.next = current.next.next;
        size--;
    }


    public void reverse() {
        Node<E> prev = null, current = head, next = head;

        while (next != null) {
            current = next;
            next = next.next;

            current.next = prev;
            prev = current;
        }

        head = prev; // dont forget this step
    }

    public void reverseRecursive() {

        reverseRecursive(head);
    }

    private void reverseRecursive(Node<E> pointer) {
        if (pointer.next == null) {
            head = pointer;
            return;
        } else {

            reverseRecursive(pointer.next);
            pointer.next.next = pointer;
            pointer.next = null;
        }

    }


    public void reverse(int startIndex, int number) {
        checkIndex(startIndex, size);
        checkIndex(startIndex + number, size);

        Stack<Node<E>> stack = new Stack<>();

        Node<E> start = head, current = head, end = head, temp = null;
        int i = 0;
        while (i < startIndex) {
            start = current;
            current = current.next;
            i++;
        }

        for (int j = 0; j < number; j++) {
            stack.push(current);
            current = current.next;
        }

        end = current;

        start.next = stack.peek();
        while (stack.size() > 0) {
            temp = stack.pop();
            if (!stack.isEmpty()) {
                temp.next = stack.peek();
            }
        }
        if (temp != null) {
            temp.next = end;
        }

    }


    public void print() {
        System.out.print("\n LinkedList: ");
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.print("\n");
    }


    public static <E> void print(Node<E> head){
        System.out.print("\n LinkedList: ");
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.print("\n");
    }

}
