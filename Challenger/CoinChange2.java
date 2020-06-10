package Challenger;

import java.util.Arrays;

// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/discuss/675182/JAVA-or-100-Faster-or-DP
public class CoinChange2 {
    
    public static int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int c : coins)
            for(int i = c; i <= amount; i++)
                arr[i] += arr[i-c];
        return arr[amount];
    }
    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 5};
        System.out.println("Expected: 4 :: Actual: " + change(5, testCase1));
    }
}