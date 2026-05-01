package Stacks.Fixes.Evaluation;

import java.util.Stack;

public class Prefix {
    public static void main(String[] args) {
        String str = "-9/*+5346"; // -> 9
        // -9/*846
        // -9/ 32 6
        // -95
        // 9 - 5 = 4 Answer

        Stack<Integer> st = new Stack<>();
        for(int i = str.length()-1; i >= 0; i--){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) st.push(ch - '0');
            else{
                int v1 = st.pop();
                int v2 = st.pop();

                switch (ch){
                    case '+': st.push(v1+v2); break;
                    case '-': st.push(v1-v2); break;
                    case '*': st.push(v1*v2); break;
                    default: st.push(v1/v2);
                }
            }
        }

        System.out.println("Answer is: "+ st.pop());
    }
}
