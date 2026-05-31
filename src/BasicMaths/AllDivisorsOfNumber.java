package BasicMaths;

import java.util.ArrayList;
import java.util.List;

public class AllDivisorsOfNumber {
    // method 1: unsorted
    /*private static void printDivisors(int n){
        for(int i=1; i*i <= n; i++){
            if(n % i == 0){
                int sec = n / i;
                System.out.print(i + " ");
                if(i != sec) System.out.print(sec + " ");
            }
        }
        System.out.println();
    }*/

    // method 2: sorted
    private static void printDivisors(int n){
        List<Integer> ls = new ArrayList<>();

        for(int i=1; i*i <= n; i++){
            if(n % i == 0){
                int sec = n / i;
                System.out.print(i + " ");
                if(i != sec) ls.add(sec);
            }
        }

        for(int i=ls.size()-1; i >= 0; i--){
            System.out.print(ls.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        printDivisors(4);
        printDivisors(13);
        printDivisors(36);
        printDivisors(1);
    }
}
