package Challenger;

public class SearchInRotatedSortedArray {

    public static int[] testCase1 = { 4, 5, 6, 7, 0, 1, 2 };
    public static int testCase1Target = 0;

    public static int[] testCase2 = { 4, 5, 6, 7, 0, 1, 2 };
    public static int testCase2Target = 3;

    public static int search(int[] nums, int target) {
        int minIndex = findTheMinIndex(nums);

        if (nums.length ==0 || nums == null) {
            return -1;
        }
        // if we found that element already return
        if (nums[minIndex] == target) {
            return minIndex;
        }

        int length = nums.length;

        //if the target is less than the last element in the array set the start to the smallest element else the end of the array
        int start = (target <= nums[length - 1]) ? minIndex : 0;

        //if the target is larger than the last element set the end position to the smallest element else the end of the array
        int end = (target > nums[length - 1]) ? minIndex : length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }


    //this func will find the index of the smallest element in the array. 
        //it uses binary search to narrow the array until it finds the smallest element.
    public static int findTheMinIndex(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        System.out.println("Expected: 4 :: Actual: " + search(testCase1, testCase1Target));
        System.out.println("Expected: -1 :: Actual: " + search(testCase2, testCase2Target));
    }
}