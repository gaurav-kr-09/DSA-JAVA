package Graphs.DepthFirstSearch;

public class NumberOfClosedIslands {
    public static int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    if(DFS(i, j, grid)) count++;
                }
            }
        }

        return count;
    }

    public static boolean DFS(int r, int c, int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0|| r >= rows || c < 0 || c >= cols) return false; // not closed
        if(grid[r][c] == 1) return true; // is side se closed hai

        grid[r][c] = 1; // mark visited
        boolean upClosed = DFS(r-1, c, grid); // UPAR
        boolean downClosed = DFS(r+1, c, grid); // NICHE
        boolean leftClosed = DFS(r, c-1, grid); // LEFT
        boolean rightClosed =  DFS(r, c+1, grid); // RIGHT

        return upClosed && downClosed && leftClosed && rightClosed; // all sides closed
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,1,1,1,1,1,1},
                {1,0,0,0,1,0,0,0,1},
                {1,0,1,0,1,0,1,0,1},
                {1,0,0,0,1,0,0,0,1},
                {1,1,1,1,1,1,1,1,1}
        };
        System.out.println(closedIsland(grid1)); // Expected: 2

        int[][] grid2 = {
                {0,0,1,0,0},
                {0,1,0,1,0},
                {0,1,1,1,0}
        };
        System.out.println(closedIsland(grid2)); // Expected: 1

        int[][] grid3 = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}
        };
        System.out.println(closedIsland(grid3)); // Expected: 2
    }
}