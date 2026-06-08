package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {
    private static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    private static final int[] dr = {0,0,-1,1};
    private static final int[] dc = {-1,1,0,0};
    public static int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // for 1st and last row
        for(int c=0; c<cols; c++){
            if(grid[0][c] == 1){
                grid[0][c] = -1;
                q.add(new Pair(0, c));
            }

            if(grid[rows-1][c] == 1){
                grid[rows-1][c] = -1;
                q.add(new Pair(rows-1, c));
            }
        }

        // for 1st and last column
        for(int r = 0; r<rows; r++){
            if(grid[r][0] == 1){
                grid[r][0] = -1;
                q.add(new Pair(r,0));
            }

            if(grid[r][cols-1] == 1){
                grid[r][cols-1] = -1;
                q.add(new Pair(r, cols-1));
            }
        }

        while (!q.isEmpty()){
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = -1;
                }
            }
        }

        int count = 0;
        for(int[] row: grid){
            for(int ele: row){
                if(ele == 1) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] grid2 = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] grid3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        System.out.println("Test Case 1: " + numEnclaves(grid1)); // 3
        System.out.println("Test Case 2: " + numEnclaves(grid2)); // 0
        System.out.println("Test Case 3: " + numEnclaves(grid3)); // 0
    }
}