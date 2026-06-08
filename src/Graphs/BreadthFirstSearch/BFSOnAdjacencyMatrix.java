package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOnAdjacencyMatrix {
    public static void BFS(int[][] adj, int start){
        int n = adj.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");

            for (int i = 0; i < n; i++) {
                if (adj[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,1,1},{0,1,1}}; //
        // 0 --- 1 --- 2
        BFS(arr, 1); // BFS around 1 -> 1 0 2 || 1 2 0
    }
}
