package Graphs.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                BFS(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    public static void BFS(int i, int[][] adj, boolean[] visited){
        int n = adj[0].length;

        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;
        q.add(i);

        while (!q.isEmpty()){
            int front = q.poll();
            for(int j=0; j<n; j++){
                if(adj[front][j] == 1 && !visited[j]){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}
