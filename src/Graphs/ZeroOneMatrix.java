package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
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
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 0) q.add(new Pair(i, j));
                else dist[i][j] = -1; // to acts as unvisited node
            }
        }

        while (!q.isEmpty()){
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == 1 && dist[nr][nc] == -1){
                    // actual me mat[nr][nc] == 1  is condition ka jarurat v nahi hai but for readability
                    dist[nr][nc] = dist[row][col]+1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return dist;
    }

    //Test Case 1:
    //        [0, 0, 0]
    //        [0, 1, 0]
    //        [1, 2, 1]

    //Test Case 2:
    //        [0, 0, 0]
    //        [0, 0, 0]
    //        [0, 0, 0]

    //Test Case 3:
    //        [2, 1, 2]
    //        [1, 0, 1]
    //        [2, 1, 2]

    public static void main(String[] args) {

        int[][] mat1 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] mat2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] mat3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println("Test Case 1:");
        print2D(updateMatrix(mat1));
        System.out.println();

        System.out.println("Test Case 2:");
        print2D(updateMatrix(mat2));
        System.out.println();

        System.out.println("Test Case 3:");
        print2D(updateMatrix(mat3));
    }

    private static void print2D(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
