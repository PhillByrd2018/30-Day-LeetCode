package Challenger;
//https://leetcode.com/problems/maximum-sum-circular-subarray/

public class MaxSumCircularArray {

    public static int[] testCase0 = { -1, -2, -3, -2 };
    public static int[] testCase1 = { 1, -2, 3, -2 };
    public static int[] testCase2 = { 5, -3, 5 };
    public static int[] testCase3 = { 3, -1, 2, -1 };

    public static int maxSubarraySumCircular(int[] A) {

        int total_sum = 0;

        int maxValueEndingAt = 0;
        int maxSum = Integer.MIN_VALUE;

        int minValueEndingAt = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : A) {
            total_sum += num;
            maxValueEndingAt = Math.max(maxValueEndingAt + num, num);
            maxSum = Math.max(maxValueEndingAt, maxSum);
            minValueEndingAt = Math.min(minValueEndingAt + num, num);
            minSum = Math.min(minValueEndingAt, minSum);
        }

        if (maxSum > 0) {
            return Math.max(maxSum, total_sum - minSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Expected: -1 :: Actual: " + maxSubarraySumCircular(testCase0));
        System.out.println("Expected: 3 :: Actual: " + maxSubarraySumCircular(testCase1));
        System.out.println("Expected: 10 :: Actual: " + maxSubarraySumCircular(testCase2));
        System.out.println("Expected: 4 :: Actual: " + maxSubarraySumCircular(testCase3));
    }
}