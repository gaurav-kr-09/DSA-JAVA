package Array;

import java.util.Scanner;

public class ReverseArray {
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

        System.out.println("Reversed array is: ");
//        for (int i = n-1; i >= 0; i--) {  //Isme naya copy ban ja rha hai so not good usi array me karna hai
//            System.out.print(arr[i] + "\t");
//        }

        int i = 0, j = n-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            j--;
            i++;
        }

//        for (int i = 0; i<n/2; i++) {
//            int temp = arr[i];
//            arr[i] = arr[n-i-1];
//            arr[n-1-i] = temp;
//        }
        display(arr, n);
    }
}
