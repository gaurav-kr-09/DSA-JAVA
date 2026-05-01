package Stacks;

import java.util.Stack;

public class BasicsSTLOfStacks {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        st.push("Aam");
        st.push("ram");
        st.push("shyam");

        System.out.println(st.size());
        System.out.println(st); // Space - O(n)
        st.pop();
        System.out.println(st+ " "+st.size());
        System.out.println(st.peek());

        System.out.println(st.pop()); // returns the topmost and then removes it

        System.out.println(st.isEmpty());
    }
}
