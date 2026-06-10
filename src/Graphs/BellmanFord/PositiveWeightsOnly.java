package Graphs.BellmanFord;

import java.util.Arrays;

public class PositiveWeightsOnly {
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // Step 1: Make answer array and fill with Inf and src with 0
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: apply V-1 times bellman ford
        for(int x = 1; x <= V - 1; x++){
            for(int i=0; i < edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 5;
        int src = 0;

        int[][] edges = {

                {4, 3, 6},
                {0, 1, 30},
                {2, 3, 7},
                {0, 4, 5},
                {4, 2, 8},
                {0, 3, 20},
                {2, 1, 4}

        };

        int[] dist = bellmanFord(V, edges, src);
        System.out.println(Arrays.toString(dist));

        // Expected:
        // [0, 17, 13, 11, 5]
    }
}