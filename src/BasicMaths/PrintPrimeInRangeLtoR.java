package BasicMaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPrimeInRangeLtoR {
    private static int[] seive(int n){
        int[] isPrime = new int[n+1];
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;

        for(int i=2; i<=n; i++){
            if(isPrime[i] == 1){
                for(int j=2; i*j<=n; j++){
                    isPrime[i*j] = 0;
                }
            }
        }

        return isPrime;
    }

    public static List<Integer> primeRange(int l, int r) {
        int[] temp = seive(r);

        List<Integer> ans = new ArrayList<>();

        for(int i=l; i<=r; i++){
            if(temp[i] == 1) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(primeRange(2, 10));

        System.out.println(primeRange(1, 100));

        System.out.println(primeRange(10, 17));

        System.out.println(primeRange(7, 17));
    }
}