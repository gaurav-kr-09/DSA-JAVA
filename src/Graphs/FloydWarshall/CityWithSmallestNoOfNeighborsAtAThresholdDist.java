package Graphs.FloydWarshall;

import java.util.Arrays;

public class CityWithSmallestNoOfNeighborsAtAThresholdDist {
    public static int findTheCity(int n, int[][] edges, int dt) {
        // dt -> distanceThreshold

        // Step 1: make the adj matrix of graph and fill with Inf.
        // Inf for not directly connected edges and diagonally 0
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        // Step 2: fill the graph
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph[u][v] = wt;
            graph[v][u] = wt;
        }

        // Step 3: Floyd Warshall on graph
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                if(graph[i][k] == Integer.MAX_VALUE || i == k) continue;
                for(int j=0; j<n; j++){
                    if(graph[k][j] == Integer.MAX_VALUE || j == k) continue;

                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // Step 3: find min city
        int minCity = -1; // to mark the required city answer (CityWithSmallestNoOfNeighborsAtAThresholdDist)
        int minCount = Integer.MAX_VALUE; // to maintain the count of the minCity (only for comparison)
        for(int i=0; i<n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(graph[i][j] <= dt) count++;
            }
            if(count <= minCount){ // also use = coz in case of equal we want largest numbered city
                minCity = i;
                minCount = count;
            }
        }

        return minCity;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };

        int distanceThreshold = 4;

        int ans = findTheCity(n, edges, distanceThreshold);

        System.out.println(ans); // Expected: 3
    }
}