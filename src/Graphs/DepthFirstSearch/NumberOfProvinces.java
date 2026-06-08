package Graphs.DepthFirstSearch;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    public static void DFS(int i, int[][] adj, boolean[] visited){
        int n = adj[0].length;
        visited[i] = true;

        for(int j=0; j<n; j++){
            if(adj[i][j] == 1 && !visited[j]){
                DFS(j, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr)); // 2
    }
}
