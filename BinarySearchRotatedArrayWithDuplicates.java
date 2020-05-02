public class BinarySearchRotatedArrayWithDuplicates {

    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + ((end - start) / 2);

            if (nums[mid] == target) {
                return true;
            }

            //here is the special part from the normal BS
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted

                if (target < nums[mid] && target >= nums[start])
                    end = mid;
                else
                    start = mid + 1;

            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted

                if (target > nums[mid] && target < nums[start])
                    start = mid + 1;
                else
                    end = mid;
            } else {
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testCase1 = {2,5,6,0,0,1,2};
        System.out.println("Expected: false :: Actual: " + search(testCase1, 3));
        System.out.println("Expected: true :: Actual: " + search(testCase1, 6));
    }
}