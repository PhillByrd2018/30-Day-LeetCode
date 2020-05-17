package Challenger;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesArray {

    private static int[] testCase1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

    public static int removeDuplicates(int[] nums) {
        Set<Integer> numSet = new TreeSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int index = 0;
        for (int num : numSet) {
            nums[index++] = num;
        }
        return numSet.size();
    }

    public static void main(String[] args) {
        System.out.println("Expected: 5 :: Actual: " + removeDuplicates(testCase1));
    }
}