package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                // if land and not visited then apply BFS
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    BFS(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    // METHOD 1: WITHOUT DIRECTION ARRAY
    /*private static void BFS(int row, int col, char[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()){
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;

            // Left
            if(c-1 >= 0 && grid[r][c-1] == '1' && !visited[r][c-1]) {
                q.add(new Pair(r, c-1));
                visited[r][c-1] = true;
            }

            // Right
            if(c+1 < cols && grid[r][c+1] == '1' && !visited[r][c+1]) {
                q.add(new Pair(r, c+1));
                visited[r][c+1] = true;
            }

            // Top
            if(r-1 >= 0 && grid[r-1][c] == '1' && !visited[r-1][c]){
                q.add(new Pair(r-1, c));
                visited[r-1][c] = true;
            }

            // Bottom
            if(r+1 < rows && grid[r+1][c] == '1' && !visited[r+1][c]){
                q.add(new Pair(r+1, c));
                visited[r+1][c] = true;
            }
        }
    }*/

    // METHOD 2: WITH DIRECTION ARRAY - Upar ka dono chiz same rahega bas BFS me slight change aayega
    private static void BFS(int row, int col, char[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Upar - niche - left - right
        int[] dr = {-1, 1, 0, 0}; // rows
        int[] dc = {0, 0, -1, 1}; // cols

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = true;

        while (!q.isEmpty()){
            Pair front = q.poll();
            int r = front.row;
            int c = front.col;

            for(int k=0; k<4; k++){
                int nr = r + dr[k]; // new row
                int nc = c + dc[k]; // new col

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
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