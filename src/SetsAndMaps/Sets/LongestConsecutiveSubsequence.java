package SetsAndMaps.Sets;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    // Method 1: sor kar k subsequence dekh lo TC O(log n) req TC = O(n)
    /*private static int longestSubs(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        Arrays.sort(arr);
        int size = 0, maxSize = 0;
        for(int i = 0; i < n-1; i++){
            if(arr[i+1] - arr[i] == 1) size++;
            else if(arr[i+1] - arr[i] == 0);
            else{
                maxSize = Math.max(maxSize, size);
                size = 0;
            }
        }
        return Math.max(maxSize, size) + 1;
    }*/

    // Method 2: optimal O(n)
    private static int longestSubs(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int n: arr) set.add(n);

        int maxLen = 0;

        for(int n: set){
            if(!set.contains(n-1)){ // it can be start of new sequence
                int currSize = 1;
                int currNum = n;
                while(set.contains(currNum+1)){
                    currSize++;
                    currNum++;
                }
                maxLen = Math.max(maxLen, currSize);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        //           0 0 1 2 3 4 5 6 7 8
        // ans = 9

        System.out.println("Longest consecutive subsequence is: "+ longestSubs(arr));
    }
}
