package DynamicProgramming.Memoization;

public class Fibonacci {
    // Method 1: Without DP
    /*public static int fibonacci(int n){
        if(n <= 1) return n;
        int ans = fibonacci(n-1) + fibonacci(n-2);
        return ans;
    }

    public static int fib(int n) {
        return fibonacci(n);
    }*/

    // Method 2: With DP
    /*public static int[] dp;
    public static int fibonacci(int n){
        if(n <= 1) return n;

        if(dp[n] != 0) return dp[n]; // Dekho array me hai ?

        int ans = fibonacci(n-1) + fibonacci(n-2);

        dp[n] = ans; // array me dal do

        return ans;
    }

    public static int fib(int n) {
        dp = new int[n+1];
        return fibonacci(n);
    }*/

    // Same as 2 but thoda style
    public static int fibonacci(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n]; // Dekho array me hai ?
        return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp); // dekho pahle dp[n] me wo store kar diye fir dp[n] return kar diye
    }

    public static int fib(int n) {
        int[] dp = new int[n+1];
        return fibonacci(n, dp);
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
