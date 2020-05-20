package Challenger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {

        if (A.length == 0 || A.length == 1) {
            return A;
        }
        Queue<Integer> evenNums = new LinkedList<>();
        Queue<Integer> oddNums = new LinkedList<>();
        int[] ans;

        for (int num : A) {
            if (num % 2 == 0) {
                evenNums.add(num);
            } else {
                oddNums.add(num);
            }
        }
        ans = new int[evenNums.size() + oddNums.size()];
        int index = 0;
        while (!evenNums.isEmpty()) {
            ans[index++] = evenNums.poll();
        }
        while (!oddNums.isEmpty()) {
            ans[index++] = oddNums.poll();
        }

        return ans;
    }

    public static int[] sortArrayByParityII(int[] A) {

        if (A.length < 2) {
            return A;
        }

        int[] ans = new int[A.length];

        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();
        for (int num : A) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i%2==0) {
                ans[i] = evens.poll();
            } else{
                ans[i] = odds.poll();
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] testCase1 = { 3, 1, 2, 4 };
        System.out.println("Expected: [2, 4, 3, 1] :: Actual: " + Arrays.toString(sortArrayByParity(testCase1)));
        System.out.println("Expected: [2, 1, 4, 3] :: Actual: " + Arrays.toString(sortArrayByParityII(testCase1)));
    }
}