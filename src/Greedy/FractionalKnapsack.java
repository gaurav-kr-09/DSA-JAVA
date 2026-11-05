package Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        // store val, wt, val/wt ratio
        double[][] items = new double[n][3];
        for(int i=0; i<n; i++){
            items[i][0] = val[i];
            items[i][1] = wt[i];
            items[i][2] = (double) val[i] / wt[i];
        }

        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));

        double ans = 0;
        for(int i=0; i<n; i++){
            if(capacity >= items[i][1]){
                ans += items[i][0];
                capacity -= (int) items[i][1];
            }else{ // fractional part
                ans += items[i][2] * capacity; // p/v * capacity
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        System.out.println(fractionalKnapsack(val1, wt1, 50));
        // Expected: 240.0

        int[] val2 = {10, 40, 30, 50};
        int[] wt2 = {5, 4, 6, 3};
        System.out.println(fractionalKnapsack(val2, wt2, 10));
        // Expected: 105.0

        int[] val3 = {10, 20, 30};
        int[] wt3 = {1, 2, 3};
        System.out.println(fractionalKnapsack(val3, wt3, 6));
        // Expected: 60.0

        int[] val4 = {500};
        int[] wt4 = {30};
        System.out.println(fractionalKnapsack(val4, wt4, 10));
        // Expected: 166.6666666667
    }
}