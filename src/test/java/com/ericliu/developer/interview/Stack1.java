package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by ericliu on 1/11/16.
 * <p>
 * <p>
 * Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.
 */

public class Stack1 {

    public static class MyQueue<E> {
        private Stack<E> oldStack = new Stack<E>();
        private Stack<E> newStack = new Stack<E>();

        private void shiftStacks() {
            if (oldStack.isEmpty()) {
                while (!newStack.isEmpty()) {
                    oldStack.push(newStack.pop());
                }
            }
        }

        public E peek() {
            shiftStacks();
            return oldStack.peek();
        }


        public E dequeue() {
            shiftStacks();
            return oldStack.pop();
        }


        public void enqueue(E e) {
            newStack.push(e);
        }
    }

    @Test
    public void testMyQueue() {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        for (int i = 0; i < 3; i++) {
            System.out.print(queue.dequeue() + ", ");
        }

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        for (int i = 0; i < 3; i++) {
            System.out.print(queue.dequeue() + ", ");
        }

    }


}
