package Challenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {

    private static int[] testCase1 = { 1, 2, 2, 1 };
    private static int[] testCase2 = { 2, 2 };

    private static int[] testCase3 = { 43, 85, 49, 2, 83, 2, 39, 99, 15, 70, 39, 27, 71, 3, 88, 5, 19, 5, 68, 34, 7, 41,
            84, 2, 13, 85, 12, 54, 7, 9, 13, 19, 92 };
    private static int[] testCase4 = { 10, 8, 53, 63, 58, 83, 26, 10, 58, 3, 61, 56, 55, 38, 81, 29, 69, 55, 86, 23, 91,
            44, 9, 98, 41, 48, 41, 16, 42, 72, 6, 4, 2, 81, 42, 84, 4, 13 };

    public static int[] intersectBAD(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numMap1 = new HashMap<>();
        Map<Integer, Integer> numMap2 = new HashMap<>();

        for (int num : nums1) {
            numMap1.put(num, numMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            numMap2.put(num, numMap2.getOrDefault(num, 0) + 1);
        }

        List<Integer> ansList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap1.entrySet()) {

            if (entry.getValue() >= 1 && numMap2.getOrDefault(entry.getKey(), 0) != 0) {
                int numberToAdd = (entry.getValue() + numMap2.get(entry.getKey())) / 2;
                while (numberToAdd-- > 0) {
                    ansList.add(entry.getKey());
                }
            }
        }

        int[] ans = new int[ansList.size()];
        int i = 0;
        for (int num : ansList) {
            ans[i++] = num;
        }

        return ans;
    }

    public static int[] intersectGood(int[] nums1, int[] nums2) {
    
        if (nums1.length > nums2.length) {
            return intersectGood(nums2, nums1);
        }
        Map<Integer, Integer> numMap1 = new HashMap<>();
        for (int num : nums1) {
            numMap1.put(num, numMap1.getOrDefault(num, 0) + 1);
        }
        int k=0;
        for (int num : nums2){
            int count = numMap1.getOrDefault(num, 0);
            if (count > 0) {
                nums1[k++] = num;
                numMap1.put(num, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
    public static void main(String[] args) {
        
        System.out.println("Expected: [2, 2]:: Actual: " + Arrays.toString(intersectBAD(testCase1, testCase2)));
        System.out.println("Expected: [2,83,3,41,84,13,9]:: Actual: " + Arrays.toString(intersectGood(testCase3, testCase4)));
    }
}