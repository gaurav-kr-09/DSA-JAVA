package Stacks;

import java.util.Stack;

public class RemoveConsecutiveChars {
    // Method 1: sliding window
    /*public static String removeConsecutive(String s) {
        s += '#';
        int n = s.length();
        System.out.println(s);
        String ans = "";

        int i = 0, j = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(j)) i++;
            else{
                ans += s.charAt(j);
                j = i;
                i++;
            }
        }

        return ans;
    }*/

    // Method 2 : similar to 1 but only using a single pointer
    /*public static String removeConsecutive(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)) ans.append(s.charAt(i));
        }

        return ans.toString();
    }*/

    // Method 3 : Using stacks (Not required)
    public static String removeConsecutive(String s) {
        int n = s.length();
        if(n < 2) return s;

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(st.isEmpty()) st.push(ch);
            else{
                char top = st.peek();
                if(ch == top) continue;
                else st.push(ch);
            }
        }

        // reversing the stack
        Stack<Character> st2 = new Stack<>();
        while(!st.isEmpty()) st2.push(st.pop());

        String ans = "";
        while(!st2.isEmpty()){
            ans += st2.pop();
        }
        // ya direct stringbuilder leke usko v reverse kar sakte hai
        return ans;
    }

    public static void main(String[] args) {
//        String s = "aaaabbcccdaa"; //abcda
//        String s = "ab"; //ab
        String s = "abbaca"; //abaca
        System.out.println(removeConsecutive(s));
    }
}