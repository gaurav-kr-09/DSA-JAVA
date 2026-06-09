package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    private static class Triplet{
        int row;
        int col;
        int eff;

        Triplet(int row, int col, int eff){
            this.row = row;
            this.col = col;
            this.eff = eff;
        }
    }

    private static final int[] dr = {0,0,-1,1};
    private static final int[] dc = {-1,1,0,0};
    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] ans = new int[rows][cols];
        for(int i=0; i<rows; i++) Arrays.fill(ans[i], Integer.MAX_VALUE);
        ans[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.eff, b.eff));
        pq.offer(new Triplet(0, 0, 0));

        while(!pq.isEmpty()){
            Triplet front = pq.poll();
            int fr = front.row;
            int fc = front.col;
            int fe = front.eff;

            if(fe > ans[fr][fc]) continue;

            if(fr == rows-1 && fc == cols-1) return fe;

            for(int i=0; i<4; i++){
                int nr = fr + dr[i];
                int nc = fc + dc[i];

                if(nr >= 0 && nr < rows && nc >=0 && nc < cols){
                    int currEff = Math.abs(heights[nr][nc] - heights[fr][fc]);
                    int newEff = Math.max(currEff, fe);
                    if(newEff < ans[nr][nc]){
                        ans[nr][nc] = newEff;
                        pq.add(new Triplet(nr, nc, newEff));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[][] heights1 = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(minimumEffortPath(heights1));
        // Expected: 2


        // Test Case 2
        int[][] heights2 = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };

        System.out.println(minimumEffortPath(heights2));
        // Expected: 1


        // Test Case 3
        int[][] heights3 = {
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };

        System.out.println(minimumEffortPath(heights3));
        // Expected: 0
    }
}