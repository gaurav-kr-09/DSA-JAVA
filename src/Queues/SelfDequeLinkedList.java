package Queues;

class LNode{
    int val;
    LNode next;
    LNode prev;
    LNode(int val){
        this.val = val;
    }
}

class selfLdq{
    int size;
    LNode f;
    LNode r;

    boolean isEmpty(){
        return size == 0;
    }

    void addFirst(int val){
        LNode temp = new LNode(val);

        if(isEmpty()) f = r = temp;
        else{
            temp.next = f;
            f.prev = temp;
            f = temp;
        }
        size++;
    }

    void addLast(int val){
        LNode temp = new LNode(val);

        if(isEmpty()) f = r = temp;
        else{
            r.next = temp;
            temp.prev = r;
            r = temp;
        }
        size++;
    }

    int removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque Empty");
            return -1;
        }

        int val = f.val;
        if(size == 1) f = r = null;
        else{
            f = f.next;
            f.prev = null;
        }
        size--;
        return val;
    }

    int removeLast() {
        if (isEmpty()) {
            System.out.println("Deque Empty");
            return -1;
        }

        int val = r.val;
        if(size == 1) f = r = null;
        else{
            r = r.prev;
            r.next = null;
        }
        size--;
        return val;
    }

    void display(){
        if(isEmpty()){
            System.out.println("Deque Empty");
            return;
        }

        LNode temp = f;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class SelfDequeLinkedList {
    public static void main(String[] args) {
        selfLdq dq = new selfLdq();

        dq.addLast(10);
        dq.addLast(20);
        dq.addFirst(5);

        dq.display(); //5 10 20

        System.out.println(dq.removeFirst());
        dq.display();

        dq.addLast(30);
        dq.addFirst(2);

        dq.display();

        System.out.println(dq.removeLast());
        dq.display();
    }
}