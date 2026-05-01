package Stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        int n = s.length();
        if(n < 2) return s;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(st.isEmpty()) st.push(ch);
            else{
                char top = st.peek();
                if(top == ch) st.pop();
                else st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "aaaaabbcccdaa"; //acd
//        String s = "aaaabbcccdaa"; //cd
//        String s = "ab"; //ab
//        String s = "abbaca"; //ca
        System.out.println(removeDuplicates(s));

        StringBuilder sb = new StringBuilder();
    }
}
