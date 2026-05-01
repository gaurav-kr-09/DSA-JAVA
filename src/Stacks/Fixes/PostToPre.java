package Stacks.Fixes;

import java.util.Stack;

public class PostToPre {
    public static void main(String[] args) {
        String prefix = "953+4*6/-";
        // 9 +53 4*6/-
        // 9 *+534 6/-
        // 9 /*+534 -
        // -9/*+5346

        Stack<String> st = new Stack<>();
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(Character.isDigit(ch)) st.push(String.valueOf(ch));
            else{
                String v2 = st.pop();
                String v1 = st.pop();
                st.push(ch+v1+v2);
            }
        }

        System.out.println("Postfix expression is: "+ st.pop());
    }
}
