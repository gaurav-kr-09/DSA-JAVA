package CyclicSort;

import java.util.Scanner;

public class CyclicSorting {
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
        System.out.println("Enter " + n + " elements in array (a/c to question): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        sort(arr);
        System.out.println("Sorted array Array: ");
        display(arr, n);
    }

    public static void sort(int[] arr){
        int n = arr.length;

        int i = 0;
        while(i < n){
            if(arr[i] == i) i++;
            else{
                int index = arr[i];

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}