package Challenger;
public class MaximumSubarray {

    public static int[] testCase1 = {-2,1,-3,4,-1,2,1,-5,4};
    public static int[] testCase2 = {1};
    public static int[] testCase3 = {-2,1};
    public static int[] testCase4 = {-2,-1};

    public static int findMaxInArrayGreedy(int[] nums) {
        if (nums.length < 2 ){
            return nums[0];
        }

        int ans = nums[0];
        int currentMax = nums[0];

        for(int i = 0; i < nums.length; i++) {
            currentMax = nums[i];
            if (currentMax > ans) {
                ans = currentMax;
             }
             for(int j=i+1; j<nums.length; j++) {
                currentMax += nums[j]; 
                 if (currentMax > ans) {
                    ans = currentMax;
                 }
             }
        }
        return ans;
    }

    public static int findMaxInArrayLessGreedy(int[] nums) {


        int ans = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            ans = Math.max(currSum, ans);
        }

        return ans;
    }


    public static int findMaxInArrayDivideAndConq(int[] nums){
      
        return DivideAndConqHelper(nums, 0, nums.length-1);

    }
    public static int DivideAndConqHelper(int[] nums, int left, int right){
        if (left == right) return nums[left];
        int p = (left + right) / 2;

        int leftSum = DivideAndConqHelper(nums, left, p);
        int rightSum = DivideAndConqHelper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);

    }


    public static int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];
    
        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
          currSum += nums[i];
          leftSubsum = Math.max(leftSubsum, currSum);
        }
    
        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
          currSum += nums[i];
          rightSubsum = Math.max(rightSubsum, currSum);
        }
    
        return leftSubsum + rightSubsum;
      }


    public static void main(String[] args){

        System.out.println("Expected: 6 :: Actual: " + findMaxInArrayGreedy(testCase1));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayGreedy(testCase2));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayGreedy(testCase3));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayGreedy(testCase4));

        System.out.println("===========================================================");

        System.out.println("Expected: 6 :: Actual: " + findMaxInArrayDivideAndConq(testCase1));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayDivideAndConq(testCase2));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayDivideAndConq(testCase3));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayDivideAndConq(testCase4));

        System.out.println("===========================================================");

        System.out.println("Expected: 6 :: Actual: " + findMaxInArrayLessGreedy(testCase1));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayLessGreedy(testCase2));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayLessGreedy(testCase3));
        System.out.println("Expected: 1 :: Actual: " + findMaxInArrayLessGreedy(testCase4));
    }

}