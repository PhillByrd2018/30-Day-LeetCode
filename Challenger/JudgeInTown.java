package Challenger;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JudgeInTown {

    public static int[][] testCase1 = { { 1, 3 }, { 2, 3 } }; // 3
    public static int[][] testCase2 = { { 1, 3 }, { 2, 3 }, { 3, 1 } }; // -1
    public static int[][] testCase3 = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } }; // 3

    public static int findJudge(int N, int[][] trust) {

        if (trust.length < N - 1) {
            return -1;
        }

        Set<Integer> peopleWhoDontTrustList = new HashSet<>();
        Map<Integer, Integer> countOfTrustMap = new HashMap<>();

        for (int p = 1; p <= N; p++) {
            peopleWhoDontTrustList.add(p);
        }

        for (int[] relation : trust) {
            if (peopleWhoDontTrustList.contains(relation[0])) {
                peopleWhoDontTrustList.remove(relation[0]);
            }
            countOfTrustMap.put(relation[1], countOfTrustMap.getOrDefault(relation[1], 0) + 1);

        }

        if (!peopleWhoDontTrustList.isEmpty()) {
            for (int person : peopleWhoDontTrustList) {
                if (countOfTrustMap.getOrDefault(person, 0) == N - 1) {
                    return person;
                }
            }
        }

        return -1;
    }

    public static int findJudgeGraph(int N, int[][] trust) {

        if (trust.length < N - 1) {
            return -1;
        }

        int[] outGoingTrust = new int[N + 1];
        int[] inComingTrust = new int[N + 1];

        for (int[] relation : trust) {
            outGoingTrust[relation[0]]++;
            inComingTrust[relation[1]]++;
        }

        for (int i = 0; i <= N; i++) {
            if (inComingTrust[i] == N-1 && outGoingTrust[i] == 0 ) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 3 :: Actual: " + findJudge(3, testCase1));
        System.out.println("Expected: -1 :: Actual: " + findJudge(3, testCase2));
        System.out.println("Expected: 3 :: Actual: " + findJudge(4, testCase3));

        System.out.println("==================================================");


        System.out.println("Expected: 3 :: Actual: " + findJudgeGraph(3, testCase1));
        System.out.println("Expected: -1 :: Actual: " + findJudgeGraph(3, testCase2));
        System.out.println("Expected: 3 :: Actual: " + findJudgeGraph(4, testCase3));
    }
}

// validations

// create an array that holds n elements for who doesn't trust
// create a map that holds the int n and an int for the number of trust

// step through the input 2d array
// if person input[i][0] trusts remove them from array if they are still in the
// array
// then add the person to the map or increment their trust count value

// step through the array of those that are left
// if the map at that key == n number of people we have found our judge

// return -1;