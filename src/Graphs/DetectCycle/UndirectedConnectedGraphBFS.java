package Graphs.DetectCycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedConnectedGraphBFS {
    private static class Pair{
        int node;
        int parent;

        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    // ACTUAL FUNCTION TO DETECT CYCLE
    private static boolean detectCycle(int start, ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();

        // make visited array
        boolean[] visited = new boolean[n];
        Queue<Pair> q = new LinkedList<>();

        // Add the start and it's parent -1
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()){
            Pair front = q.poll();
            int node = front.node;
            int parent = front.parent;

            for(int neighbour: adj.get(node)){
                if(!visited[neighbour]){
                    q.add(new Pair(neighbour, node));
                    visited[neighbour] = true;
                } else { // Neighbour is visited
                    // if neighbour is not the parent of front - means cycle
                    if(neighbour != parent) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Test Case 1: No Cycle
        int V1 = 5;
        ArrayList<ArrayList<Integer>> adj1 = createGraph(V1);

        addEdge(adj1, 0, 1);
        addEdge(adj1, 1, 2);
        addEdge(adj1, 2, 3);
        addEdge(adj1, 3, 4);

        // 0 - 1 - 2 - 3 - 4

        System.out.println("TC1 Expected: false");
        System.out.println("TC1 Actual  : " + detectCycle(1, adj1));


        // Test Case 2: Simple Triangle Cycle
        int V2 = 3;
        ArrayList<ArrayList<Integer>> adj2 = createGraph(V2);

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 0);

        //    0
        //   / \
        //  1---2

        System.out.println("\nTC2 Expected: true");
        System.out.println("TC2 Actual  : " + detectCycle(0, adj2));


        // Test Case 3: Square Cycle
        int V3 = 4;
        ArrayList<ArrayList<Integer>> adj3 = createGraph(V3);

        addEdge(adj3, 0, 1);
        addEdge(adj3, 1, 2);
        addEdge(adj3, 2, 3);
        addEdge(adj3, 3, 0);

        // 0---1
        // |   |
        // 3---2

        System.out.println("\nTC3 Expected: true");
        System.out.println("TC3 Actual  : " + detectCycle(2, adj3));


        // Test Case 4: Tree Shaped Graph
        int V4 = 7;
        ArrayList<ArrayList<Integer>> adj4 = createGraph(V4);

        addEdge(adj4, 0, 1);
        addEdge(adj4, 0, 2);
        addEdge(adj4, 1, 3);
        addEdge(adj4, 1, 4);
        addEdge(adj4, 2, 5);
        addEdge(adj4, 2, 6);

        //           0
        //         /   \
        //        1     2
        //       / \    / \
        //      3   4  5   6

        System.out.println("\nTC4 Expected: false");
        System.out.println("TC4 Actual  : " + detectCycle(2, adj4));


        // Test Case 5: One Extra Edge Creates Cycle
        int V5 = 7;
        ArrayList<ArrayList<Integer>> adj5 = createGraph(V5);

        addEdge(adj5, 0, 1);
        addEdge(adj5, 0, 2);
        addEdge(adj5, 1, 3);
        addEdge(adj5, 1, 4);
        addEdge(adj5, 2, 5);
        addEdge(adj5, 2, 6);

        // Extra edge
        addEdge(adj5, 4, 6);

        //          0
        //        /  \
        //       1    2
        //      /  \ / \
        //      3   4---6
        //           \  /
        //             2

        System.out.println("\nTC5 Expected: true");
        System.out.println("TC5 Actual  : " + detectCycle(0, adj5));
    }

    // Functions to make graph
    private static ArrayList<ArrayList<Integer>> createGraph(int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        return adj;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected Graph
    }
}