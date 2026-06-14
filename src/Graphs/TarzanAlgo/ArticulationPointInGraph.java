package Graphs.TarzanAlgo;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointInGraph {
    private static int[] dt;
    private static int[] low;
    private static boolean[] visited;
    private static boolean[] isAP;

    public static List<Integer> printArticulationPointsInGraph(int V, List<List<Integer>> adj) {
        // Step 1: make dt, low, visited, and ans
        dt = new int[V];
        low = new int[V];
        visited = new boolean[V];
        isAP = new boolean[V];

        // Step 2: Apply tarzan's algo
        for(int i = 0; i<V; i++)
            if(!visited[i])
                tarzanDFS(i, -1, adj);

        // Step 3: return ans by checking where is AP
        List<Integer> aps = new ArrayList<>();
        for(int i=0; i<V; i++){
            if(isAP[i]) aps.add(i);
        }
        return aps;
    }

    private static int time = 0;
    private static void tarzanDFS(int node, int parent, List<List<Integer>> adj) {
        int children = 0;

        // Step 1: make node visited
        visited[node] = true;

        // Step 2: start dfs by adding default time = time+1
        dt[node] = low[node] = time++;

        // Step 3: apply dfs and apply tarzan
        for(int neigh: adj.get(node)){
            if(neigh == parent) continue; // parent se nahi compare karna hai

            if(!visited[neigh]){
                children++;
                tarzanDFS(neigh, node, adj);
                // low update karo
                low[node] = Math.min(low[node], low[neigh]);

                if(parent != -1 && low[neigh] >= dt[node]) // ap not at root found
                    isAP[node] = true;
            }
            else // visited - low update karo
                low[node] = Math.min(low[node], dt[neigh]); // low[neigh] in place of dt will also work
        }

        if(parent == -1 && children > 1) // for ap at root
            isAP[node] = true;
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

        System.out.println(printArticulationPointsInGraph(V1, adj1));
        // Expected: [1, 3, 5]


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

        System.out.println(printArticulationPointsInGraph(V2, adj2));
        // Expected: [1, 2, 3]


        // Test Case 3
        int V3 = 4;

        List<List<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V3; i++) {
            adj3.add(new ArrayList<>());
        }

        adj3.get(0).add(1);
        adj3.get(1).add(0);

        adj3.get(1).add(2);
        adj3.get(2).add(1);

        adj3.get(2).add(3);
        adj3.get(3).add(2);

        adj3.get(3).add(0);
        adj3.get(0).add(3);

        System.out.println(printArticulationPointsInGraph(V3, adj3));
        // Expected: []
    }
}