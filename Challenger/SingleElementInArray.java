package Challenger;

import java.util.HashSet;
import java.util.Set;

// Brute force:
// validations
//
// loop through the array
// add values to set
// if we see the set already contains that value, remove it.
// at the end we should have only one element in the set and that is our ans

public class SingleElementInArray {

    public static int[] testCase1 = { 3, 3, 7, 7, 10, 11, 11 };

    public static int singleNonDuplicateBruteForce(int[] nums) {

        // validations

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }

        return numSet.stream().findFirst().get();
    }

    // binarySearch - the arrays is always odd and therefore the ans will always be
    // in the odd array and sub array as we split.
    // we find the mid and check that it has a pair
    // if it doesn't that is our ans
    // else we take both out and see which side of our sub array is odd and continue
    // our search.
    public static int singleNonDuplicateBinarySearch(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) / 2);
            boolean sidesAreEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (sidesAreEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (sidesAreEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }

            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        // System.out.println("Expected: 10 :: Actual: " + singleNonDuplicateBruteForce(testCase1));
        System.out.println("Expected: 10 :: Actual: " + singleNonDuplicateBinarySearch(testCase1));
    }

}
