package Graphs.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExists {
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;

        // Step 1: Making adjacency list edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // Step 2: Apply bfs
        boolean[] visited = new boolean[n];
        DFS(start, end, adj, visited);

        return visited[end];
    }

    public static void DFS(int start, int end, List<List<Integer>> adj, boolean[] visited){
        visited[start] = true;
        if(start == end) return;

        for(int i: adj.get(start)){
            if(!visited[i]) DFS(i, end, adj, visited);
        }
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        System.out.println(validPath(3, edges1, 0,2)); // true

        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(6, edges2, 0, 5)); // false
    }
}