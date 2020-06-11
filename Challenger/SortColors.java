package Challenger;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            // if we see a 0 then we swap it with the current index
            if (nums[current] == 0) {
                swap(nums, left++, current++);
                // if we see a 2 then we swap it with the right index
            } else if (nums[current] == 2) {
                swap(nums, current, right--);
                // if we see a 1 then we just move the current index to the right
            } else if (nums[current] == 1) {
                current++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] testCase1 = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Expected: [0,0,1,1,2,2] :: Actual: ");
        sortColors(testCase1);
        System.out.println(Arrays.toString(testCase1));
    }
}