package Challenger;


public class MinPathSum {

    

    public static int[][] testCase1 = {{1,3,1},{1,5,1},{4,2,1}};
    public static int[][] testCase2 = {{1,3,1},{1,5,1},{4,2,1},{4,2,7},{4,2,1}};
    public static int[][] testCase3 = {{3,8,6,0,5,9,9,6,3,4,0,5,7,3,9,3},{0,9,2,5,5,4,9,1,4,6,9,5,6,7,3,2},{8,2,2,3,3,3,1,6,9,1,1,6,6,2,1,9},{1,3,6,9,9,5,0,3,4,9,1,0,9,6,2,7},{8,6,2,2,1,3,0,0,7,2,7,5,4,8,4,8},{4,1,9,5,8,9,9,2,0,2,5,1,8,7,0,9},{6,2,1,7,8,1,8,5,5,7,0,2,5,7,2,1},{8,1,7,6,2,8,1,2,2,6,4,0,5,4,1,3},{9,2,1,7,6,1,4,3,8,6,5,5,3,9,7,3},{0,6,0,2,4,3,7,6,1,3,8,6,9,0,0,8},{4,3,7,2,4,3,6,4,0,3,9,5,3,6,9,3},{2,1,8,8,4,5,6,5,8,7,3,7,7,5,8,3},{0,7,6,6,1,2,0,3,5,0,8,0,8,7,4,3},{0,4,3,4,9,0,1,9,7,7,8,6,4,6,9,5},{6,5,1,9,9,2,2,7,4,2,7,2,2,3,7,2},{7,1,9,6,1,2,7,0,9,6,6,4,4,5,1,0},{3,4,9,2,8,3,1,2,6,9,7,0,2,4,2,0},{5,1,8,8,4,6,8,5,2,4,1,6,2,2,9,7}};

    public static int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return DFS(grid, height - 1, width - 1);
    }

    public static int DFS(int[][] grid, int row, int col) {

        if(row == 0 && col == 0) return grid[row][col];
        if(row == 0) return grid[row][col] + DFS(grid, row, col - 1);
        if(col == 0) return grid[row][col] + DFS(grid, row - 1, col);
        return grid[row][col] + Math.min(DFS(grid, row - 1, col), DFS(grid, row, col - 1));
    }


    public static int minPathSumDP(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {

        System.out.println("Expected: 7 :: Actual: " + minPathSum(testCase1));
        System.out.println("Expected: 13 :: Actual: " + minPathSum(testCase2));
        System.out.println("Expected: 83 :: Actual: " + minPathSum(testCase3));

        System.out.println("Expected: 83 :: Actual: " + minPathSum(testCase3));
    }
}