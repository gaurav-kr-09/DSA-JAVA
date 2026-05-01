package Queues.STLorJCF;

import java.util.LinkedList;
import java.util.Queue;

public class CRUDAtAnyPosition {
    public static void display(Queue<Integer> q){
        int n = q.size();
        if(n == 0){
            System.out.println("Queue empty");
            return;
        }
        for(int i=0; i<n; i++){
            /* temp = q.remove();
            System.out.print(temp + " ");
            q.add(temp);*/

            System.out.print(q.peek() + " ");
            q.add(q.remove());
        }

        System.out.println();
    }

    public static void addAtIndex(Queue<Integer> q, int idx, int val){
        int n = q.size();
        if(idx < 0 || idx > n){
            System.out.println("Invalid index");
            return;
        }

        if(idx == n){
            q.add(val);
            return;
        }

        for(int i = 0; i < idx; i++){
            q.add(q.remove());
        }
        q.add(val);
        // for(int i = 0; i < n-idx; i++) // ye v kar sakte hai niche wale koi jagah
        for(int i = idx; i < n; i++){
            q.add(q.remove());
        }
    }

    public static void removeAtIndex(Queue<Integer> q, int idx){
        int n = q.size();
        if(idx < 0 || idx >= n){
            System.out.println("Invalid index");
            return;
        }

        if(n == 0){
            q.remove();
            return;
        }

        for(int i = 0; i < idx; i++){
            q.add(q.remove());
        }
        q.remove();
        // size will be now reduced by 1
        for(int i = idx; i < n-1; i++){
            q.add(q.remove());
        }
    }

    public static int peekAtIndex(Queue<Integer> q, int idx){
        int n = q.size();
        if(idx < 0 || idx >= n){
            System.out.println("Invalid index");
            return -1;
        }

        if(n == 0) return q.peek();

        for(int i = 0; i < idx; i++){
            q.add(q.remove());
        }
        int peek = q.peek();
        for(int i = idx; i < n; i++){
            q.add(q.remove());
        }
        return peek;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);
        System.out.print("Original queue is: ");
        display(q);

        System.out.println("------------------Insert Chalu---------------------");
        addAtIndex(q,3, 60);
        System.out.print("Inserted queue is: ");
        display(q);
        addAtIndex(q,-9, 60);

        addAtIndex(q,6, 70);
        System.out.print("Last index inserted queue is: ");
        display(q);

        System.out.println("\n------------------Peek Chalu---------------------");
        System.out.println("Head is: "+ peekAtIndex(q,0));
        System.out.println("Tail is: "+ peekAtIndex(q,q.size()-1));
        System.out.println("#rd index element is: "+ peekAtIndex(q, 3));

        System.out.print("Original queue is: ");
        display(q);

        System.out.println("\n------------------Remove Chalu---------------------");
        removeAtIndex(q, 0);
        System.out.println("Head removed queue is: ");
        display(q);

        removeAtIndex(q, q.size()-1);
        System.out.println("Tail removed queue is: ");
        display(q);

        removeAtIndex(q, 2);
        System.out.println("2nd idx removed queue is: ");
        display(q);

    }
}
