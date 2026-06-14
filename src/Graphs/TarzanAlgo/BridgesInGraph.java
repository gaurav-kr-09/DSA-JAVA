package Graphs.TarzanAlgo;

import java.util.ArrayList;
import java.util.List;

public class BridgesInGraph {
    private static int[] dt;
    private static int[] low;
    private static boolean[] visited;
    private static List<List<Integer>> bridges;
    public static List<List<Integer>> printBridgesInGraph(int V, List<List<Integer>> adj) {
        // Step 1: make dt, low, visited, and ans
        dt = new int[V];
        low = new int[V];
        visited = new boolean[V];
        bridges = new ArrayList<>();

        // Step 2: Apply tarzan's algo
        for(int i = 0; i<V; i++)
            if(!visited[i])
                tarzanDFS(i, -1, adj);

        // Step 3: return ans
        return bridges;
    }

    private static int time = 1; // ye default me dt and low fill karne k liye
    private static void tarzanDFS(int node, int parent, List<List<Integer>> adj) {
        // Step 1: make node visited
        visited[node] = true;

        // Step 2: start dfs by adding default time = time+1
        dt[node] = low[node] = time++;

        // Step 3: apply dfs and apply tarzan
        for(int neigh: adj.get(node)){
            if(neigh == parent) continue; // parent se nahi compare karna hai

            if(!visited[neigh]){
                tarzanDFS(neigh, node, adj);
                // low update karo
                low[node] = Math.min(low[node], low[neigh]);

                if(low[neigh] > dt[node]) // bridge found
                    bridges.add(List.of(node, neigh));
            }
            else // visited - low update karo
                low[node] = Math.min(low[node], low[neigh]); // isme low[neigh] ki jagah algorithmically dt[neigh] hona chahiye
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 7;

        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj1.add(new ArrayList<>());
        }

        adj1.get(0).add(1);
        adj1.get(1).add(0);

        adj1.get(1).add(2);
        adj1.get(2).add(1);

        adj1.get(2).add(0);
        adj1.get(0).add(2);

        adj1.get(1).add(3);
        adj1.get(3).add(1);

        adj1.get(3).add(4);
        adj1.get(4).add(3);

        adj1.get(4).add(5);
        adj1.get(5).add(4);

        adj1.get(5).add(3);
        adj1.get(3).add(5);

        adj1.get(5).add(6);
        adj1.get(6).add(5);

        System.out.println(printBridgesInGraph(V1, adj1));
        // Expected: [[5,6], [1,3]] (order may vary)


        // Test Case 2
        int V2 = 5;

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }

        adj2.get(0).add(1);
        adj2.get(1).add(0);

        adj2.get(1).add(2);
        adj2.get(2).add(1);

        adj2.get(2).add(3);
        adj2.get(3).add(2);

        adj2.get(3).add(4);
        adj2.get(4).add(3);

        System.out.println(printBridgesInGraph(V2, adj2));
        // Expected: [[3,4], [2,3], [1,2], [0,1]]
    }
}