package Graphs;

import java.util.Arrays;

public class isGraphBipartite {
    // Method 1: using BFS
    /*public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colorArray = new int[n];
        // -1 for not visited 0 and 1 for different colors
        Arrays.fill(colorArray, -1);

        for(int i=0; i<n; i++){
            if(colorArray[i] == -1){ // not visited
                if(!BFS(i, colorArray, graph)) return false; // no need to check further
            }
        }

        return true;
    }

    private static boolean BFS(int start, int[] colorArray, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colorArray[start] = 1;

        while(!q.isEmpty()){
            int front = q.poll();
            int cf = colorArray[front]; // cf -> color of front

            for(int neigh: graph[front]){
                if(colorArray[neigh] == cf) return false;
                else if(colorArray[neigh] == -1){
                    q.add(neigh);
                    // colorArray[neigh] = (cf == 0) ? 1 : 0; // change the color
                    // Or trick we can use this
                    colorArray[neigh] = 1 - cf;
                }
            }
        }

        return true;
    }*/

    // Method 2: same as 1 but DFS
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] colorArray = new int[n];
        // -1 for not visited 0 and 1 for different colors
        Arrays.fill(colorArray, -1);

        for(int i=0; i<n; i++){
            if(colorArray[i] == -1){ // not visited
                if(!DFS(i, 1, colorArray, graph)) return false; // no need to check further
            }
        }

        return true;
    }

    private static boolean DFS(int start, int color, int[] colorArray, int[][] graph) {
        colorArray[start] = color;

        for(int neigh : graph[start]){
            if(colorArray[neigh] == color) return false;
            else if (colorArray[neigh] == -1){ // not visited
                if(!DFS(neigh, 1-color, colorArray, graph)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[][] graph1 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph1)); // false

        // Sample Test Case 2
        int[][] graph2 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(isBipartite(graph2)); // true

        // Sample Test Case 3
        int[][] graph3 = {
                {},
                {}
        };
        System.out.println(isBipartite(graph3)); // true

        // Sample Test Case 4
        int[][] graph4 = {
                {1},
                {0, 2},
                {1}
        };
        System.out.println(isBipartite(graph4)); // true
    }
}