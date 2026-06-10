package Graphs.PrimsAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsWithoutMST {
    private static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static int primMST(List<List<Pair>> adj) {
        int n = adj.size();
        int mstWeight = 0;

        // Step 1: Make visited array
        boolean[] visited = new boolean[n];

        // Step 2: make minheap and add start
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Pair(0, 0)); // 0 se start kar rhe hai

        while (!pq.isEmpty()){
            Pair top = pq.poll();

            if(visited[top.node]) continue;
            visited[top.node] = true;
            mstWeight += top.weight;

            for(Pair neigh: adj.get(top.node)){
                if(visited[neigh.node]) continue;
                pq.add(new Pair(neigh.node, neigh.weight));
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 0 -- 1 (2)
        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        // 0 -- 2 (5)
        adj.get(0).add(new Pair(2, 5));
        adj.get(2).add(new Pair(0, 5));

        // 0 -- 4 (1)
        adj.get(0).add(new Pair(4, 1));
        adj.get(4).add(new Pair(0, 1));

        // 1 -- 3 (1)
        adj.get(1).add(new Pair(3, 1));
        adj.get(3).add(new Pair(1, 1));

        // 1 -- 4 (2)
        adj.get(1).add(new Pair(4, 2));
        adj.get(4).add(new Pair(1, 2));

        // 2 -- 3 (5)
        adj.get(2).add(new Pair(3, 5));
        adj.get(3).add(new Pair(2, 5));

        // 2 -- 4 (3)
        adj.get(2).add(new Pair(4, 3));
        adj.get(4).add(new Pair(2, 3));

        // 3 -- 4 (4)
        adj.get(3).add(new Pair(4, 4));
        adj.get(4).add(new Pair(3, 4));

        int mstWeight = primMST(adj);
        System.out.print("MST Weight = " + mstWeight);
    }
}