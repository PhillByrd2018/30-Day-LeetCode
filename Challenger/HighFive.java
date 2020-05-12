package Challenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {

    public static int[][] testCase1 = { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 },
            { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } };

    public static int[][] highFive(int[][] items) {

        // validations

        Map<Integer, PriorityQueue<Integer>> sumMap = new TreeMap<>();

        for (int[] testSnapShot : items) {
            int student = testSnapShot[0];
            int score = testSnapShot[1];

            if (!sumMap.containsKey(student)) {
                sumMap.put(student, new PriorityQueue<>());
            }
            PriorityQueue<Integer> prioQue = sumMap.get(student);

            if (prioQue.size() < 5) {
                prioQue.add(score);
            } else {
                int lowestTop5 = prioQue.peek();
                if (lowestTop5 < score) {
                    prioQue.poll();
                    prioQue.add(score);
                }
            }

        }

        int[][] ans = new int[sumMap.keySet().size()][2];
        int j = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> profile : sumMap.entrySet()) {
            int[] row = { profile.getKey(), calAvgScore(profile.getValue()) };
            ans[j++] = row;
        }
        return ans;
    }

    public static int calAvgScore(PriorityQueue<Integer> scores) {

        int avg = 0;
        int sum = 0;

        for (int num : scores) {
            sum += num;
        }
        avg = sum / 5;
        return avg;
    }

    public static void main(String[] args) {
        System.out.println("Expected: [1,87],[2,88] :: Actual: " + Arrays.deepToString(highFive(testCase1)));

        System.out.println("====================================================================");
    }
}

// validations

// Create a map to check the ID and the avg score
// step through the array
// take the args[0] as the key. save as int
// take the args[1] as the value, save as int and perform an average cal before
// you save

// step through the map keys and create the int return objects for our 2 d
// array.