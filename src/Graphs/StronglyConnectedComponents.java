package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    // KOSARAJU ALGORITHM
    private static int countSCC;
    public static List<List<Integer>> printSCC(int V, List<List<Integer>> adj) {
        // Step 1: make topo sorted stack
        boolean[] visited = new boolean[V];
        Stack<Integer> topo = new Stack<>();
        for(int i=0; i<V; i++){
            if(!visited[i]) dfsForTopo(i, adj, visited, topo);
        }

        // Step 2: make a reverse graph
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<V; i++) revAdj.add(new ArrayList<>());

        for(int i = 0; i<V; i++){
            for(int neigh: adj.get(i)){
                revAdj.get(neigh).add(i);
            }
        }

        // Step 3: Apply DFS based on topo stack
        List<List<Integer>> ans = new ArrayList<>();
        countSCC = 0;
        visited = new boolean[V]; // reinitialize the visited array to false
        while (!topo.isEmpty()){
            int top = topo.pop();

            if(!visited[top]){
                List<Integer> currSCC = new ArrayList<>();
                dfsTraversal(top, revAdj, visited, currSCC);
                ans.add(currSCC);
                countSCC++;
            }
        }

        return ans;
    }

    private static void dfsForTopo(int start, List<List<Integer>> adj, boolean[] visited, Stack<Integer> topo) {
        visited[start] = true;

        for(int neigh: adj.get(start)){
            if(!visited[neigh]) dfsForTopo(neigh, adj, visited, topo);
        }

        topo.push(start);
    }

    private static void dfsTraversal(int start, List<List<Integer>> revAdj, boolean[] visited, List<Integer> currSCC) {
        visited[start] = true;
        currSCC.add(start);

        for(int neigh: revAdj.get(start)){
            if(!visited[neigh]) dfsTraversal(neigh, revAdj, visited, currSCC);
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;

        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj1.add(new ArrayList<>());
        }

        adj1.get(0).add(1);
        adj1.get(1).add(2);
        adj1.get(2).add(0);

        adj1.get(2).add(3);

        adj1.get(3).add(4);
        adj1.get(4).add(3);

        System.out.println(printSCC(V1, adj1));
        // Expected: [[0,1,2], [3,4]] (order may vary)
        System.out.println("no. of SCC: " + countSCC);


        // Test Case 2
        int V2 = 8;

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }

        adj2.get(0).add(1);

        adj2.get(1).add(2);
        adj2.get(2).add(0);

        adj2.get(2).add(3);

        adj2.get(3).add(4);
        adj2.get(4).add(5);
        adj2.get(5).add(3);

        adj2.get(5).add(6);

        adj2.get(6).add(7);
        adj2.get(7).add(6);

        System.out.println(printSCC(V2, adj2));
        // Expected: [[0], [1,2], [3,4,5], [6,7]] (order may vary)
        System.out.println("no. of SCC: " + countSCC);


        // Test Case 3
        int V3 = 6;

        List<List<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V3; i++) {
            adj3.add(new ArrayList<>());
        }

        adj3.get(0).add(1);
        adj3.get(1).add(2);
        adj3.get(2).add(3);
        adj3.get(3).add(4);
        adj3.get(4).add(5);

        System.out.println(printSCC(V3, adj3));
        // Expected: [[0], [1], [2], [3], [4], [5]]
        System.out.println("no. of SCC: " + countSCC);
    }
}