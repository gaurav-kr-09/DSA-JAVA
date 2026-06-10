package Graphs.BellmanFord;

import java.util.Arrays;

public class DetectingNegCycle {
    public static boolean bellmanFordDetectNeg(int V, int[][] edges, int src) {
        // Step 1: make dist graph and fill
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: apply bellman ford V-1 times
        for(int x = 1; x <= V-1; x++){
            boolean updated = false;
            for(int i = 0; i<edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    updated = true;
                }
            }
            // agar n-1 se pahle hi update nahi ho rha matlab aage v update nahi hoga
            if(!updated) return false;
        }

        // Step 3: 1 last time i.e. Vth time check for -ve detection
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][1];

            if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int src = 0;

        int[][] edges = {
                {1, 2, -2},
                {0, 1, 4},
                {3, 1, 1},
                {2, 3, -2},
                {0, 4, 5}
        };

        boolean negCycle = bellmanFordDetectNeg(V, edges, src);

        if(negCycle) System.out.println("-ve cycle present in graph");
        else System.out.println("No -ve cycle in graph");
    }
}
