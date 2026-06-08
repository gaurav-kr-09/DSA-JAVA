package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOnAdjacencyList {
    public static void BFS(List<List<Integer>> adj, int start){
        int n = adj.size();
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");

            // List<Integer> curr = adj.get(front);
            // for(int i = 0; i < curr.size(); i++){
            //     if(!visited[curr.get(i)]) {
            //         visited[curr.get(i)] = true;
            //         q.add(curr.get(i));
            //     }
            // }

            for(int i: adj.get(front)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = List.of(
                List.of(1, 2, 3),
                List.of(0, 3),
                List.of(0),
                List.of(0, 1, 4),
                List.of(3)
        );

        BFS(adj, 1); // BFS around 1
    }
}
