package Stacks.Fixes;

import java.util.Stack;

public class PostToIn {
    public static void main(String[] args) {
        String post = "953+4*6/-";
        // 9 (5+3) 4*6/-
        // 9 ((5+3)*4) 6/-
        // 9 (((5+3)*4)/6) -
        // (9-(((5+3)*4)/6))

        Stack<String> st = new Stack<>();

        for(int i = 0; i < post.length(); i++){
            char ch = post.charAt(i);
            if(Character.isDigit(ch)) st.push(String.valueOf(ch));
            else{
                String v2 = st.pop();
                String v1 = st.pop();
                st.push("(" + v1 + ch + v2 + ")");
            }
        }

        System.out.println("Infix expression is: "+ st.pop());
    }
}
