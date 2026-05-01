package Queues;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

class MyQueue {
    Node head;
    Node tail;
    int size;

    void add(int val){
        Node temp = new Node(val);
        if(tail == null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    int remove(){
        if(head == null){
            System.out.println("Invalid index");
            return -1;
        }
        int data = head.val;

        // Niche wala nahi denge fir v kam chalega
        /*if(head.next == null){
            head = tail = null;
            return data;
        }*/

        head = head.next;
        return data;
    }

    int peek(){
        if(head == null){
            System.out.println("Invalid index");
            return -1;
        }
        return head.val;
    }

    void display(){
        if(head == null){
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListImplementation {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        System.out.print("Queue is: ");
        q.display();

        System.out.println("Removed element is: "+ q.remove());
        System.out.println("peek is: "+ q.peek());

        q.add(10);
        System.out.print("Queue is: ");
        q.display();
        System.out.println("peek is: "+ q.peek());
        System.out.println("Removed element is: "+ q.remove());
        System.out.print("Queue is: ");
        q.display();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.print("Queue is: ");
        q.display();

        System.out.println("peek is: "+ q.peek());
        System.out.println("Removed element is: "+ q.remove());

        System.out.print("Queue is: ");
        q.display();
    }
}