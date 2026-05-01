package LinkedList;

class Node{ // UserDefined data type
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

class LinkedLst{ // User Defined Data structure
    Node head; // null
    Node tail; // null

    int size; // Extra if we want to use size - default 0;

    // LinkedLst(){ // ye karne ki koi jarurat nahi hai, java me ye default hota hai.
    //     head = tail = null;
    // }

    // addAtTail - Jab tail nah pata ho - but qn k according tail ko adjust kiya hu but use nahi kya hu .
    /*void addAtTail(int x){
        Node temp = new Node(x);

        if(head == null){
            head = tail = temp;
            size++;
            return;
        }

        Node traversalNode = head;
        while(traversalNode.next != null){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = temp;
        tail = temp;
        size++;
    }*/

    // addAtTail - Jab tail pata ho
    /*void addAtTail(int x){
        Node temp = new Node(x);

        if(head == null) head = tail = temp; // or also tail == null
        else{
            tail.next = temp;
            tail = temp;
        }
        size ++;
    }*/

    // addAtTail - One more Way
    void addAtTail(int x){
        if(tail == null){
            addAtHead(x);
            return;
        }

        Node temp = new Node(x);
        tail.next = temp;
        tail = temp;
        size++;
    }

    void addAtHead(int x){
        Node temp = new Node(x);

        if(head == null) head = tail = temp;
        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void deleteAtHead(){
        if(head == null) return;
        head = head.next;
        if(head == null) tail = null;
        size--;
    }

    //deleteAtTail - Jab tail nah pata ho - but qn k according tail ko adjust kiya hu but use nahi kya hu .
    /*void deleteAtTail(){
        if(head == null) return; //Empty list

        // Only one node
        if(head.next == null){
            head = null;
            tail = null;
            size--;
            return;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size --;
    }*/

    // deleteAtTail - Jab tail pata ho
    void deleteAtTail(){
        if(head == null) return;

        //Only one node
        if(head == tail){
            head = tail = null;
            size --;
            return;
        }

        // Many nodes
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size --;
    }

    int search(int x){
        Node temp = head;
        int index = 0;
        while (temp != null){
            if(temp.val == x) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    void get(int index){
        if(index < 0 || index > size ){
            System.out.println("invalid index");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    void insert(int index, int x){
        if(index < 0 || index > size ){
            System.out.println("invalid index for insertion.");
            return;
        }

        if(index == 0){
            addAtHead(x);
            return;
        }

        if (index == size) {
            addAtTail(x);
            return;
        }

        Node temp = head;
        for (int i = 1; i <index; i++) { // i = 0, i < index - 1
            temp = temp.next;
        }
        Node newNode = new Node(x);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    void delete(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index for deletion");
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }

        if(index == size - 1){
            deleteAtTail();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        // upar wala case k jagah ye v use kar sakte hai index = size - 1 ke liye.
        /*if(index == size - 1){
            temp.next = null;
            tail = temp;
            size --;
            return;
        }*/

        temp.next = temp.next.next;
        size--;
    }

    void display(){
        if(head == null) return;

        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class LinkedListDataStr {
    public static void main(String[] args) {
        LinkedLst ll = new LinkedLst();

        ll.addAtTail(10);
        ll.addAtTail(15);
        ll.addAtTail(12);
        ll.addAtTail(36);
        ll.display();
        System.out.println(ll.size);

        ll.addAtHead(2);
        ll.addAtHead(4);
        ll.display();
        System.out.println(ll.size);

        ll.deleteAtHead();
        ll.display();
        ll.deleteAtHead();
        ll.display();
        System.out.println(ll.size);

        ll.deleteAtTail();
        ll.display();
        System.out.println(ll.size);

        ll.deleteAtTail();
        ll.display();
        System.out.println(ll.size);

        System.out.println("================= Search ===================");
        // Now the list is  -  10  15
        System.out.println(ll.search(9)); // -1;
        System.out.println(ll.search(10)); // 0
        System.out.println(ll.search(15)); // 1

        System.out.println("================= Get element at index ===================");
        ll.get(0);
        ll.get(-1);
        ll.get(1);

        System.out.println("================= Insertion at Index ===================");
        // Making the list bigger for better understanding
        ll.addAtTail(9);
        ll.addAtHead(12);
        ll.addAtHead(2);
        ll.display();
        // now th list becomes 2 12 10 15 9
        ll.insert(3, 7); // insert 7 at 3rd index
        ll.display();
        System.out.println(ll.size);

        ll.insert(0, 0); // insert 7 at 3rd index
        ll.display();
        System.out.println(ll.size);

        System.out.println("=================== Deletion at Index =====================");
        // Now Array is: 0 2 12 10 7 15 9
        ll.delete(-1); // error
        ll.delete(7);  // error

        ll.delete(0); // delete 0 -> Aray 2 12 10 7 15 9
        ll.display();
        System.out.println(ll.size);

        ll.delete(5); // delete 9 -> Array 2 12 10 7 15
        ll.display();
        System.out.println(ll.size);

        ll.delete(2); // delete 12 -> Array 2 12 7 15
        ll.display();
        System.out.println(ll.size);
    }
}