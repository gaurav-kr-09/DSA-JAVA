package Graphs.BellmanFord;

import java.util.Arrays;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        for(int x = 1; x <= n-1; x++){
            boolean updated = false;
            for(int i = 0; i<times.length; i++){
                int u = times[i][0];
                int v = times[i][1];
                int wt = times[i][2];

                if(ans[u] != Integer.MAX_VALUE && ans[u] + wt < ans[v]) {
                    ans[v] = ans[u] + wt;
                    updated = true;
                }
            }
            if(!updated) break;
        }

        int maxTime = -1;
        for(int i=1; i<=n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, ans[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[][] times1 = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n1 = 4;
        int k1 = 2;

        System.out.println(networkDelayTime(times1, n1, k1));
        // Expected: 2

        // Test Case 2
        int[][] times2 = {
                {1, 2, 1}
        };
        int n2 = 2;
        int k2 = 1;

        System.out.println(networkDelayTime(times2, n2, k2));
        // Expected: 1

        // Test Case 3
        int[][] times3 = {
                {1, 2, 1}
        };
        int n3 = 2;
        int k3 = 2;

        System.out.println(networkDelayTime(times3, n3, k3));
        // Expected: -1
    }
}