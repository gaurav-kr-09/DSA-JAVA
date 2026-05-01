package Stacks;

import java.util.Stack;

public class BaseballGame {
    private static int calPoints(String[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            String s = arr[i];
            if(s.equals("C")) st.pop();
            else if(s.equals("D")) st.push(st.peek() * 2);
            else if(s.equals("+")){
                // int top1 = st.peek();
                // int top2 = st.get(st.size() - 2);

                int top1 = st.pop();
                int top2 = st.peek();
                st.push(top1);

                st.push(top1+top2);
            }
            else st.push(Integer.parseInt(s));
        }

        int sum = 0;
        while(!st.isEmpty()) sum += st.pop();
        return sum;
    }

    public static void main(String[] args) {
        String[] arr = {"5","-2","4","C","D","9","+","+"}; //27
//        String[] arr = {"5","2","C","D","+"}; //30

        System.out.println("Total point is: "+ calPoints(arr));
    }
}
