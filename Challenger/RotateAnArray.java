package Challenger;

import java.util.LinkedList;
import java.util.Queue;

public class RotateAnArray {
    private static int[] testCase1 = { 1, 2, 3, 4, 5, 6, 7 };
    private static int[] testCase2 = { 1, 2 };

    public static void rotate(int[] nums, int k) {
        // validations
        if (nums.length == 0 || nums.length == 1 || k == 0 || k == nums.length) {
            return;
        }
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void main(String[] args) {
        // System.out.println("Expected: [5,6,7,1,2,3,4] :: Actual: ");
        rotate(testCase1, 3);
        rotate(testCase2, 2);
    }
}

// validations
// make new int[nums.length]
// make int index
// loop k times from nums.length-k to nums.length put elements into new array
// loop through nums from 0 to nums.length-k, add elements to array