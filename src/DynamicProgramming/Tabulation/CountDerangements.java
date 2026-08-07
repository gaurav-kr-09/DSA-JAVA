package DynamicProgramming.Tabulation;

public class CountDerangements {
    public static long derangeCount(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        if(n > 0) dp[1] = 0;
        if(n > 1) dp[2] = 1;

        for(int i=3; i<=n; i++){
            dp[i] = (i-1) * (dp[i-2] + dp[i-1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println("D(0) = " + derangeCount(0));   // 1

        System.out.println("D(1) = " + derangeCount(1));   // 0

        System.out.println("D(2) = " + derangeCount(2));   // 1

        System.out.println("D(3) = " + derangeCount(3));   // 2

        System.out.println("D(4) = " + derangeCount(4));   // 9

        System.out.println("D(5) = " + derangeCount(5));   // 44

        System.out.println("D(6) = " + derangeCount(6));   // 265

        System.out.println("D(7) = " + derangeCount(7));   // 1854

        System.out.println("D(8) = " + derangeCount(8));   // 14833
    }
}