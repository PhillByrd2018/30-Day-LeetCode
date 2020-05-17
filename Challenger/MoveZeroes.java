package Challenger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {

    public static int[] testCase1 = {0,1,0,3,12}; // [1,3,12,0,0]
    public static int[] testCase2 = {0,0,1,12,3}; // [1,3,12,0,0]
    public static int[] testCase3 = {1,0,0,3,0,12}; // [1,3,12,0,0]
    public static int[] testCase4 = {1,5,0,0,3,0,12}; // [1, 5, 3, 12, 0, 0, 0]

    public static int[] moveZeroesWhile(int[] nums) {
        int indexOfZero = 0;
        int l = 0;
        int r = nums.length;

        while (l < r) {
            if (nums[l] != 0) {
                int temp = nums[indexOfZero];
                nums[indexOfZero++] = nums[l];
                nums[l] = temp;
            }
            l++;
        }
        
        return nums;
    }

    public static int[] moveZeroesWhileQue(int[] nums) {
        Queue<Integer> numQue = new LinkedList<>();
        
        for (int num : nums) {
            if (num != 0) {
                numQue.add(num);
            }
        }

        for (int i =0; i < nums.length; i++) {
            if (!numQue.isEmpty()) {
                nums[i] = numQue.poll();
            } else {
                nums[i] = 0;
            }
        }
        return nums;
    }

 public static void main(String[] args) {
   
    System.out.println("Expected output: [1, 3, 12, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase1)));
    System.out.println("Expected output: [1, 12, 3, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase2)));
    System.out.println("Expected output: [1, 3, 12, 0, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase3)));
    System.out.println("Expected output: [1, 5, 3, 12, 0, 0, 0] :: actual: " + Arrays.toString(moveZeroesWhile(testCase4)));
    }
}