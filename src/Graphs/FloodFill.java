package Graphs;

import java.util.Arrays;

public class FloodFill {
    // Method 1: DFS
    /*public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];

        int scl = image[sr][sc]; // scl -> start color or color at start
        DFS(sr, sc, scl, color, image, visited);
        return image;
    }

    public static void DFS(int r, int c, int scl, int color, int[][] image, boolean[][] visited){
        int rows = image.length;
        int cols = image[0].length;

        visited[r][c] = true;
        image[r][c] = color;

        if(r-1 >= 0 && image[r-1][c] == scl && !visited[r-1][c]) // UPAR
            DFS(r-1, c, scl, color, image, visited);
        if(r+1 < rows && image[r+1][c] == scl && !visited[r+1][c]) // NICHE
            DFS(r+1, c, scl, color, image, visited);
        if(c-1 >= 0 && image[r][c-1] == scl && !visited[r][c-1]) // LEFT
            DFS(r, c-1, scl, color, image, visited);
        if(c+1 < cols && image[r][c+1] == scl && !visited[r][c+1]) // RIGHT
            DFS(r, c+1, scl, color, image, visited);
    }*/

    // Method 2: Same as 1 but better
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int scl = image[sr][sc]; // scl -> start color or color at start
        if(scl == color) return image;

        DFS(sr, sc, scl, color, image);
        return image;
    }

    public static void DFS(int r, int c, int scl, int color, int[][] image){
        int rows = image.length;
        int cols = image[0].length;

        image[r][c] = color;

        if(r-1 >= 0 && image[r-1][c] == scl)     DFS(r-1, c, scl, color, image); // UPAR
        if(r+1 < rows && image[r+1][c] == scl)   DFS(r+1, c, scl, color, image); // NICHE
        if(c-1 >= 0 && image[r][c-1] == scl)     DFS(r, c-1, scl, color, image); // LEFT
        if(c+1 < cols && image[r][c+1] == scl)   DFS(r, c+1, scl, color, image); // RIGHT
    }

    // Method 3: ISKO V BFS SE BANA SAKTE HAI WO EXTRA PAIR CLASS BANA K - very complex
    /*private static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int scl = image[sr][sc]; // scl -> start color or color at start
        if(scl == color) return image;

        BFS(sr, sc, scl, color, image);
        return image;
    }

    // Upar - niche - left - right
    private static final int[] dr = {-1, 1, 0, 0}; // rows
    private static final int[] dc = {0, 0, -1, 1}; // cols

    private static void BFS(int sr, int sc, int scl, int color, int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()){
            Pair front = q.poll();

            int r = front.row;
            int c = front.col;

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == scl){
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }*/


    public static void main(String[] args) {

        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr1 = 1, sc1 = 1, color1 = 2;

        System.out.println("Test Case 1:");
        print2DArray(floodFill(image1, sr1, sc1, color1));
        System.out.println();

        int[][] image2 = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int sr2 = 0, sc2 = 0, color2 = 0;

        System.out.println("Test Case 2:");
        print2DArray(floodFill(image2, sr2, sc2, color2));
        System.out.println();

        int[][] image3 = {
                {0, 0, 0},
                {0, 1, 1}
        };
        int sr3 = 1, sc3 = 1, color3 = 1;

        System.out.println("Test Case 3:");
        print2DArray(floodFill(image3, sr3, sc3, color3));
    }

    private static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
