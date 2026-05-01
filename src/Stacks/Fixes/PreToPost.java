package Stacks.Fixes;

import java.util.Stack;

public class PreToPost {
    public static void main(String[] args) {
        String prefix = "-9/*+5346";
        // -9/* 53+ 46
        // -9/ 53+4* 6
        // -953+4*6/
        // 953+4*6/-

        Stack<String> st = new Stack<>();
        for(int i = prefix.length() - 1; i >= 0; i--){
            char ch = prefix.charAt(i);
            if(Character.isDigit(ch)) st.push(String.valueOf(ch));
            else{
                String v1 = st.pop();
                String v2 = st.pop();
                st.push(v1+v2+ch);
            }
        }

        System.out.println("Postfix expression is: "+ st.pop());
    }
}
