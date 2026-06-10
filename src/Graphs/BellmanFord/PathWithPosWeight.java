package Graphs.BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathWithPosWeight {
    public static int[][] bellmanFord(int V, int[][] edges, int src) {
        // Step 1: Make answer array and fill with Inf and src with 0
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 2: Make parent array
        int[] parent = new int[V];
        for(int i=0; i<V; i++) parent[i] = i;

        // Step 3: apply V-1 times bellman ford
        for(int x = 1; x <= V - 1; x++){
            boolean updated = false;
            for(int i=0; i < edges.length; i++){
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    updated =  true;
                }
            }
            if(!updated) break;
        }

        return new int[][]{dist, parent};
    }

    private static List<Integer> getPath(int dest, int[] parent){
        List<Integer> path = new ArrayList<>();

        int node = dest;
        while (parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(node);

        Collections.reverse(path);
        return path;
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

        int[][] res = bellmanFord(V, edges, src);

        // Printing the shortest distances
        int[] ans = res[0];
        System.out.println("Shortest distances");
        for (int i =0; i<V; i++) System.out.println(i + " -> " + ans[i]);

        // Printing the paths
        int[] parent = res[1];
        System.out.println("Shortest paths");
        for(int i=0; i<V; i++){
            if(ans[i] == Integer.MAX_VALUE) System.out.println(i + " -> No Path"); // Unreachable node tackle
            else System.out.println(i + " -> " + getPath(i, parent));
        }
    }
}