package Challenger;

import java.util.HashMap;


public class SumSubarray {

    public static int[] testCase1 = { 1, 1, 1 };
    public static int[] testCase2 = { 1, 2, 3 };
    public static int[] testCase3 = { 28, 54, 7, -70, 22, 65, -6 };
    public static int[] testCase4 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    public static int sumWithNoSpace(int[] slice, int target) {
        int count = 0;

        for (int start = 0; start < slice.length; start++) {
            int sum = 0;
            for (int end = start; end < slice.length; end++) {
                sum += slice[end];
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int sumWithMap(int[] slice, int target) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < slice.length; i++) {
            sum += slice[i];
            if (map.containsKey(sum - target))
                count += map.get(sum - target);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static void main(String[] args) {
        // System.out.println("Expected: 2 :: Actual: " + subarraySumBruteForce(testCase1, 2));
        // System.out.println("Expected: 2 :: Actual: " + subarraySumBruteForce(testCase2, 3));
        // System.out.println("Expected: 1 :: Actual: " + subarraySumBruteForce(testCase3, 100));
        // System.out.println("Expected: 55 :: Actual: " + subarraySumBruteForce(testCase4, 0));
        // System.out.println("==============================================================");
        // System.out.println("Expected: 2 :: Actual: " + sumWithNoSpace(testCase1, 2));
        // System.out.println("Expected: 2 :: Actual: " + sumWithNoSpace(testCase2, 3));
        // System.out.println("Expected: 1 :: Actual: " + sumWithNoSpace(testCase3, 100));
        // System.out.println("Expected: 55 :: Actual: " + sumWithNoSpace(testCase4, 0));
        // System.out.println("==============================================================");
        System.out.println("Expected: 2 :: Actual: " + sumWithMap(testCase1, 2));
        System.out.println("Expected: 2 :: Actual: " + sumWithMap(testCase2, 3));
        System.out.println("Expected: 1 :: Actual: " + sumWithMap(testCase3, 100));
        System.out.println("Expected: 55 :: Actual: " + sumWithMap(testCase4, 0));
        System.out.println("==============================================================");
    }
}