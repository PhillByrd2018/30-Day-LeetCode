package Challenger;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

public class MajorityElement {

    public static int[] testCase1 = {3,2,3};
    public static int[] testCase2 = {2,2,1,1,1,2,2};

    public static int majorityElement(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> elementMap = new HashMap<>();

        for (int num : nums) {
            elementMap.put(num, elementMap.getOrDefault(num, 0) + 1);
        }

        Optional<Entry<Integer, Integer>> maxEntry = elementMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return maxEntry.get().getKey();
    }

    public static void main(String[] args) {

        System.out.println("Expected: 3 :: Actual: " + majorityElement(testCase1));
        System.out.println("Expected: 2 :: Actual: " + majorityElement(testCase2));
    }
}