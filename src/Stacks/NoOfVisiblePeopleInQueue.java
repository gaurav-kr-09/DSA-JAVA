package Stacks;

import java.util.Stack;

public class NoOfVisiblePeopleInQueue {
    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(heights[n-1]);
        int[] ans = new int[n];

        for(int i = n-2; i >= 0; i--){
            int count = 0;
            while(!st.isEmpty() && heights[i] >= st.peek()){
                count++;
                st.pop();
            }
            // agar aage us se bada element na ho to to stack khali ho jayega tab to count sahi aayega
            // but agar aage ekbada element mil gaya to wo usko v dekhega isiliye
            if(!st.isEmpty()) count++;
            ans[i] = count;
            st.push(heights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {10,6,8,5,11,9}; // ans -> 3,1,2,1,1,0
//        int[] heights = {5,1,2,3,10}; // ans -> 4,1,1,1,0

        int[] ans =canSeePersonsCount(heights);

        System.out.print("The answer is: ");
        for(int i: ans) System.out.print(i + " ");
    }
}
