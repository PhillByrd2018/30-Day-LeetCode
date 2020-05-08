package Challenger;
// https://leetcode.com/problems/check-if-it-is-a-straight-line/

import java.util.HashSet;
import java.util.Set;

public class PointsMakeALine {

    public static int[][] testCase1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
    public static int[][] testCase2 = { { 1, 2 }, { 2, 9 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };

    // this solution is using a check for the collinearity of the point in the
    // 2D-array
    // we calculate the difference of the first 2 points in our array and use that
    // difference in the following function. This function will take the difference
    // in slope of the first 2 points and use it with another point to see if it is
    // in line
    // if diffX * (y-y1) == diffY * (x-x1) then the third point is on the slope
    //  else we return false;
    public static boolean checkStraightLineOnePass(int[][] coordinates) {

        // validations
        if (coordinates.length == 2) {
            return true;
        }

        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];

        int point1_X = point1[0];
        int point1_Y = point1[1];

        int point2_X = point2[0];
        int point2_Y = point2[1];
        int diffX = point2_X - point1_X;
        int diffY = point2_Y - point1_Y;

        for (int[] point : coordinates) {
            if (diffX * (point[1] - point1_Y) != diffY * (point[0] - point1_X)) {
                return false;
            }
        }
        return true;
    }

    // for this solution we step through every point and calculate the slope of all
    // the points in out 2d-array.
    // we add those calculated slopes to a set and if we see more than one value in
    // the set at the end we return false.
    public static boolean checkStraightLineSetGreedy(int[][] coordinates) {
        Set<Double> slopeSet = new HashSet<>();

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                int[] point1 = coordinates[i];
                int[] point2 = coordinates[j];

                if (point2[0] - point1[0] != 0) {
                    int point1_X = point1[0];
                    int point1_Y = point1[1];

                    int point2_X = point2[0];
                    int point2_Y = point2[1];

                    double currentSlope = Math.abs(point2_Y - point1_Y) / (double) Math.abs(point2_X - point1_X);
                    slopeSet.add(currentSlope);
                }
            }
        }
        return slopeSet.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println("Expected: true :: Actual: " + checkStraightLineSetGreedy(testCase1));
        System.out.println("Expected: false :: Actual: " + checkStraightLineSetGreedy(testCase2));
        System.out.println("Expected: true :: Actual: " + checkStraightLineOnePass(testCase1));
        System.out.println("Expected: false :: Actual: " + checkStraightLineOnePass(testCase2));
    }
}