package Array;

import java.util.Scanner;

public class TwoSum {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.print("Enter The Target element: ");
        int t = sc.nextInt();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i+ 1; j < n; j++) {
                if((arr[i] + arr[j]) == t){
                    System.out.println("indexes are: " + i + "\t" + j);
                    flag = true;
                }
            }
        }

        if(!flag) System.out.println("No such pair");
    }
}
