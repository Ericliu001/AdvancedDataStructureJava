package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ericliu on 8/07/2016.
 *
 * input a list of array [[1, 2, 3], [1], [1, 2]] return the list of array, each array is a combination of one element in each array.
 [[1, 1, 1], [1, 1, 2], [2, 1, 1], [2, 1, 2], [3, 1, 1], [3, 1, 2]]
 Followup: each array in the input list is an iterator, which can only be looped once.
 */
public class Recursion1 {





    public List<Integer[]> findCombination(List<Integer[]> arrayList){
        if (arrayList.size() == 1) {
            List<Integer[]> newArray = new ArrayList<>();
            Integer[] array = arrayList.get(0);

            for (Integer integer : array) {
                Integer[] temp = new Integer[]{integer};
                newArray.add(temp);
            }

            return newArray;
        }

        Integer[] current = arrayList.get(0);
        List<Integer[]> newList = new ArrayList<>();
        List<Integer[]> combination = findCombination(arrayList.subList(1, arrayList.size()));

        for (Integer integer : current) {
            for (Integer[] integers : combination) {
                Integer[] temp = new Integer[1 + integers.length];
                temp[0] = integer;
                for (int i = 0; i < integers.length; i++) {
                    temp[i +1] = integers[i];
                }
                newList.add(temp);
            }
        }


        return newList;
    }


    @Test
    public void testFindCombination(){
        List<Integer[]> list = new ArrayList<>();
        Integer[] a1 = {1, 2, 3};
        Integer[] a2 = {4, 5};
        Integer[] a3 = {6,7,8};

        list.add(a1);
        list.add(a2);
        list.add(a3);


        List<Integer[]> combination = findCombination(list);
        printCombination(combination);
        assertNotNull(combination);
    }


    private void printCombination(List<Integer[]> list){
        for (Integer[] integers : list) {
            System.out.print("[");
            for (int i = 0; i < integers.length; i++) {
                System.out.print(integers[i]);
                if (i != integers.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }

    }
}
