package Median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoArrays {

    public static int[] testCase1 = {1,3};
    public static int[] testCase2 = {2};
    public static int[] testCase3 = {1, 2};
    public static int[] testCase4 = {3, 4};
    public static int[] testCase5 = {1, 2, 5, 7, 8, 9, 10};
    public static int[] testCase6 = {11, 12};
    public static int[] testCase7 = {11, 12, 13};


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> bothArrays = new ArrayList<>();

        for(int num: nums1){
            bothArrays.add(num);
        }

        for(int num: nums2){
            bothArrays.add(num);
        }

        Collections.sort(bothArrays);
        int length = bothArrays.size();

        int medianNumberOdd = bothArrays.get((length-1)/2);
        int medianNumberEven = bothArrays.get((length+1)/2);

        if (length % 2==0){
            return (double)(medianNumberOdd + medianNumberEven)/2;
        }
        return (double)medianNumberOdd;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 2.0 :: Actual: " + findMedianSortedArrays(testCase1, testCase2));
        System.out.println("Expected: 2.5 :: Actual: " + findMedianSortedArrays(testCase3, testCase4));
        System.out.println("Expected: 8.0 :: Actual: " + findMedianSortedArrays(testCase5, testCase6));
        System.out.println("Expected: 8.5 :: Actual: " + findMedianSortedArrays(testCase5, testCase7));
    }

}