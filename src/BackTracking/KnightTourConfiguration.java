package BackTracking;

public class KnightTourConfiguration {
    public static boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return helper(grid, 0, 0, 0);
    }

    // Method 1
    /*public static boolean helper(int[][] grid, int row, int col, int val) {
        int n = grid.length;
        if(grid[row][col] == n*n - 1) return true;

        int i, j;
        // 2 up 1 right
        i = row-2; j = col+1;
        if(i >= 0 && j < n && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 up 1 left
        i = row-2; j = col-1;
        if(i >= 0 && j >= 0 && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 down 1 right
        i = row+2; j = col+1;
        if(i < n && j < n && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 down 1 left
        i = row+2; j = col-1;
        if(i < n && j >= 0 && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 left 1 up
        i = row-1; j = col-2;
        if(i >= 0 && j >= 0 && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 left 1 down
        i = row+1; j = col-2;
        if(i < n && j >= 0 && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 right 1 up
        i = row-1; j = col+2;
        if(i >= 0 && j < n && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        // 2 right 1 down
        i = row+1; j = col+2;
        if(i < n && j < n && grid[i][j] == val+1) return helper(grid, i, j, val+1);

        return false;
    }*/

    // Method 2
    public static int[][] dir = {
            {-2, 1}, {-2, -1},
            {2, 1}, {2, -1},
            {1, 2}, {-1, 2},
            {1, -2}, {-1, -2}
    };

    public static boolean helper(int[][] grid, int row, int col, int val) {
        int n = grid.length;
        if(grid[row][col] == n*n - 1) return true;

        for(int[] d: dir){
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == val+1)
                return helper(grid, nr, nc, val+1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };

        System.out.println(checkValidGrid(grid) ? "valid" : "Invalid");
    }
}