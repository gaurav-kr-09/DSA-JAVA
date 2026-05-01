package Array;

import java.util.Scanner;

public class OddIntoTwoEvenPlusTen {
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

        for (int i = 0; i < n; i++) {
            if(i%2 == 0) arr[i] = arr[i] + 10;
            else arr[i] = 2*arr[i];
        }

        System.out.println("Result Array: ");
        display(arr, n);
    }
}
