package Challenger;

public class BinarySearch {

    public static int[] testCase1 = {2,5};
    public static int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0]!= target) {
                return -1;
            }
            return 0;
        }

        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + ((end-start)/2);
            int currentNum = nums[mid];
            if (currentNum == target) {
                return mid;
            } else if (target < currentNum) {
                end = mid-1;
            } else if (currentNum < target) {
                start = mid + 1;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 4 :: Actual: " + search(testCase1, 5));
    }
}