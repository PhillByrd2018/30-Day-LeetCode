
public class MostWater {

    public static int[] testCase1 = {1,8,6,2,5,4,8,3,7}; // 49
    public static int[] testCase2 = {8,1,1,1,8}; // 32
    public static int[] testCase3 = {8}; // 0
    public static int[] testCase4 = {100,100}; // 100

    public static int findBiggestBucketSizeGreedy(int[] nums){
        int currMax = Integer.MIN_VALUE;
        int ans = 0;

        if (nums.length == 1) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                int dist = j - i;
                if ( nums[j] >= nums[i]) {
                    currMax = nums[i] * dist;
                } else if (nums[j] <= nums[i]) {
                    currMax = nums[j] * dist;
                }

                ans = Math.max(currMax, ans);
            }
        }
        return ans;
    }


    public static int findBiggestBucketSpeedy(int[] height){
        int maxArea = 0; 
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            maxArea = Math.max(maxArea, Math.min( height[l], height[r]) * (r-l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return maxArea;
    }

    public static void main(String[] args){
        System.out.println("Expected: 49  :: Actual: " + findBiggestBucketSizeGreedy(testCase1));
        System.out.println("Expected: 32  :: Actual: " + findBiggestBucketSizeGreedy(testCase2));
        System.out.println("Expected: 0  :: Actual: " + findBiggestBucketSizeGreedy(testCase3));
        System.out.println("Expected: 100  :: Actual: " + findBiggestBucketSizeGreedy(testCase4));

        System.out.println("===================================================================");

        System.out.println("Expected: 49  :: Actual: " + findBiggestBucketSpeedy(testCase1));
        System.out.println("Expected: 32  :: Actual: " + findBiggestBucketSpeedy(testCase2));
        System.out.println("Expected: 0  :: Actual: " + findBiggestBucketSpeedy(testCase3));
        System.out.println("Expected: 100  :: Actual: " + findBiggestBucketSpeedy(testCase4));


    }
}