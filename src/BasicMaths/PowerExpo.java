package BasicMaths;

public class PowerExpo {
    // method 1: not optimal
    /*private static int APowerB(int a, int b){
        if(b == 0) return 1;
        int ans = 1;
        for(int i=0; i<b; i++){
            ans *= a;
        }
        return ans;
    }*/

    // method 2: optimal
    /*private static double APowerB(int a, int b){
        if(b >= 0) return pow(a, b);
        else return 1/pow(a, -b);
    }*/

    // recursive
    /*private static double pow(int a, int b) {
        if(b == 0) return 1;
        double half = pow(a, b/2);
        if(b % 2 == 0) return half * half;
        else return half * half * a;
    }*/

    // Iterative
    /*private static double pow(int a, int b) {
        double ans = 1;
        double base = a;

        while (b > 0){
            if(b % 2 == 1) ans *= base;

            base *= base;
            b /= 2;
        }

        return ans;
    }*/

    // For Leetcode
    public static double APowerB(double x, int n) {
        long N = n;

        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }

    public static double pow(double x, long n){
        double ans = 1;
        double base = x;

        while(n > 0){
            if(n % 2 == 1) ans *= base;

            base *= base;
            n /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(APowerB(2, 10)); // 1024.0
        System.out.println(APowerB(5, 3)); // 125.0
        System.out.println(APowerB(1, 1)); // 1.0
        System.out.println(APowerB(5, -2)); // 0.04
        System.out.println(APowerB(1000, 0)); // 1.0
        System.out.println(APowerB(1000, 3)); // 1,000,000,000.0
    }
}
