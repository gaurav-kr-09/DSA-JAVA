package Stacks.Fixes.Evaluation;

import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        String str = "953+4*6/-"; // -> 4
        // 984*6/-
        // 9 32 6/-
        // 9 5 -
        // 4 Answer

        Stack<Integer> st = new Stack<>();
        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)) st.push(ch - '0');
            else{
                int v2 = st.pop();
                int v1 = st.pop();

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
