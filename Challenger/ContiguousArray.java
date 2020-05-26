package Challenger;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxSequence = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                maxSequence = Math.max(maxSequence, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxSequence;

    }

    public static void main(String[] args) {
        int[] testCase1 = { 0, 1, 0, 1, 1, 1, 1, 1, 1};
        findMaxLength(testCase1);
    }
}
