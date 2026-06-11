package Graphs.FloydWarshall;

public class FloydWarshallAlgo {

    private static final int INF = (int) 1e9;

    public static int[][] floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) { // for n times relaxation
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // niche ka line sirf +ve weights k case me likhna specially i == j
                    // if(i == k || j == k || i == j) continue; // avoid redundancy
                    if(dist[i][k] == INF || dist[k][j] == INF) continue; // avoid overflow

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        return dist;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0,   3,  10, INF},
                {INF, 0,   1,   7},
                {INF, INF, 0,   2},
                {INF, INF, INF, 0}
        };

        System.out.println("Original Matrix:");
        printMatrix(graph);

        int[][] shortestPaths = floydWarshall(graph);

        System.out.println("\nShortest Path Matrix:");
        printMatrix(shortestPaths);
    }
}