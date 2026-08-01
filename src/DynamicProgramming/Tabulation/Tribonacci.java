package DynamicProgramming.Tabulation;

public class Tribonacci {
    public static int tribonacci(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println("Tribonacci(0) = " + tribonacci(0));   // 0

        System.out.println("Tribonacci(1) = " + tribonacci(1));   // 1

        System.out.println("Tribonacci(2) = " + tribonacci(2));   // 1

        System.out.println("Tribonacci(3) = " + tribonacci(3));   // 2

        System.out.println("Tribonacci(4) = " + tribonacci(4));   // 4

        System.out.println("Tribonacci(5) = " + tribonacci(5));   // 7

        System.out.println("Tribonacci(10) = " + tribonacci(10)); // 149

        System.out.println("Tribonacci(25) = " + tribonacci(25)); // 1389537
    }
}
