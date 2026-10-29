package Greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;

        // (acosti - bcosti) k according sort
        Arrays.sort(costs, (a, b) -> Integer.compare(a[0]-a[1], b[0]-b[1]));

        int ans = 0;
        for(int i=0; i<n/2; i++) ans += costs[i][0]; // small diff -> a se bhejo
        for(int i=n/2; i<n; i++) ans += costs[i][1]; // large diff -> b se bhejo

        return ans;
    }

    public static void main(String[] args) {
        int[][] costs1 = {
                {10, 20},
                {30, 200},
                {400, 50},
                {30, 20}
        };
        System.out.println(twoCitySchedCost(costs1));
        // Expected: 110

        int[][] costs2 = {
                {259, 770},
                {448, 54},
                {926, 667},
                {184, 139},
                {840, 118},
                {577, 469}
        };
        System.out.println(twoCitySchedCost(costs2));
        // Expected: 1859

        int[][] costs3 = {
                {10, 100},
                {20, 200}
        };
        System.out.println(twoCitySchedCost(costs3));
        // Expected: 120
    }
}