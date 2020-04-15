package Challenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ContiguousSubArray {

    public static int[] testCase1 = {0, 1};
    public static int[] testCase2 = {0, 1, 0};
    public static int[] testCase3 = {0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1};

    public static int findMaxLength(int[] nums) {
        
        if (nums == null) {
             return 0;
        }
        int ans = 0; 
        Stack<Integer> inputStack = new Stack<Integer>();
        for (int i = nums.length-1; i >= 0; i--) {
            inputStack.push(nums[i]);
        }

        if (inputStack.size() == 1) {
            return 1;
        }

        if (inputStack.size() == 2) {
            int currentNum = inputStack.pop();
            int nextNum = inputStack.peek();
            if (currentNum != nextNum) {
                return 2;
            } else {
                return 1;
            }

        }
        int ansChecker = 1;
    
        while (inputStack.size() > 2) {

            int currentNum = inputStack.pop();
            int nextNum = inputStack.peek();
            if (currentNum != nextNum) {

                ansChecker++;
            } else {
                ansChecker = 1;
            }
            ans = Math.max(ans, ansChecker);
        }
        return ans;
    }
    
    public static int findMaxLengthBruteForce(int[] nums) {
        int maxlen = 0;
        for (int start = 0; start < nums.length; start++) {
            int zeroes = 0, ones = 0;
            for (int end = start; end < nums.length; end++) {
                if (nums[end] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    maxlen = Math.max(maxlen, end - start + 1);
                }
            }
        }
        return maxlen;
    }

    public static int findMaxLengthMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
    
    public static void main(String[] args) {
        System.out.println("Expected: 2 :: Actual: " + findMaxLength(testCase1));
        System.out.println("Expected: 2 :: Actual: " + findMaxLength(testCase2));
        System.out.println("Expected: 12 :: Actual: " + findMaxLength(testCase3));

        System.out.println("===================================================" );

        System.out.println("Expected: 2 :: Actual: " + findMaxLengthBruteForce(testCase1));
        System.out.println("Expected: 2 :: Actual: " + findMaxLengthBruteForce(testCase2));
        System.out.println("Expected: 12 :: Actual: " + findMaxLengthBruteForce(testCase3));

        System.out.println("===================================================" );

        System.out.println("Expected: 2 :: Actual: " + findMaxLengthMap(testCase1));
        System.out.println("Expected: 2 :: Actual: " + findMaxLengthMap(testCase2));
        System.out.println("Expected: 12 :: Actual: " + findMaxLengthMap(testCase3));
        
    }

}

// O(n^2)
//create a return variable to hold the longest binary
//loop through the array
    //check input array at i_i+n with an inner for loop (a unique variable 0 does not follow a 0 || 1 does not follow a 1
        //if that subarray is unique and longer, that return variable becomes that substring

//return variable count.

    