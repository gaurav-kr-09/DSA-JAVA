package Graphs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraGFG {
    private static class Pair{
        int node;
        int cost;

        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();

        // Initialize the adj list
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        // fill the adjacency list
        for(int i=0; i<edges.length; i++){
            int st = edges[i][0], end = edges[i][1], cst = edges[i][2];
            adj.get(st).add(new Pair(end, cst));
            adj.get(end).add(new Pair(st, cst)); // for undirected graph
        }

        // make a answer array and fill it with inf and 0 for source
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        // make the min heap and add source
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Pair(src, 0));

        // Apply dijkstra's algo
        while (!pq.isEmpty()){
            Pair front = pq.poll();

            if(front.cost > ans[front.node]) continue;

            for(Pair neigh: adj.get(front.node)){
                int newCost = front.cost + neigh.cost;
                if(newCost < ans[neigh.node]){
                    ans[neigh.node] = newCost;
                    pq.add(new Pair(neigh.node, newCost));
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        int V = 3;

        int[][] edges = {
                {0, 1, 1},
                {1, 2, 3},
                {0, 2, 6}
        };

        int src = 2;

        int[] ans = dijkstra(V, edges, src);
        // Output: [4, 3, 0]

        System.out.println(Arrays.toString(ans));
    }
}
