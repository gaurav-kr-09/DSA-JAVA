package Graphs;

import java.util.*;

public class FindEventualSafeStates {
    // Method 1: using DFS
    /*public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] recVisited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, recVisited, graph);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!recVisited[i]) ans.add(i);
        }
        return ans;
    }

    private static boolean dfs(int start, boolean[] visited, boolean[] recVisited, int[][] graph) {
        visited[start] = true;
        recVisited[start] = true;

        for(int neigh: graph[start]){
            if(!visited[neigh] && dfs(neigh, visited, recVisited, graph)) return true;
            else if(recVisited[neigh]) return true;
        }

        recVisited[start] = false;
        return false;
    }*/

    // Method 2: using BFS - IMPORTANT
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // Step 1: Reverse the graph or make adjacency list of reverse graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];

        for(int i=0; i<n; i++){
            for(int neigh: graph[i]){
                // i se neigh (i -> neigh) pe edge hai original graph me
                // reverse me ye neigh se i (neigh -> i) pe hoga
                adj.get(neigh).add(i);
                indegree[i]++;
            }
        }

        // Step 2: Apply Kahn's algo
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int front = q.poll();
            // ans.add(front);

            for(int neigh: adj.get(front)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) q.offer(neigh);
            }
        }

        // Collections.sort(ans);
        for (int i=0; i<n; i++){
            if(indegree[i] == 0) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        // TC1
        int[][] graph1 = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        // Expected: [2,4,5,6]

        System.out.println("TC1 Expected: [2, 4, 5, 6]");
        System.out.println("TC1 Actual  : " + eventualSafeNodes(graph1));


        // TC2
        int[][] graph2 = {
                {1, 2},
                {2, 3},
                {3},
                {}
        };

        // Expected: [0,1,2,3]

        System.out.println("\nTC2 Expected: [0, 1, 2, 3]");
        System.out.println("TC2 Actual  : " + eventualSafeNodes(graph2));


        // TC3
        int[][] graph3 = {
                {1},
                {2},
                {0}
        };

        // Expected: []

        System.out.println("\nTC3 Expected: []");
        System.out.println("TC3 Actual  : " + eventualSafeNodes(graph3));


        // TC4
        int[][] graph4 = {
                {1},
                {2},
                {},
                {4},
                {5},
                {}
        };

        // Expected: [0,1,2,3,4,5]

        System.out.println("\nTC4 Expected: [0, 1, 2, 3, 4, 5]");
        System.out.println("TC4 Actual  : " + eventualSafeNodes(graph4));


        // TC5
        int[][] graph5 = {
                {1},
                {2},
                {3},
                {1},
                {5},
                {}
        };

        // Expected: [4,5]

        System.out.println("\nTC5 Expected: [4, 5]");
        System.out.println("TC5 Actual  : " + eventualSafeNodes(graph5));
    }
}