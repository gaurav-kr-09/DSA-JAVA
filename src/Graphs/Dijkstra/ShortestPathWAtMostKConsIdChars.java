package Graphs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// LC -> 3970
public class ShortestPathWAtMostKConsIdChars {
    public static class Triplet {
        int node;
        int cost;
        int count;

        Triplet(int node, int cost, int count) {
            this.node = node;
            this.cost = cost;
            this.count = count;
        }
    }

    public static int shortestPath(int n, int[][] edges, String labels, int k) {
        // sabse pahle adjacency list banaye
        List<List<Triplet>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Triplet(v, wt, 0));
        }

        // ek 2-d array bana lenge jisme dist and k dono store hoga
        // unlike normal dijkstra jisme 1-d array banta hai
        int[][] ans = new int[n][k + 1];
        for (int[] row : ans) Arrays.fill(row, Integer.MAX_VALUE);
        ans[0][1] = 0; // start ka cost 0

        // min heap banao and cost k a/c sort
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Triplet(0, 0, 1)); // 0th node pe 0 cost and ek char

        // dijkstra
        while (!pq.isEmpty()) {
            Triplet front = pq.poll();
            int node = front.node;
            int cost = front.cost;
            int count = front.count;

            if(cost > ans[node][count]) continue; // cost jyada ho gaya currCost se
            if (node == n - 1) return cost; // destination pahuch gaye

            for(Triplet neigh: adj.get(node)){
                int neighNode = neigh.node;
                int wt = neigh.cost;

                // consecutive char count
                int ccCount;
                if (labels.charAt(node) == labels.charAt(neighNode)) ccCount = count + 1;
                else ccCount = 1;

                // agar cons chars k se jyada to wo path skip karo
                if(ccCount > k) continue;

                // aab jo naya cost bana wo purane se kam hoga to cost update
                int newCost = cost + wt;
                if(newCost < ans[neighNode][ccCount]){
                    ans[neighNode][ccCount] = newCost;
                    pq.add(new Triplet(neighNode, newCost, ccCount));
                }
            }
        }

        return -1; //  no valid answer found
    }

    public static void main(String[] args) {
        int[][] edges1 = {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 3}
        };
        System.out.println(shortestPath(3, edges1, "aab", 1));
        // Expected: 3

        int[][] edges2 = {
                {0, 1, 1},
                {1, 2, 1},
                {0, 2, 3}
        };
        System.out.println(shortestPath(3, edges2, "aab", 2));
        // Expected: 2

        int[][] edges3 = {
                {0, 1, 1},
                {1, 2, 1}
        };
        System.out.println(shortestPath(3, edges3, "aaa", 2));
        // Expected: -1
    }
}