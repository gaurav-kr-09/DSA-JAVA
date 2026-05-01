package Stacks;

class Node{
    int val;
    Node next;
    Node(int val){
        this .val = val;
    }
}

class MyStack{
    Node head;
    int len;

    int peek(){
        if(head == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        return head.val;
    }

    int pop(){  // Delete at head
        if(head == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        int n = head.val;
        head = head.next;
        len--;
        return n;
    }

    void push(int val){ // Add at head
        Node newNode = new Node(val);
        if(len == 0) head = newNode;
        else{
            newNode.next = head;
            head = newNode;
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
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.display();

        st.pop();
        st.display();
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}