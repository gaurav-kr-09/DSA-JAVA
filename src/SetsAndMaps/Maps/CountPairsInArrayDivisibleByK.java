package SetsAndMaps.Maps;

import java.util.HashMap;

// LeetCode wale me product divisible by k hai and GFG Wale me sum
public class CountPairsInArrayDivisibleByK {
    // Bruteforce O(nsq)
    /*private static long countPairsLC(int[] arr, int k) {
        long count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if((long)arr[i] * arr[j] % k == 0) count++;
            }
        }
        return count;
    }

    private static long countPairsGFG(int[] arr, int k) {
        long count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if((long)(arr[i] + arr[j]) % k == 0) count++;
            }
        }
        return count;
    }*/

    // Optimal O(n)
    private static long countPairsLC(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for(int ele: arr){
            int g = gcd(ele, k);
            map.put(g, map.getOrDefault(g, 0)+1);
        }

        for(int key: map.keySet()){
            // complete this for counting pairs divisible by k
        }

        return count;
    }

    private static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a% b);
    }

    private static long countPairsGFG(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: arr){
            int rem = ele%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }

        long count = 0;
        // checking for remainder 0
        if(map.containsKey(0)){
            count += (long) map.get(0) * (map.get(0) - 1) / 2;
            map.remove(0);
        }

        // checking for remainder half when k is even
        if(k % 2 == 0 && map.containsKey(k / 2)){
            int halfCount = map.get(k/2);
            count += (long) halfCount * (halfCount - 1) / 2;
            map.remove(k / 2);
        }

        // multiply the count 2 times coz in answer we are dividing it by 2
        count *= 2;
        // Adding others
        for(int key: map.keySet()){
            int rem = k - key;
            if(map.containsKey(rem)) count += (long) map.get(key) * map.get(rem);
        }

        return count/2;
    }

    public static void main(String[] args) {
        int[] arrLC = {1,2,3,4,5}; // ans = 7
        int kLC = 2;

        int[] arrGFG = {61, 23,42,18,6,4,8,12,16}; // ans = 5
        int kGFG = 4;

        System.out.println("no. of pairs whose product divisible by kLC in array arLC is: "+ countPairsLC(arrLC, kLC));

        System.out.println("no. of pairs whose sum divisible by kGFG in array arGFG is: "+ countPairsGFG(arrGFG, kGFG));
    }
}
