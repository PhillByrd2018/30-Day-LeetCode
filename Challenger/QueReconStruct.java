package Challenger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/articles/queue-reconstruction-by-height/
public class QueReconStruct {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] testCase1 = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        System.out.println("Expected: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]] :: Actual: "
                + Arrays.deepToString(reconstructQueue(testCase1)));

    }
}