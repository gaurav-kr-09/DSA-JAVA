package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {
    // Method 1: Brute force O(n^2)
    /*private static ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length, count = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i = 1; i < n; i++){
            int j = i-1;
            while(j >= 0 && arr[j] <= arr[i]){
                count ++;
                j--;
            }
            ans.add(count);
            count = 1;
        }
        return ans;
    }*/

    // Method 2 : using stack
//    private static ArrayList<Integer> calculateSpan(int[] arr) {
//        Stack<Pair> st = new Stack<>();
//        int n = arr.length;
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        /*// pushing dummy element for handling elements greater than first value
//        st.push(new Pair(Integer.MAX_VALUE, -1));
//
//        for(int i = 0; i < n; i++){
//            // Jab tak chhota element mile pop karte rho
//            while(!st.isEmpty() && st.peek().val <= arr[i]) st.pop();
//
//            // ab i - top ka index ans me add kar do
//            ans.add(i - (st.peek().idx));
//
//            // ab naya wala element push kar do
//            st.push(new Pair(arr[i], i));
//        }*/
//
//        // bina dummy k
//        for(int i = 0; i < n; i++){
//            // Jab tak chhota element mile pop karte rho
//            while(!st.isEmpty() && st.peek().val <= arr[i]) st.pop();
//
//            if(st.isEmpty()) ans.add(i+1);
//            else ans.add(i - st.peek().idx);
//
//            // ab naya wala element push kar do
//            st.push(new Pair(arr[i], i));
//        }
//        return ans;
//    }

    /*static class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }*/

    // Method 3: bina pair use kiye
    private static ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            // Jab tak chhota element mile pop karte rho
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();

            if(st.isEmpty()) ans.add(i+1);
            else ans.add(i - st.peek());

            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100,80,60,70,60,75,85}; // ans -> 1, 1, 1, 2, 1, 4, 6
//        int[] arr = {10,4,5,90,120,80}; // ans -> 1, 1, 2, 4, 5, 1
        ArrayList<Integer> ans = calculateSpan(arr);

        System.out.println(ans);
    }
}