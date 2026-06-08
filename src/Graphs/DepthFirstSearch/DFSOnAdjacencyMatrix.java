package Graphs.DepthFirstSearch;

public class DFSOnAdjacencyMatrix {
    public static void DFS(int[][] adj, int start){
        int n = adj.length;
        boolean[] visited = new boolean[n];
        printDFS(adj, start, visited);
    }

    private static void printDFS(int[][] adj, int start, boolean[] visited) {
        System.out.print(start + " ");

        visited[start] = true;

         for(int i=0; i<adj.length;  i++){
             if(adj[start][i] == 1 && !visited[i]){
                 printDFS(adj, i, visited);
             }
         }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,1,0},
                {1,0,0,1},
                {1,0,0,1},
                {0,1,1,0}
        };

        DFS(arr, 0); // 0 1 3 2
    }
}
