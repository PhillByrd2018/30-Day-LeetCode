package Challenger;

import java.util.Arrays;

public class ShorestSubArray {

    // NOT WORKING!!!!!!
    public static int findUnsortedSubarray(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        boolean frontCorrect = true;
        boolean totallySorted = true;
        while (frontCorrect && left < nums.length - 1) {
            if (nums[left] <= nums[left + 1]) {
                left++;
            } else {
                frontCorrect = false;
                totallySorted = false;
            }

        }

        int right = nums.length - 1;
        boolean backCorrect = true;
        while (backCorrect && right > 1) {
            if (nums[right] >= nums[right - 1]) {
                right--;
            } else {
                backCorrect = false;
                totallySorted = false;
            }
        }
        int ans;
        if (totallySorted) {
            ans = 0;
        } else {
            ans = right - left + 1;
        }

        return ans;
    }

    public static int cheatinWayToDoIt(int[] nums) {

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int start = nums.length;
        int end = 0;
        boolean totallySorted = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
                totallySorted = false;
            }
        }
        int ans;
        if (!totallySorted) {
            ans = end - start + 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] testCase1 = { 2, 6, 4, 8, 10, 9, 15 };
        // System.out.println("Expected: 5 :: Actual: " +
        // findUnsortedSubarray(testCase1));

        int[] testCase5 = { 1, 3, 2, 2, 2 };
        System.out.println("Expected: 4 :: Actual: " + cheatinWayToDoIt(testCase5));

        int[] testCase4 = { 1, 2, 3, 3, 3 };
        System.out.println("Expected: 0 :: Actual: " + cheatinWayToDoIt(testCase4));

        int[] testCase3 = { 1 };
        System.out.println("Expected: 0 :: Actual: " + cheatinWayToDoIt(testCase3));

        int[] testCase2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Expected: 0 :: Actual: " + cheatinWayToDoIt(testCase2));
    }
}