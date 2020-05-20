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

    public static void main(String[] args) {
        int[] testCase1 = { 3, 1, 2, 4 };
        System.out.println("Expected: [2, 4, 3, 1] :: Actual: " + Arrays.toString(sortArrayByParity(testCase1)));
    }
}