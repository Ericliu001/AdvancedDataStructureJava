package com.ericliu.developer.list;

/**
 * Created by ericliu on 7/05/2016.
 */
public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 12;
    private int capacity = 12;
    private int size = 0;
    private E[] data;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
       add(size, e);
    }

    public void remove(int index) {
        checkIndex(index, size);
        for (int i = index; i < size - 1 ; i++) { // notice it is size -1 here, NOT size
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // last element can be garbage collected
        size -- ;
    }

    public E get(int index) {
        checkIndex(index, size);
        return data[index];
    }


    public void add(int index, E element) {
        checkIndex(index, size + 1); // notice here is size + 1
        if (size == capacity) {
            resize(capacity*2);
        }
        for (int i = size; i > index; i--) { // notice it starts from size, NOT size - 1
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    private void checkIndex(int index, int n) {
        if (index >= n || index < 0) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }


    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + data[i] + ", ";
        }

        return str;
    }

    private void resize(int capacity){
        this.capacity = capacity;
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
