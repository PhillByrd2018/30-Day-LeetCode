package Challenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrayInterSection {

    public static int[] testCase1 = { 1, 2, 3, 4, 5 };
    public static int[] testCase2 = { 1, 2, 5, 7, 9 };
    public static int[] testCase3 = { 1, 3, 4, 5, 8 };

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        Map<Integer, Integer> frequencyMap = new TreeMap<>();

        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr3) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static List<Integer> arraysIntersectionSpeedy(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;

        List<Integer> ans = new ArrayList<>();

        while (i < arr1.length && j < arr2.length && k < arr3.length) {

            if (arr1[i] == arr2[j] && arr3[k] == arr2[j]) {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }

        }
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expected: [1, 5] :: Actual: " + arraysIntersection(testCase1, testCase2, testCase3));
        System.out.println("Expected: [1, 5] :: Actual: " + arraysIntersectionSpeedy(testCase1, testCase2, testCase3));

    }
}

// validations
// create a treemap to hold the count of each num and preserve order
// loop through all three arrays and add to the maps the value that is seen

// create a list return object
// step through the Map keys and add to the list keys that have a value == 3


//speedy way
    //create indexes i,j,k AND a list return object
    //step through each array as long as the indexes are not at the end of their arrays
        //if all three elements are the same add to the list
        // else if the element at i is less than element at j  i++
        //else if the element at j < k, j ++
        //else k++;

    //return the array