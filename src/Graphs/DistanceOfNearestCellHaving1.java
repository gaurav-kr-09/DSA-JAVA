package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    // ISKA ACHHA ANSWER ZEROONEMATRIX.JAVA ME HAI
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

    public static int[][] nearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] ans = new int[rows][cols];

        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1) q.add(new Pair(i, j));
            }
        }

        while (!q.isEmpty()){
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0 && ans[nr][nc] == 0){
                    ans[nr][nc] = ans[row][col] + 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        int[][] grid2 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 0}
        };

        int[][] grid3 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println("Test Case 1:");
        print2D(nearest(grid1));
        System.out.println();

        System.out.println("Test Case 2:");
        print2D(nearest(grid2));
        System.out.println();

        System.out.println("Test Case 3:");
        print2D(nearest(grid3));
    }

    // EXPECTED OUTPUT
    //Test Case 1:
    //        [1, 0, 0, 1]
    //        [0, 0, 1, 1]
    //        [1, 1, 0, 0]

    //Test Case 2:
    //        [0, 1, 0]
    //        [0, 0, 1]
    //        [0, 1, 2]

    //Test Case 3:
    //        [2, 1, 2]
    //        [1, 0, 1]
    //        [2, 1, 2]

    private static void print2D(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
