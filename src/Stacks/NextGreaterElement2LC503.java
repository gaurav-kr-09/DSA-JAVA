package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2LC503 {
    // Method 1: pahle hi stack me push kar lo
    /*public static int[] nge(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        // pushing all elements in the stack
        for(int i = n-1; i >= 0; i--) st.push(arr[i]);

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] >= st.peek()) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(arr[i]);
        }

        return ans;
    }*/

    // Method 2: array ka size doguna kar diye
    public static int[] nge(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--){
            int num = arr[i % n];
            while(!st.isEmpty() && num >= st.peek()) st.pop();
            if(!st.isEmpty() && i < n) ans[i] = st.peek();

            st.push(num);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3}; // 2 3 4 -1 4
//        int[] arr = {1,2,1}; //2 -1 2

        int[] ans = nge(arr);
        for(int i: ans) System.out.print(i + " ");
    }
}
