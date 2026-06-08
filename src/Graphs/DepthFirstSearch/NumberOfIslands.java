package Graphs.DepthFirstSearch;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // if land and not visited then apply DFS
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    DFS(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    public static void DFS(int r, int c, char[][] grid, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;

        visited[r][c] = true;
        if(r-1 >= 0 && grid[r-1][c] == '1' && !visited[r-1][c]) DFS(r-1, c, grid, visited); // UPAR
        if(r+1 < rows && grid[r+1][c] == '1' && !visited[r+1][c]) DFS(r+1, c, grid, visited); // NICHE
        if(c-1 >= 0 && grid[r][c-1] == '1' && !visited[r][c-1]) DFS(r, c-1, grid, visited); // LEFT
        if(c+1 < cols && grid[r][c+1] == '1' && !visited[r][c+1]) DFS(r, c+1, grid, visited); // RIGHT
    }


    public static void main(String[] args) {

        // Example 1
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid1));
        // Expected: 1

        // Example 2
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numIslands(grid2));
        // Expected: 3

        // Additional Test 1
        char[][] grid3 = {
                {'1'}
        };

        System.out.println(numIslands(grid3));
        // Expected: 1

        // Additional Test 2
        char[][] grid4 = {
                {'0'}
        };

        System.out.println(numIslands(grid4));
        // Expected: 0

        // Additional Test 3
        char[][] grid5 = {
                {'1','0','1','0'},
                {'0','1','0','1'},
                {'1','0','1','0'}
        };

        System.out.println(numIslands(grid5));
        // Expected: 6

        // Additional Test 4
        char[][] grid6 = {
                {'1','1','1'},
                {'1','1','1'},
                {'1','1','1'}
        };

        System.out.println(numIslands(grid6));
        // Expected: 1

        // 1,3,1,0,6,1
    }
}