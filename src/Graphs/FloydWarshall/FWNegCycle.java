package Graphs.FloydWarshall;

public class FWNegCycle {
    private static final int INF = (int) 1e9;
    public static boolean hasNegativeCycle(int[][] dist) {
        int n = dist.length;

        // Floyd-Warshall
        for(int k=0; k<n; k++){ // for n times relaxation
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k] == INF || dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Negative Cycle Check
        for(int i=0; i<n; i++){
            if(dist[i][i] < 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0,    1,  INF},
                {INF,  0,  -3},
                {1,  INF,   0}
        };

        boolean ans = hasNegativeCycle(graph);
        System.out.println(ans ? "Negative cycle present" : "No negative cycle");
    }
}