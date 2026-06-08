package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaxSumProbability {
    private static class Pair{
        int node;
        double prob;

        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Step 1: make the Adjacency list from given edges
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i< edges.length; i++){
            int a = edges[i][0], b = edges[i][1];

            adj.get(a).add(new Pair(b, succProb[i]));
            adj.get(b).add(new Pair(a, succProb[i])); // since undirected graph
        }

        // Step 2: create and initialize ans with 0 and 1 for source
        double[] ans = new double[n];
        Arrays.fill(ans, 0.0);
        ans[start] = 1;

        // Step 3: make the max heap and add start
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.prob , a.prob);
            // return b.prob == a.prob ? Integer.compare(b.node, a.node) : Double.compare(b.prob , a.prob);
            // tie-breaker is not actually needed, but added for no reason
        });
        pq.offer(new Pair(start, 1));

        // Step 4: apply dijkstra algo
        while (!pq.isEmpty()){
            Pair top = pq.poll();
            if(top.prob < ans[top.node]) continue;

            for(Pair neigh: adj.get(top.node)){
                double newProb = top.prob * neigh.prob;
                if(newProb > ans[neigh.node]){
                    ans[neigh.node] = newProb;
                    pq.add(new Pair(neigh.node, newProb));
                }
            }
        }

        // return answer at end
        return ans[end];
    }

    public static void main(String[] args) {

        // Test Case 1
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;

        System.out.println(maxProbability(n1, edges1, succProb1, start1, end1));
        // Expected: 0.25


        // Test Case 2
        int n2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        int start2 = 0;
        int end2 = 2;

        System.out.println(maxProbability(n2, edges2, succProb2, start2, end2));
        // Expected: 0.3


        // Test Case 3
        int n3 = 3;
        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;

        System.out.println(maxProbability(n3, edges3, succProb3, start3, end3));
        // Expected: 0.0
    }
}
