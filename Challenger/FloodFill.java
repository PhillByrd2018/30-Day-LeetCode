package Challenger;

import java.util.Arrays;

public class FloodFill {
    public static int[][] testCase1 = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    public static int[][] testCase2 = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
    public static int[][] testCase3 = { { 0, 0, 0 }, { 0, 1, 1 } };

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        // validations

        int floodColor = image[sr][sc];
        
        if (floodColor == newColor ) {
            return image;
        }

        findFlood(image, sr, sc, newColor, floodColor);

        return image;

    }

    public static void findFlood(int[][] image, int sr, int sc, int newColor, int valueToFlood) {
        if (sr < 0 || sr > image.length - 1) {
            return;
        }
        if (sc < 0 || sc > image[0].length - 1) {
            return;
        }

        if (image[sr][sc] != valueToFlood) {
            return;
        }
        if (valueToFlood == newColor) {
            return;
        }

        image[sr][sc] = newColor;
        findFlood(image, sr + 1, sc, newColor, valueToFlood);
        findFlood(image, sr - 1, sc, newColor, valueToFlood);
        findFlood(image, sr, sc + 1, newColor, valueToFlood);
        findFlood(image, sr, sc - 1, newColor, valueToFlood);

    }

    public static void main(String[] args) {
        // System.out.println("Expected: [[2, 2, 2],[2, 2, 0],[2, 0, 1]] :: Actual: "
        //         + Arrays.deepToString(floodFill(testCase1, 1, 1, 2)));

        // System.out.println("Expected: [[1, 0, 1],[0, 2, 0],[1, 0, 1]] :: Actual: "
        //         + Arrays.deepToString(floodFill(testCase2, 1, 1, 2)));

                System.out.println("Expected: [[0, 0, 0],[0, 1, 1]] :: Actual: "
                + Arrays.deepToString(floodFill(testCase3, 1, 1, 1)));
    }
}

// validations

// create helper method that takes in all original params plus the color we want
// to fill
// this helper will recursively step through the array at the start location and
// the 4 directions out from there

// capture that value at start and call the helper
// if we don't see the value in the new location from our start we return.
// if we do see the color there then we change it to the new color
// call itself with the 4 new directions to check there as well
