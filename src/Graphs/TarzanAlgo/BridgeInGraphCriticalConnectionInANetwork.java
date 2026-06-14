package Graphs.TarzanAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInGraphCriticalConnectionInANetwork {
    private static boolean[] visited;
    private static int[] dt;
    private static int[] low;
    private static List<List<Integer>> ans;
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(List<Integer> ls: connections){
            int u = ls.get(0), v = ls.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dt = new int[n];
        low = new int[n];
        visited = new boolean[n];
        ans = new ArrayList<>();

        dfs(0, -1, adj);

        return ans;
    }

    private static int time = 1;
    private static void dfs(int node, int parent, List<List<Integer>> adj){
        visited[node] = true;
        dt[node] = low[node] = time++;

        for(int neigh: adj.get(node)){
            if(neigh == parent) continue;

            if(!visited[neigh]){
                dfs(neigh, node, adj);
                low[node] = Math.min(low[node], low[neigh]);

                if(low[neigh] > dt[node]) ans.add(List.of(neigh, node));
            }
            else low[node] = Math.min(low[node], low[neigh]);
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 4;
        List<List<Integer>> connections1 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3)
        );

        System.out.println(
                criticalConnections(n1, connections1)
        );
        // Expected: [[1,3]] (order may vary)

        // Test Case 2
        int n2 = 2;
        List<List<Integer>> connections2 = List.of(
                Arrays.asList(0, 1)
        );

        System.out.println(
                criticalConnections(n2, connections2)
        );
        // Expected: [[0,1]]

        // Test Case 3
        int n3 = 5;
        List<List<Integer>> connections3 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(1, 3),
                Arrays.asList(3, 4)
        );

        System.out.println(
                criticalConnections(n3, connections3)
        );
        // Expected: [[3,4], [1,3]] (order may vary)

        // Test Case 4
        int n4 = 5;
        List<List<Integer>> connections4 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4)
        );

        System.out.println(
                criticalConnections(n4, connections4)
        );
        // Expected: all edges are bridges

        // Test Case 5
        int n5 = 6;
        List<List<Integer>> connections5 = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 0),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 5),
                Arrays.asList(5, 3)
        );

        System.out.println(
                criticalConnections(n5, connections5)
        );
        // Expected: [[2,3]]
    }
}