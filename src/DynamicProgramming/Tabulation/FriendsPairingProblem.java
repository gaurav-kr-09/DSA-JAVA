package DynamicProgramming.Tabulation;

public class FriendsPairingProblem {
    public static int countPair(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + (i-1) * dp[i-2];
        }

        return dp[n];
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
