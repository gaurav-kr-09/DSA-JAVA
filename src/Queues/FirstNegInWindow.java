package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegInWindow {
    // BruteForce O(n*K)
    /*static List<Integer> firstNegInt(int[] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for(int i = 0; i < n-k+1; i++){
            boolean negPres = false;
            for(int j = i; j < i + k; j++){
                if(arr[j] < 0){
                    ans.add(arr[j]);
                    negPres = true;
                    break;
                }
            }
            if(!negPres) ans.add(0);
        }
        return ans;
    }*/

    // optimized O(n);
    static List<Integer> firstNegInt(int[] arr, int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) if(arr[i] < 0) q.add(i);

        for(int i = 0; i < n-k+1; i++){
            while(!q.isEmpty() && q.peek() < i) q.remove();
            if(!q.isEmpty() && q.peek() < i+k) ans.add(arr[q.peek()]);
            else ans.add(0);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28}; // -1,-1,-7,-15,-15,0
        int k = 3;

        System.out.println("First negative List is: "+ firstNegInt(arr, k));
    }
}