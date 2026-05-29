package Array.MissingQns;

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

    public static int maxProfit(int[] prices) {
        int profit = 0, minPrice = prices[0];

        for(int i=1; i<prices.length; i++){
            if(prices[i] < minPrice) minPrice=prices[i];
            profit = Math.max(profit, prices[i]-minPrice);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6};
        System.out.println("Maximum profit is: "+ maxProfit(prices));
    }
}