package DynamicProgramming.Memoization;

import java.util.Arrays;

public class FriendsPairingProblem {
    // Basic recursion
    /*public static int countPair(int n) {
        if(n <= 2) return n;
        return countPair(n-1) + (n-1) * countPair(n-2);
    }*/

    // DP Memoization
    public static int countPair(int n) {
        // dp[i] stores the number of ways to pair i friends - 0 is false
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return pairing(n, dp);
    }

    public static int pairing(int n, int[] dp){
        if(n <= 2) return n;

        if(dp[n] != -1) return dp[n];
        return dp[n] = pairing(n-1, dp) + (n-1) * pairing(n-2, dp);
    }

    public static void main(String[] args) {

        System.out.println("n = 1 -> " + countPair(1));   // 1

        System.out.println("n = 2 -> " + countPair(2));   // 2

        System.out.println("n = 3 -> " + countPair(3));   // 4

        System.out.println("n = 4 -> " + countPair(4));   // 10

        System.out.println("n = 5 -> " + countPair(5));   // 26

        System.out.println("n = 6 -> " + countPair(6));   // 76

        System.out.println("n = 7 -> " + countPair(7));   // 232

        System.out.println("n = 8 -> " + countPair(8));   // 764
    }
}
