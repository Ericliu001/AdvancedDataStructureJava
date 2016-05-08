package com.ericliu.developer.list;

/**
 * Created by ericliu on 8/05/2016.
 */
public class LinkedList<E> {

    private Node<E> head;
    private int size;

    public static class Node<E>{
        public E data;
        public Node<E> next;
    }


    public void insertAtHead(E element){
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


    public void deleteAtHead(){
        if (head == null) {
            return;
        }
        head = head.next;
        size --;
    }


    public E get(int index) {
        checkIndex(index, size);
        return null;
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
            i ++;
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
        size --;
    }




    public void print(){
        System.out.print("\n LinkedList: ");
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data +  ", ");
            current = current.next;
        }
        System.out.print("\n");
    }

}
