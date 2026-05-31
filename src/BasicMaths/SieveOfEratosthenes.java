package BasicMaths;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratosthenes {
    public static int[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j=2; i*j <= n; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime[i]) temp.add(i);
        }

        int[] ans = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans1 = sieve(10);
        for(int a: ans1) System.out.print(a + " ");
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++");

        int[] ans2 = sieve(1);
        for(int a: ans2) System.out.print(a + " ");
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++");

        int[] ans3 = sieve(2);
        for(int a: ans3) System.out.print(a + " ");
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++");

        int[] ans4 = sieve(75);
        for(int a: ans4) System.out.print(a + " ");
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++");
    }
}
