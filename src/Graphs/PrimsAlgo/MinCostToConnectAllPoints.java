package Graphs.PrimsAlgo;

import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    private static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int ans = 0;

        // Step 1: make visited array
        boolean[] visited = new boolean[n];

        // Step 2: make pq
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new Pair(0, 0));

        // Step 3: apply prim's algo
        while (!pq.isEmpty()){
            Pair top = pq.poll();

            if(visited[top.node]) continue;
            visited[top.node] = true;
            ans += top.dist;

            for(int i=0; i<n; i++){
                if(i == top.node || visited[i]) continue;

                int x1 = points[top.node][0], y1 = points[top.node][1];
                int x2 = points[i][0], y2 = points[i][1];

                int md = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.add(new Pair(i, md));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] points1 = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int[][] points2 = {
                {3, 12},
                {-2, 5},
                {-4, 1}
        };

        int[][] points3 = {
                {0, 0}
        };

        System.out.println("Test Case 1:");
        System.out.println(minCostConnectPoints(points1)); // Expected: 20

        System.out.println("Test Case 2:");
        System.out.println(minCostConnectPoints(points2)); // Expected: 18

        System.out.println("Test Case 3:");
        System.out.println(minCostConnectPoints(points3)); // Expected: 0
    }
}