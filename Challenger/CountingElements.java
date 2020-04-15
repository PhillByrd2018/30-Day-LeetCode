package Challenger;

import java.util.*;
import java.util.stream.*;

public class CountingElements {

    public static int[] testCase1 = {1,2,3};
    public static int[] testCase2 = {1,3,2,3,5,0};
    public static int[] testCase3 = {1,1,2,2};
    public static int[] testCase4 = {1,1,3,3,5,5,7,7};

    public static int countElementsGreedy(int[] arr) {

        int ans = 0;
        List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(intList); 

        Map<Integer, Integer> intMap = new HashMap<>();

        for (Integer num : intList) {
            if (intMap.containsKey(num)) {
            intMap.put(num, intMap.get(num)+1);
            } else {
                intMap.put(num, 1);
            }
        }

        for (Integer num : intList) {
            if (intMap.get(num+1) != null) {
                ans++;
                intMap.put(num+1, intMap.get(num+1)-1);
            } 
        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println("Expected: 2 :: Actual: " + countElementsGreedy(testCase1));
        System.out.println("Expected: 3 :: Actual: " + countElementsGreedy(testCase2));
        System.out.println("Expected: 2 :: Actual: " + countElementsGreedy(testCase3));
        System.out.println("Expected: 0 :: Actual: " + countElementsGreedy(testCase4));
    }
}