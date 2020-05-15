package Challenger;

import java.util.Arrays;

public class BinarySorter {

    public static int[] testCase1 = {0,1,2,3,4,5,6,7,8}; 

    public static int[] sortNumsByBinary(int[] nums) {

        int[] ans = {0};
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expected: [0,1,2,4,8,3,5,6,7] :: Actual: " + Arrays.toString(sortNumsByBinary(testCase1)));
    }
}