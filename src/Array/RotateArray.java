package Array;

import java.util.Scanner;

public class RotateArray {
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

        System.out.print("Enter No. of elements to rotate: ");
        int r = sc.nextInt();
        r %= n;

//        Method 1 - making a new Array not efficient
        /*int[] brr = new int[n];
        // copy elements from r to end
        for(int i = 0; i < n-r; i++){
            brr[i] = arr[i+r];
        }
        // copy first r elements to the end
        for (int i = n - r; i < n; i++) {
            brr[i] = arr[i - (n - r)];
        }

        System.out.println("Rotated array: ");
        display(brr, n);*/

//        Method-2 same array - efficient
        reverse(arr, n, 0, r-1);
        reverse(arr, n, r, n-1);
        reverse(arr, n, 0, n-1);

        System.out.println("Rotated array: ");
        display(arr, n);
    }

    public static void reverse(int[] arr, int n, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
