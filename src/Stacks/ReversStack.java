package Stacks;

import java.util.Stack;

public class ReversStack {
    // Normal 1: Using arrayList
    /*public static void reverse(Stack<Integer> st){
        ArrayList<Integer> temp = new ArrayList<>();
        while(!st.isEmpty()){
            temp.add(st.pop());
        }
        while(!temp.isEmpty()){
            st.push(temp.getFirst());
            temp.removeFirst();
        }
    }*/

    // Normal 2: Using 2 extra stacks
    /*public static void reverse(Stack<Integer> st){
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();

        while(!st.isEmpty()){
            temp1.push(st.pop());
        }

        while(!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }

        while(!temp2.isEmpty()){
            st.push(temp2.pop());
        }
    }*/

    // Using Recursion
    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()) return;;
        int top = st.pop();
        reverse(st);
        pushAtBottom(st, top);
    }

    public static void pushAtBottom(Stack<Integer> st, int ele){
        if(st.isEmpty()){
            st.push(ele);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, ele);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10); st.push(20); st.push(30); st.push(40); st.push(50);
        System.out.println(st);

        reverse(st);

        System.out.println(st);
    }
}
