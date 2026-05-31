package BasicMaths;

import java.util.HashSet;

public class DistinctPrimeFactorsOfProductOfArrayLC2521 {
    // Method 1: will not work for larger inputs
    /*public static int distinctPrimeFactors(int[] nums) {
        int prod = 1;
        for(int num: nums) prod *= num;

        int count = 0;
        for(int i=2; i*i<=prod; i++){
            if(prod % i == 0){
                count++;
                while(prod % i == 0) prod /= i;
            }
        }

        if(prod != 1) count++;

        return count;
    }*/

    // Method 2: optimal & best
    public static int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> primes = new HashSet<>();

        for(int num: nums){
            for(int i=2; i*i<=num; i++){
                if(num % i == 0){
                    primes.add(i);
                    while(num % i == 0) num /= i;
                }
            }

            if(num != 1) primes.add(num);
        }

        return primes.size();
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4,3,7,10,6}; // 4
        System.out.println(distinctPrimeFactors(nums1));

        int[] nums2 = {2,4,8,16}; // 1
        System.out.println(distinctPrimeFactors(nums2));
    }
}
