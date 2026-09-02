package DynamicProgramming.Tabulation;

public class Fibonacci {
    /*public static int fib(int n) {
        if(n <= 1) return n;

        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }*/

    // Space optimized
    public static int fib(int n) {
        if(n <= 1) return n;

        int a = 0, b = 1;

        for(int i=2; i<=n; i++){
            int temp = b;
            b += a;
            a = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println("Fib(0) = " + fib(0));    // 0

        System.out.println("Fib(1) = " + fib(1));    // 1

        System.out.println("Fib(2) = " + fib(2));    // 1

        System.out.println("Fib(3) = " + fib(3));    // 2

        System.out.println("Fib(5) = " + fib(5));    // 5

        System.out.println("Fib(10) = " + fib(10));  // 55

        System.out.println("Fib(20) = " + fib(20));  // 6765

        System.out.println("Fib(30) = " + fib(30));  // 832040
    }
}
