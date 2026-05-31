package BasicMaths;

import java.util.Arrays;

public class CountPrimesLC204 {
    public static int countPrimes(int n) {
        if(n <= 1) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i < n; i++){
            if(isPrime[i]){
                for(int j=2; i*j < n; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // count primes strictly lesser then n
        System.out.println(countPrimes(10)); // 4 -> 2,3,5,7
        System.out.println(countPrimes(0)); // 0
        System.out.println(countPrimes(1)); // 0
        System.out.println(countPrimes(7)); // 3 -> 2,3,5
    }
}
