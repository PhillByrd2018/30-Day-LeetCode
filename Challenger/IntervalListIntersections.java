package Challenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static int[][] testCase1 = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
    public static int[][] testCase2 = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        // create pointers for each slice of numbers and the number of slices we have
        int Apointer = 0;
        int Bpointer = 0;
        int Asize = A.length;
        int Bsize = B.length;
        List<List<Integer>> ans = new ArrayList<>();

        // we loop until one of our pointers reaches the end of their slices
        while (Apointer < Asize && Bpointer < Bsize) {
            // if B smallest element is less than As max element and vice versa we have an
            // overlap.
            if (A[Apointer][0] <= B[Bpointer][1] && B[Bpointer][0] <= A[Apointer][1]) {
                List<Integer> section = new ArrayList<>();
                // make a row of ans that is the max of the min values and min of the max
                // values.
                section.add(Math.max(A[Apointer][0], B[Bpointer][0]));
                section.add(Math.min(A[Apointer][1], B[Bpointer][1]));
                ans.add(section);
            }

            // now increment the pointers
            // if max of apointer is less that b max increment A
            if (A[Apointer][1] < B[Bpointer][1]) {
                Apointer++;
            } else {
                Bpointer++;
            }

        }

        int[][] res = createAns(ans);
        return res;

    }

    public static int[][] createAns(List<List<Integer>> ans) {
        int[][] res = new int[ans.size()][2];
        int i = 0;
        for (List<Integer> section : ans) {
            res[i][0] = section.get(0);
            res[i++][1] = section.get(1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Expected: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] :: Actual: "
                + Arrays.deepToString(intervalIntersection(testCase1, testCase2)));
    }
}