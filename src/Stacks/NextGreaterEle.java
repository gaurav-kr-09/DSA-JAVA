package Stacks;

import java.util.Stack;

public class NextGreaterEle {
    public static int[] nge(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(arr[n-1]);
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && arr[i] >= st.peek()) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,3,5,2,1,6,4}; // ans -> 8,-1,5,6,6,6,-1,-1
        int[] ans = nge(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
