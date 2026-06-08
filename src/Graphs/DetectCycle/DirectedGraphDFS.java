package Graphs.DetectCycle;

import java.util.ArrayList;

public class DirectedGraphDFS {
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();

        boolean[] visited = new boolean[n];
        boolean[] recVisited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(dfs(i, visited, recVisited, adj)) return true;
            }
        }

        return false;
    }

    private static boolean dfs(int start, boolean[] visited, boolean[] recVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[start] = true;
        recVisited[start] = true;

        for(int neigh: adj.get(start)){
            if(!visited[neigh]) { // not visited
                // agar cycle mila to true
                if (dfs(neigh, visited, recVisited, adj)) return true;
            }
            // jab visited ho to check recVisited
            else if(recVisited[neigh]) return true;
        }

        recVisited[start] = false; // backtrack - for new path make recPath false

        return false;
    }

    public static void main(String[] args) {
        // TC1 : No Cycle
        int V1 = 4;
        ArrayList<ArrayList<Integer>> adj1 = createGraph(V1);

        addEdge(adj1, 0, 1);
        addEdge(adj1, 1, 2);
        addEdge(adj1, 2, 3);

        // 0 -> 1 -> 2 -> 3

        System.out.println("TC1 Expected: false");
        System.out.println("TC1 Actual  : " + isCyclic(adj1));


        // TC2 : Simple Cycle

        int V2 = 3;
        ArrayList<ArrayList<Integer>> adj2 = createGraph(V2);

        addEdge(adj2, 0, 1);
        addEdge(adj2, 1, 2);
        addEdge(adj2, 2, 0);

        // 0 -> 1 -> 2 -> 0

        System.out.println("\nTC2 Expected: true");
        System.out.println("TC2 Actual  : " + isCyclic(adj2));


        // TC3 : Back Edge

        int V3 = 4;
        ArrayList<ArrayList<Integer>> adj3 = createGraph(V3);

        addEdge(adj3, 0, 1);
        addEdge(adj3, 1, 2);
        addEdge(adj3, 2, 3);
        addEdge(adj3, 3, 1);

        // 0 -> 1 -> 2 -> 3
        //      ^         |
        //      |_________|

        System.out.println("\nTC3 Expected: true");
        System.out.println("TC3 Actual  : " + isCyclic(adj3));


        // TC4 : Disconnected No Cycle

        int V4 = 6;
        ArrayList<ArrayList<Integer>> adj4 = createGraph(V4);

        addEdge(adj4, 0, 1);
        addEdge(adj4, 1, 2);

        addEdge(adj4, 3, 4);
        addEdge(adj4, 4, 5);

        System.out.println("\nTC4 Expected: false");
        System.out.println("TC4 Actual  : " + isCyclic(adj4));


        // TC5 : Disconnected With Cycle

        int V5 = 6;
        ArrayList<ArrayList<Integer>> adj5 = createGraph(V5);

        addEdge(adj5, 0, 1);
        addEdge(adj5, 1, 2);

        addEdge(adj5, 3, 4);
        addEdge(adj5, 4, 5);
        addEdge(adj5, 5, 3);

        System.out.println("\nTC5 Expected: true");
        System.out.println("TC5 Actual  : " + isCyclic(adj5));
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
