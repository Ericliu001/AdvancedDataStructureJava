package com.ericliu.developer.interview;

import com.ericliu.developer.list.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 9/05/2016.
 * <p/>
 * Interview Question
 *
 * @see <a href="algorithmsandme">http://algorithmsandme.in/2013/10/linked-list-add-two-numbers-represented-by-linked-lists/</a>
 * <p/>
 * <p/>
 * <p/>
 * 43
 * Given two linked list, each node contains one digit number, we need to add these two linked list. Result should be stored in third linked list. It should be noted that the head node contains the most significant digit of the number.
 */
public class LinkedList1 {

    private LinkedList<Integer> list1;
    private LinkedList<Integer> list2;


    @Before
    public void setUp() throws Exception {
        list1 = new LinkedList<>();
        list1.insert(0, 2);
        list1.insert(1, 5);
        list1.insert(2, 8);
        list1.insert(3, 4);
        list1.insert(4, 3);

        list2 = new LinkedList<>();
        list2.insert(0, 2);
        list2.insert(1, 3);
        list2.insert(2, 1);
        list2.insert(3, 7);
        list2.insert(4, 6);
        list2.insert(5, 5);
        list2.insert(6, 2);
    }

    @After
    public void tearDown() throws Exception {
        list1 = null;
        list2 = null;
    }


    @Test
    public void testAddingNumbers() {
        list1.reverse();
        list2.reverse();


        LinkedList<Integer> resultList = new LinkedList<>();

        LinkedList.Node<Integer> pointer1 = list1.head;
        LinkedList.Node<Integer> pointer2 = list2.head;
        LinkedList.Node<Integer> resultPointer = resultList.head;


        int sum = 0;
        boolean carrying = false;
        while (pointer1 != null && pointer2 != null) {
            sum = pointer1.data + pointer2.data;
            sum += carrying ? 1 : 0;
            carrying = false; // remember to turn off the carrying

            if (sum >= 10) {
                carrying = true;
                sum = sum % 10;
            }


            LinkedList.Node<Integer> resultNode = new LinkedList.Node<>();
            resultNode.data = sum;
            if (resultPointer == null) {
                resultList.head = resultNode; // remember to set the Head of the linkedList
                resultPointer = resultNode;
            } else {
                resultPointer.next = resultNode;
                resultPointer = resultPointer.next;
            }

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        while (pointer1 != null) {
            LinkedList.Node<Integer> resultNode = new LinkedList.Node<>();
            resultNode.data = pointer1.data;
            resultPointer.next = resultNode;
            resultPointer = resultPointer.next;
            pointer1 = pointer1.next;
        }

        while (pointer2 != null) {
            LinkedList.Node<Integer> resultNode = new LinkedList.Node<>();
            resultNode.data = pointer2.data;
            resultPointer.next = resultNode;
            resultPointer = resultPointer.next;
            pointer2 = pointer2.next;
        }

        if (resultList != null) {
            resultList.reverse();
            resultList.print();
        }

    }

}
