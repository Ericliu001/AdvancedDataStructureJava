package com.ericliu.developer.interview;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ericliu on 15/07/2016.
 */
public class LeapSolution2 {
    int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = -1;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] > 0) {
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp + 1;
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }



    @Test
    public void testSolution(){

        int result = solution(3, new int[]{1, 2, 3, 3, 1, 3, 1});

        assertTrue(result == 1 || result == 3);

    }
}
