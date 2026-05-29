package Array.Kadane;

public class BestTimeToBuyAndSellStock {
    // Bruteforce
    /*public static int maxProfit(int[] prices) {
        int profit = 0, n = prices.length;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                profit = Math.max(profit, prices[j]-prices[i]);
            }
        }

        return profit;
    }*/

    // USING KADANE'S ALGO BUT EXTRA SPACE
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        // Building Difference array
        int[] diff = new int[n-1];
        for(int i=1; i<n; i++){
            diff[i-1] = prices[i] - prices[i-1];
        }

        // KADANE'S ALGO
        int currSum = diff[0], maxSum = diff[0];
        for(int i=1; i< diff.length; i++){
            currSum = Math.max(currSum+diff[i], diff[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return Math.max(0, maxSum);
    }

    // OPTIMAL
    /*public static int maxProfit(int[] prices) {
        int profit = 0, minPrice = prices[0];

        for(int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i]-minPrice);
        }

        return profit;
    }*/

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6}; // ans -> 5
        System.out.println("Maximum profit is: "+ maxProfit(prices));
    }
}