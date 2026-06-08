package Graphs.DetectCycle;

import java.util.ArrayList;

public class UndirectedDisConnectedGraphDFS {
    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();

        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i] && isCycle(i, -1, visited, adj))
                return true;
        }

        return false;
    }

    private static boolean isCycle(int start, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[start] = true;

        for(int neighbour: adj.get(start)){
            if(!visited[neighbour]){
                if(isCycle(neighbour, start, visited, adj)) return true;
            }else{
                if(neighbour != parent) return true;
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
        System.out.println("TC1 Actual  : " + detectCycle(adj1));


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
        System.out.println("TC2 Actual  : " + detectCycle(adj2));


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
        System.out.println("TC3 Actual  : " + detectCycle(adj3));


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
        System.out.println("TC4 Actual  : " + detectCycle(adj4));


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
        System.out.println("TC5 Actual  : " + detectCycle(adj5));

        // Test Case 6: Disconnected Graph (No Cycle)
        int V6 = 7;
        ArrayList<ArrayList<Integer>> adj6 = createGraph(V6);

        addEdge(adj6, 0, 1);
        addEdge(adj6, 1, 2);

        addEdge(adj6, 3, 4);
        addEdge(adj6, 4, 5);
        addEdge(adj6, 5, 6);

        // Component 1:
        // 0 - 1 - 2
        //
        // Component 2:
        // 3 - 4 - 5 - 6

        System.out.println("\nTC6 Expected: false");
        System.out.println("TC6 Actual  : " + detectCycle(adj6));


        // Test Case 7: Disconnected Graph (One Component Has Cycle)
        int V7 = 7;
        ArrayList<ArrayList<Integer>> adj7 = createGraph(V7);

        addEdge(adj7, 0, 1);
        addEdge(adj7, 1, 2);

        addEdge(adj7, 3, 4);
        addEdge(adj7, 4, 5);
        addEdge(adj7, 5, 3);

        addEdge(adj7, 5, 6);

        // Component 1:
        //
        // 0 - 1 - 2
        //
        // Component 2:
        //
        //    3
        //   / \
        //  4---5
        //       \
        //        6

        System.out.println("\nTC7 Expected: true");
        System.out.println("TC7 Actual  : " + detectCycle(adj7));


        // Test Case 8: Multiple Disconnected Components
        int V8 = 10;
        ArrayList<ArrayList<Integer>> adj8 = createGraph(V8);

        addEdge(adj8, 0, 1);
        addEdge(adj8, 1, 2);
        addEdge(adj8, 2, 0);

        addEdge(adj8, 3, 4);

        addEdge(adj8, 5, 6);
        addEdge(adj8, 6, 7);
        addEdge(adj8, 7, 5);

        addEdge(adj8, 8, 9);

        // Component 1:
        //
        //    0
        //   / \
        //  1---2
        //
        // Component 2:
        //
        // 3 - 4
        //
        // Component 3:
        //
        //    5
        //   / \
        //  6---7
        //
        // Component 4:
        //
        // 8 - 9

        System.out.println("\nTC8 Expected: true");
        System.out.println("TC8 Actual  : " + detectCycle(adj8));
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
