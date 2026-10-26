package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsSumDivisibleByK {
    public static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // if land and not visited then apply BFS
                if(grid[i][j] > 0){
                    if(BFS(i, j, grid, k)) count++;
                }
            }
        }

        return count;
    }

    public static boolean BFS(int row, int col, int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Upar - niche - left - right
        int[] dr = {-1, 1, 0, 0}; // rows
        int[] dc = {0, 0, -1, 1}; // cols

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        long sum = grid[row][col];
        grid[row][col] = 0; // mark visited

        while (!q.isEmpty()){
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;

            for(int d=0; d<4; d++){
                int nr = r + dr[d]; // new row
                int nc = c + dc[d]; // new col

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] > 0){
                    q.add(new Pair(nr, nc));
                    sum += grid[nr][nc];
                    grid[nr][nc] = 0; // mark visited
                }
            }
        }

        return sum % k == 0;
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