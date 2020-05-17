package Challenger;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    private static int[] testCase1 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

    public static boolean containsDuplicate(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Expected: true :: Actual: " + containsDuplicate(testCase1));
    }
}