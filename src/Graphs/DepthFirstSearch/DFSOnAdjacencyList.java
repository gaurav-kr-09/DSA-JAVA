package Graphs.DepthFirstSearch;

import java.util.List;

public class DFSOnAdjacencyList {
    public static void DFS(List<List<Integer>> adj, int start){
        int n = adj.size();
        boolean[] visited = new boolean[n];
        printDFS(adj, start, visited);
    }

    private static void printDFS(List<List<Integer>> adj, int start, boolean[] visited) {
        System.out.print(start + " ");

        visited[start] = true;

        // for(int i=0; i<adj.get(start).size(); i++){
        //     if(!visited[adj.get(start).get(i)]){
        //         printDFS(adj, adj.get(start).get(i),visited);
        //     }
        // }

        for(int i: adj.get(start)){
            if(!visited[i]){
                printDFS(adj, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(
                List.of(1, 2, 3),
                List.of(0, 3),
                List.of(0),
                List.of(0, 1, 4),
                List.of(3),
                List.of(5)
        );

        DFS(adj, 1); // BFS around 1
    }
}
