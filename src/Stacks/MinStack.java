package Stacks;

import java.util.Stack;

public class MinStack {
    // Method 1: using two stacks
    /*Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || val < minSt.peek()) minSt.push(val);
        else minSt.push(minSt.peek());
    }

    public void pop() {
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }*/

    // Method 2: using single stack
    Stack<Long> st;
    long min;

    public MinStack(){
        st = new Stack<>();
    }

    void push(int val){
        long x = val;
        if(st.isEmpty()){
            st.push(x);
            min = x;
        }else if (x > min) st.push(x);
        else{
            st.push(2 * x - min);
            min = x;
        }
    }

    void pop(){
        long top = st.pop();
        if(top < min) min = 2 * min - top;
    }

    int top(){
        long top = st.peek();
        if(top < min) return (int) min;
        return (int)top;
    }

    int getMin(){
        return (int) min;
    }
}
