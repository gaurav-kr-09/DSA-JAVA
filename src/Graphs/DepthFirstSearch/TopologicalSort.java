package Graphs.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;

public class TopologicalSort {
    public static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]) dfs(i, adj, visited, ans);
        }

        Collections.reverse(ans);
        return ans;
    }

    private static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        visited[start] = true;

        for (int neigh: adj.get(start)){
            if(!visited[neigh]) dfs(neigh, adj, visited, ans);
        }

        ans.add(start);
    }

    public static void main(String[] args) {
        // TC1
        int V1 = 6;
        ArrayList<ArrayList<Integer>> adj1 = createGraph(V1);

        addEdge(adj1, 5, 0);
        addEdge(adj1, 5, 2);
        addEdge(adj1, 4, 0);
        addEdge(adj1, 4, 1);
        addEdge(adj1, 2, 3);
        addEdge(adj1, 3, 1);

        // Expected: One valid topo order
        // [4,5,0,2,3,1]
        // [5,4,2,3,1,0]
        // etc.

        System.out.println("TC1:");
        System.out.println(topoSort(adj1));



        // TC2
        int V2 = 4;
        ArrayList<ArrayList<Integer>> adj2 = createGraph(V2);

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 3);

        // 0 -> 1 -> 2 -> 3

        System.out.println("\nTC2:");
        System.out.println(topoSort(adj2));



        // TC3
        int V3 = 6;
        ArrayList<ArrayList<Integer>> adj3 = createGraph(V3);

        addEdge(adj3, 0, 3);
        addEdge(adj3, 1, 3);
        addEdge(adj3, 2, 4);
        addEdge(adj3, 3, 5);
        addEdge(adj3, 4, 5);

        System.out.println("\nTC3:");
        System.out.println(topoSort(adj3));
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        return adj;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // Directed Graph
    }
}