package Stacks;

import java.util.Stack;

public class LargestRectInHistogram {
    // Brute Force TC O(n^2) will give TLE error
    /*public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int maxArea = -1;
        // sabhi element ko bari bari se dekho jab tak uske aage pichhe usse jyada ya
        // barabar height ka stick ho to aage and pichhe bad k count karo  and then
        // dekh lo  ki uska area max hai ya nahi and that will be answer
        for(int i = 0; i < n; i++){
            int count = 1;
            int pre = i-1, fwd = i+1;
            while(pre >= 0 && arr[pre] >= arr[i]){
                count++;
                pre--;
            }

            while(fwd <= n-1 && arr[fwd] >= arr[i]){
                count++;
                fwd++;
            }

            maxArea = Math.max(maxArea, arr[i] * count);
        }

        return maxArea;
    }*/

    // Using Stack
    /*public static int largestRectangleArea(int[] arr) {
        int n = arr.length;

        //finding next smaller element indices
        int[] nse = new int[n];
        nse[n-1] = n; // -1 hota but calculation asan karne k liye n-1+1 th index
        Stack<Integer> st = new Stack<>();
        st.push(n-1); // Putting last index in stack
        for(int i = n-2; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }

        // making the stack empty for pse
        while(!st.isEmpty()) st.pop();

        // Finding previous smaller element indices
        int[] pse = new int[n];
        pse[0] = -1;
        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        // Final calulation
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int area = arr[i] * (nse[i] - pse[i] -1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }*/

    // Using Stack - Optimized
    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int index = st.pop();
                if(!st.isEmpty()) maxArea = Math.max(maxArea, arr[index] * (i - st.peek() - 1));
                else maxArea = Math.max(maxArea, arr[index] * i);
            }
            st.push(i);
        }

        // Agar stack me element bach gaya
        while(!st.isEmpty()){
            int index = st.pop();

            if(!st.isEmpty()) maxArea = Math.max(maxArea, arr[index] * (n - st.peek() -1));
            else maxArea = Math.max(maxArea, arr[index] * n);
        }

        return maxArea;
    }

    public static void main(String[] args) {
//        int[] arr = { 2, 1, 5, 6, 2, 3 }; // Ans -> 10
        int[] arr = { 2, 4 }; // Ans -> 4;

        System.out.println("Largest area is: "+ largestRectangleArea(arr));
    }
}