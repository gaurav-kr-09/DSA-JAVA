package Stacks;

import java.util.Stack;

public class SlidingWindowMaximum {
    // Method -1 brute force TC O(n*K)
    /*private static int[] maxInWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];

        for(int i = 0; i < n-k+1; i++){
            int max = Integer.MIN_VALUE;
            for (int j = i; j <i+k; j++) {
                max = Math.max(max, arr[j]);
            }
            ans[i] = max;
        }

        return ans;
    }*/

    // Method -2 optimal TC O(n*K)
    private static int[] maxInWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];

        // Finding next greater element's index
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]) st.pop();
            if(st.isEmpty()) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i);
        }

        // finding maximum in window
        /*int j = 0;
        for(int i = 0; i < n-k+1; i++){
            if(j > i+k) j = i;
            int max = arr[j];
            while(j < i+k){
                max = arr[j];
                j = nge[j];
            }
            ans[i] = max;
        }*/

        // Slightly optimized
        int j = 0;
        for(int i = 0; i < n-k+1; i++){
            if(j > i+k) j = i;
            while(j < i+k) j = nge[j];
            ans[i] = arr[j];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        for(int n: maxInWindow(arr, k)){
            System.out.print(n+ " ");
        }
    }
}