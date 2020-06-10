package Challenger;

public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = left + ((right - left)/2);

        while (left < right) {
            mid = left + ((right - left)/2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left++;
    }

    public static void main(String[] args) {
        int[] testCase1 = { 1, 3, 5, 6 };
        System.out.println("Expected: 2 :: Actual: " + searchInsert(testCase1, 4));
        System.out.println("Expected: 4 :: Actual: " + searchInsert(testCase1, 7));
        System.out.println("Expected: 2 :: Actual: " + searchInsert(testCase1, 5));
    }
}