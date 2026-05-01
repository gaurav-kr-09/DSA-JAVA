package Queues;

class SelfDq {
    int size;
    int[] arr;
    int f;
    int r;
    int capacity;

    SelfDq(int cap){
        capacity = cap;
        arr = new int[cap];
        f = -1;
        r = -1;
        size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isFull(){
        return size == capacity;
    }

    void addFirst(int val){
        if(isFull()){
            System.out.println("Deque Full");
            return;
        }

        if(isEmpty()){
            f = r = 0;
        }else {
            f = (f-1+capacity) % capacity;
        }

        arr[f] = val;
        size++;
    }

    void addLast(int val){
        if(isFull()){
            System.out.println("Deque Full");
            return;
        }

        if(isEmpty()){
            f = r = 0;
        }else {
            r = (r+1) % capacity;
        }

        arr[r] = val;
        size++;
    }

    int removeFirst(){
        if(isEmpty()){
            System.out.println("Deque Full");
            return -1;
        }

        int val = arr[f];

        if(size == 1){
            f = r = -1;
        }else{
            f = (f + 1) % capacity;
        }

        size--;
        return  val;
    }

    int removeLast(){
        if(isEmpty()){
            System.out.println("Deque Full");
            return -1;
        }

        int val = arr[r];

        if(size == 1){
            f = r = -1;
        }else{
            r = (r - 1 + capacity) % capacity;
        }

        size--;
        return val;
    }

    void display(){
        if(isEmpty()){
            System.out.println("Deque Empty");
            return;
        }

        int i = f;

        for(int count = 0; count < size; count++){
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}

public class SelfDequeArray {
    public static void main(String[] args) {
        SelfDq dq = new SelfDq(5);

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