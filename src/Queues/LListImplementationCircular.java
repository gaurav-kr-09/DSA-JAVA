package Queues;

class MyNode{
    int val;
    Queues.MyNode next;
    MyNode(int val){
        this.val = val;
    }
}

class CQueue {
    Queues.MyNode head;
    Queues.MyNode tail;
    int size;

    void add(int val){
        Queues.MyNode temp = new Queues.MyNode(val);
        if(tail == null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
        tail.next = head;
        size++;
    }

    int remove(){
        if(head == null){
            System.out.println("Invalid index");
            return -1;
        }

        int data = head.val;

        if(head == tail) head = tail = null;
        else {
            head = head.next;
            tail.next = head;
        }
        size--;
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
        System.out.print(head.val + " ");
        Queues.MyNode temp = head.next;
        while(temp != head){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LListImplementationCircular {
    public static void main(String[] args) {
        CQueue q = new CQueue();
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