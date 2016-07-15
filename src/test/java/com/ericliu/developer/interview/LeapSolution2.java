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
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (count[A[i]] > 0) {
                int tmp = ++count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }


    @Test
    public void testSolution() {

        int result0 = solution(3, new int[]{0, 1, 1, 3, 3, 3});

        assertTrue(result0 == 3);

        int result1 = solution(3, new int[]{0, 1, 1, 3});

        assertTrue(result1 == 1);


        int result2 = solution(3, new int[]{0});

        assertTrue(result2 == 0);


        int result3 = solution(3, new int[]{3});

        assertTrue(result3 == 3);

    }
}
