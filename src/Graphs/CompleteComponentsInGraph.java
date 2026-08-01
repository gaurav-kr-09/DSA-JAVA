package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CompleteComponentsInGraph {
    // Method 1: Using DSU
    /*private static int[] parent;
    private static int[] size;
    public static int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Initialize parent znd size
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = i;
        }

        // Step 2: build components
        for(int[] edge: edges){
            union(edge[0], edge[1]);
        }

        // count nodes in each component
        Map<Integer, Integer> nodeCount = new HashMap<>();
        for(int i=0; i<n; i++){
            int leader = findLeader(i);
            nodeCount.put(leader, nodeCount.getOrDefault(leader, 0)+1);
        }

        // count edges in each component
        Map<Integer, Integer> edgesCount = new HashMap<>();
        for(int[] edge: edges){
            int leader = findLeader(edge[0]);
            edgesCount.put(leader, edgesCount.getOrDefault(leader, 0)+1);
        }

        // count complete component if edges = n * n-1 / 2
        int completeComponents = 0;
        for(int leader: nodeCount.keySet()){
            int nodes = nodeCount.get(leader);

            int actualEdges = edgesCount.getOrDefault(leader, 0);
            int requiredEdges = nodes * (nodes - 1) / 2;

            if(actualEdges == requiredEdges) completeComponents++;
        }

        return completeComponents;
    }

    private static void union(int a, int b) {
        a = findLeader(a);
        b = findLeader(b);

        if(a == b) return;

        if(size[a] >= size[b]){
            parent[b] = a;
            size[a] += size[b];
        }else{
            parent[a] = b;
            size[b] += size[a];
        }
    }

    private static int findLeader(int a) {
        if(a == parent[a]) return a;
        return parent[a] = findLeader(parent[a]);
    }*/

    // Method 2: Using DFS (kam lafda)
    public static int countCompleteComponents(int n, int[][] edges){
        // Step1: Make adj matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u); // since undirected
        }

        // Step 2: apply dfs and in that keep checking connected components
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        for(int i=0; i<n; i++){
            if(visited[i]) continue;

            // store each node of component
            List<Integer> component = new ArrayList<>();
            dfs(i, visited, adj, component);

            int k = component.size();
            boolean isComponentComplete = true;
            for(int node: component){
                // har node se exactly k-1 edges connected hona chahiye
                if(adj.get(node).size() != k-1){
                    isComponentComplete = false;
                    break;
                }
            }

            if(isComponentComplete) completeComponents++;
        }

        return completeComponents;
    }

    private static void dfs(int start, boolean[] visited, List<List<Integer>> adj, List<Integer> component) {
        visited[start] = true;
        component.add(start);

        for(int neigh: adj.get(start)){
            if(!visited[neigh]) dfs(neigh, visited, adj, component);
        }
    }

    public static void main(String[] args) {

        // Test Case 1
        int n1 = 6;
        int[][] edges1 = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };

        System.out.println(countCompleteComponents(n1, edges1));
        // Expected: 3
        // Components:
        // {0,1,2} -> complete
        // {3,4} -> complete
        // {5} -> complete


        // Test Case 2
        int n2 = 6;
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4},
                {3, 5}
        };

        System.out.println(countCompleteComponents(n2, edges2));
        // Expected: 1
        // {0,1,2} -> complete
        // {3,4,5} -> not complete


        // Test Case 3 (Single Node)
        int n3 = 1;
        int[][] edges3 = {};

        System.out.println(countCompleteComponents(n3, edges3));
        // Expected: 1


        // Test Case 4 (No Edges)
        int n4 = 5;
        int[][] edges4 = {};

        System.out.println(countCompleteComponents(n4, edges4));
        // Expected: 5


        // Test Case 5 (Complete Graph of 4 Nodes)
        int n5 = 4;
        int[][] edges5 = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(countCompleteComponents(n5, edges5));
        // Expected: 1


        // Test Case 6 (Cycle of 4 Nodes)
        int n6 = 4;
        int[][] edges6 = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };

        System.out.println(countCompleteComponents(n6, edges6));
        // Expected: 0
        // Complete graph of 4 nodes needs 6 edges, here only 4
    }
}
