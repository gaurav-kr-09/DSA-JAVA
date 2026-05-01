package Heaps;

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    private static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr) pq.add(ele);

        int ans = 0;
        while(pq.size() > 1){
            int currCost = pq.poll() + pq.poll();
            ans += currCost;
            pq.add(currCost);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] ropes = {4, 2, 7, 6, 9};
        System.out.println("Minimum cost to connect all ropes: " + minCost(ropes));
    }
}