package Stacks;

import java.util.Stack;

public class ParenthesisChecker {
    public static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char top = st.peek();
                if(counterPart(top, ch)) st.pop();
                else return false;
            }
        }

        return st.isEmpty();
    }

    public static boolean counterPart(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "([]{}";
        String s = "){}";
//        String s = "([]{})";
        System.out.println(isBalanced(s));
    }
}
