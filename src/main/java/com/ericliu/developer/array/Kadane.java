package com.ericliu.developer.array;

/**
 * Created by ericliu on 4/08/2016.
 */

public class Kadane {

    public static class Result {
        public int startIndex;
        public int endIndex;
        public int maxSum;
    }


    public static Result findMaxSumSubArray(int[] dataArray) {
        Result result = new Result();
        int maxSumBeforeIndex = dataArray[0];

        for (int i = 1; i < dataArray.length; i++) {
            if (maxSumBeforeIndex + dataArray[i] > dataArray[i]) {
                maxSumBeforeIndex += dataArray[i];
            } else {
                maxSumBeforeIndex = dataArray[i];
            }

            if (maxSumBeforeIndex > result.maxSum) {
                result.maxSum = maxSumBeforeIndex;
            }
        }

        return result;
    }
}
