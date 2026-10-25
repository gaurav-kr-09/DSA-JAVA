package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands {
    private static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // if land and not visited then apply BFS
                if(grid[i][j] == 0){
                    if(BFS(i, j, grid)) count++;
                }
            }
        }

        return count;
    }

    // BFS without direction array
    /*public static boolean BFS(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        grid[row][col] = 1; // mark visited
        boolean isClosed = true;

        while (!q.isEmpty()){
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;

            if(r == 0|| r == rows-1 || c == 0 || c == cols-1) isClosed = false; // not closed

            // Left
            if(c-1 >= 0 && grid[r][c-1] == 0) {
                q.add(new Pair(r, c-1));
                grid[r][c - 1] = 1;
            }

            // Right
            if(c+1 < cols && grid[r][c+1] == 0) {
                q.add(new Pair(r, c+1));
                grid[r][c + 1] = 1;
            }

            // Top
            if(r-1 >= 0 && grid[r-1][c] == 0){
                q.add(new Pair(r-1, c));
                grid[r - 1][c] = 1;
            }

            // Bottom
            if(r+1 < rows && grid[r+1][c] == 0){
                q.add(new Pair(r+1, c));
                grid[r + 1][c] = 1;
            }
        }

        return isClosed;
    }*/

    // BFS with direction array
    public static boolean BFS(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Upar - niche - left - right
        int[] dr = {-1, 1, 0, 0}; // rows
        int[] dc = {0, 0, -1, 1}; // cols

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        grid[row][col] = 1; // mark visited
        boolean isClosed = true;

        while (!q.isEmpty()){
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;

            if(r == 0|| r == rows-1 || c == 0 || c == cols-1) isClosed = false; // not closed

            for(int k=0; k<4; k++){
                int nr = r + dr[k]; // new row
                int nc = c + dc[k]; // new col

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0){
                    q.add(new Pair(nr, nc));
                    grid[nr][nc] = 1;
                }
            }
        }

        return isClosed;
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