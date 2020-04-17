package Challenger;

public class IslandProblem {

    public static char[][] testCase1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    
    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numOfIslands = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        for (int r = 0; r < rowLength;++r) {
            for (int c=0; c < colLength;++c) {
                if (grid[r][c] == '1') {
                    ++numOfIslands;
                    DFS(grid, r, c);
                }
                
            }
        }
        return numOfIslands;
    }

    public static void DFS(char[][] grid, int r, int c) {
        int rowLength = grid.length;
        int colLength = grid[0].length;

        if (r < 0 || c < 0 || r >= rowLength || c >= colLength || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';

        DFS(grid, r-1, c);
        DFS(grid, r+1, c);
        DFS(grid, r, c-1);
        DFS(grid, r, c+1); 

    }

    public static void main(String[] args) {
        System.out.println("Expected: 1 :: Actual:" + numIslands(testCase1));
    }
}

// the solution will use DFS. When we loop the grid we will find a 1, this will trigger a DFS and we set a other contiguous 1s to 0 as they are part of the same island and continue to search as we find 1s