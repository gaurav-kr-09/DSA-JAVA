package Queues;

import java.util.LinkedList;
import java.util.Queue;

// aka Josephus problem
public class WinnerOfCircularGame {
    // using queue
    private static int findWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.add(i);

        while (q.size() > 1){
            // remove k-1 elements
            for(int i = 1; i <= k-1; i++) q.add(q.remove());

            // remove kth element
            q.remove();
        }

        return q.remove();
    }
    public static void main(String[] args) {
        System.out.println("The winner is: "+findWinner(5,2)); //3
        System.out.println("The winner is: "+findWinner(6,5)); //1
    }
}
