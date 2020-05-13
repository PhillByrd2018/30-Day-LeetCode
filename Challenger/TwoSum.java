package Challenger;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                return new int[] { map.get(comp), i };
            }

            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] testCase1 = {1, 4, 5};
        System.out.println("Expected: 1,2 :: Actual: " + twoSum(testCase1, 9));
    }
}