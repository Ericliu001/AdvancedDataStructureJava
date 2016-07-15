package com.ericliu.developer.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 15/07/2016.
 */
public class LeapTask3 {

    private static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }


    public int solution(Tree T) {
        // write your code in Java SE 8
        Map<Tree, Tree> paths = findPath(T);
        int result = findAmplitude(paths);

        return result;
    }

    private int findAmplitude(Map<Tree, Tree> paths) {

        int maximum = 0;

        for (Tree tree : paths.keySet()) {
            if (tree.l == null && tree.r == null) {
                // tree is a leaf node


                Tree current = tree;
                List<Integer>  amplitudes = new ArrayList<>();
                amplitudes.add(current.x);
                while (paths.containsKey(current)) {
                    Tree next = paths.get(current);
                    amplitudes.add(next.x);
                    current = next;
                }

                Collections.sort(amplitudes);
                int temp = Math.abs(amplitudes.get(0) - amplitudes.get(amplitudes.size() -1));
                if (temp > maximum) {
                    maximum = temp;
                }
            }
        }




        return maximum;
    }


    public Map<Tree, Tree> findPath(Tree root) {
        if (root == null) {
            return null;
        }

        Map<Tree, Tree> paths = new HashMap<>();


        Stack<Tree> stack = new Stack<>();
        Tree current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.pop();

            if (current.l != null) {
                stack.push(current.l);
                paths.put(current.l, current);
            }

            if (current.r != null) {
                stack.push(current.r);
                paths.put(current.r, current);
            }


        }
        return paths;

    }



    @Test
    public void testFindAmplitude(){

        Tree root = new Tree();
        root.x = 5;


        Tree node1 = new Tree();
        node1.x = 8;

        Tree node2 = new Tree();
        node2.x = 9;


        root.l = node1;
        root.r = node2;


        Tree node3 = new Tree();
        node3.x = 12;
        node1.l = node3;

        int result = solution(root);

        assertTrue(result > 0);
    }
}
