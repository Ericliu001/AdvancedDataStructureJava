package com.ericliu.developer.interview;

import com.ericliu.developer.list.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ericliu on 10/05/2016.
 *
 * @see <a href="">http://algorithmsandme.in/2013/10/merge-two-sorted-linked-lists-in-one-list/</a>
 * <p/>
 * Given two sorted singly linked list, we need to merge these two sorted linked lists into one without creating any additional node
 */
public class LinkedList2 {

    private LinkedList<Integer> list1;
    private LinkedList<Integer> list2;

    @Before
    public void setUp() {
        list1 = new LinkedList<>();
        list1.insert(0, 0);
        list1.insert(1, 3);
        list1.insert(2, 8);
        list1.insert(3, 10);
        list1.insert(4, 11);
        list1.insert(5, 12);
        list1.insert(6, 21);
        list1.insert(7, 33);

        list2 = new LinkedList<>();
        list2.insert(0, 1);
        list2.insert(1, 1);
        list2.insert(2, 2);
        list2.insert(3, 6);
        list2.insert(4, 11);
    }

    @After
    public void tearDown() {
        list1 = null;
        list2 = null;
    }

    @Test
    public void testMerge() {
        LinkedList.Node<Integer>  merged = mergeLists(list1.head, list2.head);

        LinkedList.print(merged);
    }

    private LinkedList.Node<Integer> mergeLists(LinkedList.Node<Integer> left, LinkedList.Node<Integer> right) {
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        LinkedList.Node<Integer> resultHead = null, resultPointer = null, temp1 = null, temp2 = null;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                if (resultPointer == null) {
                    resultPointer = left;
                } else {
                    resultPointer.next = left;
                    resultPointer = resultPointer.next;
                }
                left = left.next;
            } else {
                if (resultPointer == null) {
                    resultPointer = right;
                } else {
                    resultPointer.next = right;
                    resultPointer = resultPointer.next;
                }
                right = right.next;
            }

            if (resultHead == null) {
                resultHead = resultPointer;
            }

        }

        while (left != null) {
            resultPointer.next = left;
            resultPointer = resultPointer.next;
            left = left.next;
        }

        while (right != null) {
            resultPointer.next = right;
            resultPointer = resultPointer.next;
            right = right.next;
        }

        resultPointer.next = null;
        return resultHead;
    }
}
