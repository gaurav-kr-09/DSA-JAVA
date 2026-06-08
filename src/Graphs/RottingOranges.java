package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private static class Triplet{
        int row;
        int col;
        int time; // Time to Rotten

        Triplet(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    // Method 1: without direction array
    /*public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<Triplet> q = new LinkedList<>();

        // Put all rotten oranges in queue to start multisource bfs
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;

        // multi source bfs
        while (!q.isEmpty()){
            Triplet front = q.poll();
            int r = front.row;
            int c = front.col;
            int time = front.time;

            ans = Math.max(ans, time);

            // TOP
            if(r-1 >= 0 && !visited[r-1][c] && grid[r-1][c] == 1){
                q.add(new Triplet(r-1, c, time+1));
                visited[r-1][c] = true;
            }

            // BOTTOM
            if(r+1 < rows && !visited[r+1][c] && grid[r+1][c] == 1){
                q.add(new Triplet(r+1, c, time+1));
                visited[r+1][c] = true;
            }

            // LEFT
            if(c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] == 1){
                q.add(new Triplet(r, c-1, time+1));
                visited[r][c-1] = true;
            }

            // RIGHT
            if(c+1 < cols && !visited[r][c+1] && grid[r][c+1] == 1){
                q.add(new Triplet(r, c+1, time+1));
                visited[r][c+1] = true;
            }
        }

        // check if any fresh orange is left
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]) return -1;
            }
        }

        return ans;
    }*/

    // Method 2: Same as 1, but slight optimizing avoiding last loop for fresh check
    /*public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<Triplet> q = new LinkedList<>();

        int fresh = 0;
        // Put all rotten oranges in queue to start multisource bfs
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // multi source bfs
        int ans = 0;
        while (!q.isEmpty()){
            Triplet front = q.poll();
            int r = front.row;
            int c = front.col;
            int time = front.time;

            ans = Math.max(ans, time);

            // TOP
            if(r-1 >= 0 && !visited[r-1][c] && grid[r-1][c] == 1){
                q.add(new Triplet(r-1, c, time+1));
                visited[r-1][c] = true;
                fresh--;
            }

            // BOTTOM
            if(r+1 < rows && !visited[r+1][c] && grid[r+1][c] == 1){
                q.add(new Triplet(r+1, c, time+1));
                visited[r+1][c] = true;
                fresh--;
            }

            // LEFT
            if(c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] == 1){
                q.add(new Triplet(r, c-1, time+1));
                visited[r][c-1] = true;
                fresh--;
            }

            // RIGHT
            if(c+1 < cols && !visited[r][c+1] && grid[r][c+1] == 1){
                q.add(new Triplet(r, c+1, time+1));
                visited[r][c+1] = true;
                fresh--;
            }
        }

        return fresh == 0 ? ans : -1;
    }*/

    // Method 3: Same concept but used direction array
    /*private static final int[] dr = {0,0,-1,1};
    private static final int[] dc = {-1,1,0,0};

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<Triplet> q = new LinkedList<>();

        int fresh = 0;
        // Put all rotten oranges in queue to start multisource bfs
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new Triplet(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // multi source bfs
        int ans = 0;
        while (!q.isEmpty()) {
            Triplet front = q.poll();
            int r = front.row;
            int c = front.col;
            int time = front.time;

            ans = Math.max(ans, time);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    q.add(new Triplet(nr, nc, time+1));
                    visited[nr][nc] = true;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? ans : -1;
    }*/

    // Method 4: Best - using direction array and without visited
    private static final int[] dr = {0,0,-1,1};
    private static final int[] dc = {-1,1,0,0};

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Triplet> q = new LinkedList<>();

        int fresh = 0;
        // Put all rotten oranges in queue to start multisource bfs
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2){
                    q.add(new Triplet(i, j, 0));
                    grid[i][j] = 2;
                }
            }
        }

        // multi source bfs
        int ans = 0;
        while (!q.isEmpty()) {
            Triplet front = q.poll();
            int r = front.row;
            int c = front.col;
            int time = front.time;

            ans = Math.max(ans, time);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    q.add(new Triplet(nr, nc, time+1));
                    grid[nr][nc] = 2;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? ans : -1;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        int[][] grid3 = {
                {0, 2}
        };

        System.out.println("Test Case 1: " + orangesRotting(grid1)); // 4
        System.out.println("Test Case 2: " + orangesRotting(grid2)); // -1
        System.out.println("Test Case 3: " + orangesRotting(grid3)); // 0
    }
}
