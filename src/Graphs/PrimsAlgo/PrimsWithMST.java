package Graphs.PrimsAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsWithMST {
    private static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Triplet {
        int node;
        int parent;
        int weight;

        Triplet(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }

    private static List<Triplet> ans;
    private static int primMST(List<List<Pair>> adj) {
        int n = adj.size();
        ans = new ArrayList<>();
        int mstWeight = 0;

        // Step 1: Make visited array
        boolean[] visited = new boolean[n];

        // Step 2: make minheap and add start
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.offer(new Triplet(0,-1, 0)); // 0 se start kar rhe hai

        while (!pq.isEmpty()){
            Triplet top = pq.poll();

            if(visited[top.node]) continue;
            visited[top.node] = true;
            if(top.parent != -1){ // 1st wale me ye sab nahi karna hai
                ans.add(top);
                mstWeight += top.weight;
            }

            for(Pair neigh: adj.get(top.node)){
                if(visited[neigh.node]) continue;
                else pq.add(new Triplet(neigh.node, top.node, neigh.weight));
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

        System.out.println("MST is: ");
        for(Triplet t: ans) System.out.println(t.node + " , " + t.parent + " , " + t.weight);

        System.out.println("\nMST Weight = " + mstWeight);
    }
}