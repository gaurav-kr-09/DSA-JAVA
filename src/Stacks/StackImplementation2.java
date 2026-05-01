package Stacks;

class Node2{
    int val;
    Node2 next;
    Node2(int val){
        this .val = val;
    }
}

class MyStack2{
    int max = 5;
    Node2 head;
    int len;

    int peek() throws Exception{
        if(head == null) throw new Exception("Stack Underflow Error");
        return head.val;
    }

    int pop() throws Exception {
        if(head == null) throw new Exception("Stack Underflow Error");

        int n = head.val;
        head = head.next;
        len--;
        return n;
    }

    void push(int val) throws Exception{
        if(len >= max) throw new Exception("Stack Overflow Error");
        Node2 newNode2 = new Node2(val);
        if(len == 0) head = newNode2;
        else{
            newNode2.next = head;
            head = newNode2;
        }
        len++;
    }

    int size(){
        return len;
    }

    //Printing stack top to bottom
    void display(){
        if(head == null){
            System.out.println("Empty stack");
            return;
        }
        Node2 temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackImplementation2{
    public static void main(String[] args) throws Exception {
        MyStack2 st = new MyStack2();

        // st.pop();   // will throw stack underflow exception
        // st.peek();  // will throw stack underflow exception

        System.out.println(st.size()); // 0

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        //st.push(60); // will throw stack overflow exception

        st.display();

        st.pop();
        st.display();

        System.out.println(st.pop());

    }
}
