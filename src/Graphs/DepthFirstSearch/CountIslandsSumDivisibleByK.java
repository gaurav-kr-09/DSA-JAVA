package Graphs.DepthFirstSearch;

public class CountIslandsSumDivisibleByK {
    public static int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] > 0){
                    long sum = DFS(i, j, grid);
                    if (sum % k == 0) count++;
                }
            }
        }

        return count;
    }

    public static long DFS(int r, int c, int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0|| r >= rows || c < 0 || c >= cols || grid[r][c] == 0) return 0;

        long sum = grid[r][c];
        grid[r][c] = 0; // mark visited

        sum += DFS(r-1, c, grid); // UPAR
        sum += DFS(r+1, c, grid); // NICHE
        sum += DFS(r, c-1, grid); // LEFT
        sum +=  DFS(r, c+1, grid); // RIGHT

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 2, 1, 0, 0},
                {0, 5, 0, 0, 5},
                {0, 0, 1, 0, 0},
                {0, 1, 4, 7, 0},
                {0, 2, 0, 0, 8}
        };

        int[][] grid2 = {
                {3, 0, 3, 0},
                {0, 3, 0, 3},
                {3, 0, 3, 0}
        };

        int[][] grid3 = {
                {0, 0},
                {0, 0}
        };

        int[][] grid4 = {
                {1, 1},
                {1, 1}
        };

        System.out.println(countIslands(grid1, 5)); // Expected: 2
        System.out.println(countIslands(grid2, 3)); // Expected: 6
        System.out.println(countIslands(grid3, 1)); // Expected: 0
        System.out.println(countIslands(grid4, 2)); // Expected: 1
    }
}