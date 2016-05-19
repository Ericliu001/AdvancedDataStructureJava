package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by ericliu on 19/05/2016.
 */
public class LinkedList3 {

    private static class Node<E> {
        public E data;
        public Node<E> next;
    }


    private static class Context {

        private State mState = StateEnum.TRAVERSING;
        public Node head = null, current = null, prev = null;
        public int currentIndex = 0;


        public State getState() {
            return mState;
        }

        public void setState(State state) {
            mState = state;
        }
    }


    private interface State {
        boolean process(Context context);
    }

    private void process(Context context) {
        while (context.getState().process(context)) ;
    }


    private enum StateEnum implements State {
        TRAVERSING {
            @Override
            public boolean process(Context context) {
                if (context.currentIndex == 0) {
                    context.current = context.head;
                    context.prev = context.head;
                }

                if (context.currentIndex % 6 == 0) {
                    context.setState(REVERSING);
                    return true;
                } else if (context.current == null) {
                    return false;
                } else {
                    context.prev = context.current;
                    context.current = context.current.next;
                    context.currentIndex++;
                    return true;
                }
            }

        }, REVERSING {
            @Override
            public boolean process(Context context) {
                if (context.current == null) {
                    return false;
                }


                Node start = context.prev;
                Node current = context.current;
                Node end = null;

                Stack<Node> stack = new Stack();
                boolean fromHead = false;

                if (context.currentIndex == 0) {
                    fromHead = true;
                }


                for (int i = 0; i < 3 && current != null; i++) {
                    stack.push(current);
                    current = current.next;
                    if (i != 0) {
                        context.currentIndex++;
                    }
                }

                end = current;

                if (fromHead) {
                    context.head = stack.peek();
                    fromHead = false;
                } else {
                    start.next = stack.peek();
                }

                Node temp = null;
                while (stack.size() > 0) {
                    temp = stack.pop();
                    if (!stack.isEmpty()) {
                        temp.next = stack.peek();
                    }
                }
                if (temp != null) {
                    temp.next = end;
                }

                if (end == null) {
                    return false;
                }

                context.setState(TRAVERSING);
                return true;
            }
        };

    }


    @Test
    public void testReverseLinkedList() {
        Context context = new Context();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node node = context.head, pointer = null;
        for (int i = 0; i < array.length; i++) {
            node = new Node();
            node.data = array[i];
            node.next = null;
            if (i == 0) {
                context.head = node;
                pointer = context.head;
            } else {
                pointer.next = node;
                pointer = pointer.next;
            }

        }


        print(context.head);

        process(context);

        print(context.head);


    }

    public static <E> void print(Node<E> head) {
        System.out.print("\n LinkedList: ");
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.print("\n");
    }
}
