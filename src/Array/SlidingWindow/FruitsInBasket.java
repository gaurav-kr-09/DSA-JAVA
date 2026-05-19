package Array.SlidingWindow;

import java.util.HashMap;

public class FruitsInBasket {
    // BruteForce
    /*public static int totalFruit(int[] fruits) {
        int n = fruits.length, maxFruits=0;
        for(int i=0; i<n; i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i; j<n; j++){
                hs.add(fruits[j]);
                if(hs.size() > 2) break;
                maxFruits = Math.max(maxFruits, j-i+1);
            }
        }

        return maxFruits;
    }*/

    // Optimal using hashmap
    public static int totalFruit(int[] fruits) {
        int n = fruits.length, maxFruits=0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        int i=0, j=0;
        while (j < n){
            freq.put(fruits[j], freq.getOrDefault(fruits[j], 0)+1);

            /*while (freq.size() > 2){
                int currFreq = freq.get(fruits[i]);
                if(currFreq-1 == 0) freq.remove(fruits[i]);
                else freq.put(fruits[i], currFreq-1);
                i++;
            }*/

            // OR

            if(freq.size() > 2){
                int currFreq = freq.get(fruits[i]);
                if(currFreq-1 == 0) freq.remove(fruits[i]);
                else freq.put(fruits[i], currFreq-1);
                i++;
            }

            maxFruits = Math.max(maxFruits, j-i+1);
            j++;
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4}; // ans = 5 -> 1,2,1,1,2
        System.out.println("Max fruits in two basket is: " + totalFruit(fruits));
    }
}