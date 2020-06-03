package Challenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelerSum {

    public static int twoCitySchedCost(int[][] costs) {
        int ans = 0;
        if (costs.length == 0) {
            return ans;
        }
        List<Integer> diffAList = new ArrayList<>();
        List<Integer> diffBList = new ArrayList<>();
        int n = costs.length / 2;

        for (int i = 0; i < costs.length; i++) {
            if (costs[i][1] > costs[i][0]) {
                ans += costs[i][0];
                diffBList.add(costs[i][1] - costs[i][0]);
            } else {
                ans += costs[i][1];
                diffAList.add(costs[i][0] - costs[i][1]);
            }
        }
        if (diffAList.size() > diffBList.size()) {
            Collections.sort(diffAList);
            for (int i = 0; i < (diffAList.size()) - n; i++) {
                ans += diffAList.get(i);
            }
        }

        else if (diffAList.size() < diffBList.size()) {
            Collections.sort(diffBList);
            for (int i = 0; i < (diffBList.size()) - n; i++)
                ans += diffBList.get(i);
        }

        return ans;
    }

    public static int twoCitySchedCostComplete(int[][] costs) {
        int minCost = 0;
        int N = costs.length / 2;
        for (int i = 0; i < 2 * N; i++)
            minCost += costs[i][0]; // get cost to send everyone to city diffAList

        int[] diff = new int[2 * N];
        for (int i = 0; i < 2 * N; i++)
            diff[i] = costs[i][1] - costs[i][0]; // compute the diff of sending diffBList instead of diffAList

        Arrays.sort(diff); // sort the diff Array
        for (int i = 0; i < N; i++)
            minCost += diff[i]; // send first N to city diffBList

        return minCost;
    }

    public static void main(String[] args) {

        int[][] testCase1 = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        System.out.println("Expected: 110 :: Actual: " + twoCitySchedCost(testCase1));
        System.out.println("Expected: 110 :: Actual: " + twoCitySchedCostComplete(testCase1));

        int[][] testCase2 = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        System.out.println("Expected: 1859 :: Actual: " + twoCitySchedCost(testCase2));
        System.out.println("Expected: 1859 :: Actual: " + twoCitySchedCostComplete(testCase2));

    }
}