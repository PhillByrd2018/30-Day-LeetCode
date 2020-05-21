package Challenger;

public class SubMatix {

    public static int[][] testCase1 = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
    public static int[][] testCase2 = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };

    public static int countSquare(int[][] matrix) {

        if (matrix == null)
            return 0;

        // square are at size 1x1, 2x2,3x3 etc
        // so we want to check 2x2s all the way through our matrix and keep a running
        // total of the biggest we see there
        int ret = 0;
        // loop through the 2d array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // if we see a z we don't care
                if (matrix[i][j] == 0)
                    continue;
                // if our 2x2 checker is out of bounds we don't check, but just move to add the
                // value at A[i][j] to the running total because 1x1 of 1 is a valid square.
                if (i >= 1 && j >= 1) {
                    // otherwise if we are in bounds we check to see if our 2x2 has at least 1 one
                    // in all 4 corners
                    // 1 1
                    // 1 1
                    // if we see a min value of greater than 1 in all four corners then we know we
                    // have an even bigger square here ie 3x3
                    // so we save that min value to the position in the 2d array for other checks
                    // that include this position
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1] + 1, matrix[i - 1][j] + 1),
                            matrix[i][j - 1] + 1);
                }
                //update the running total post 2x2 check
                ret += matrix[i][j];
                // System.out.println(i + " " + j + " " + matrix[i][j]);
            }
        }
        return ret;

    }

    public static void main(String[] args) {

        System.out.println("Expected: 7 :: Actual: " + countSquare(testCase1));

    }
}