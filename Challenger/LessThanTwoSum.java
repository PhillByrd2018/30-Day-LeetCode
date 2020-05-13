package Challenger;

import java.util.Arrays;

public class LessThanTwoSum {

    public static int twoSumLessThanK(int[] A, int K) {

        Arrays.sort(A);

        int i = 0;
        int j = A.length-1;
        int ans = -1;

        while (i < j) {
            int sum = A[i] + A[j];

            if (sum < K) {
                ans = Math.max(ans, sum);
                i++;
            } else {
                j--;
            }
        }
        return ans = ans != -1 ? ans : -1;
    }

    public static void main(String[] args) {
        int[] testCase1 = { 34, 23, 1, 24, 75, 33, 54, 8 };
        System.out.println("Expected: 1,2 :: Actual: " + twoSumLessThanK(testCase1, 60));
    }
}