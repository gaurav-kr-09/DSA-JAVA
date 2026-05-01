package Array.Basics;

import java.util.Scanner;

public class OutputInArrray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Method 1
//        int[] arr = new int[5];
//        System.out.println("Enter array elements: ");
//        for (int i = 0; i < 5; i++) {
//            int x = sc.nextInt();
//            arr[i] = x;
//        }

        //Method 2
//        int[] arr = new int[5];
//        System.out.println("Enter array elements: ");
//        for (int i = 0; i < 5; i++) {
//            arr[i] = sc.nextInt();
//        }

        //Best Method
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        System.out.println("Enter array elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Printing
        System.out.println("Array Elements are: ");

//        for (int i = 0; i < 5; i++) {
//            System.out.print(arr[i] + "\t");
//        }

        for(int i : arr){
            System.out.print(i + "\t");
        }
    }
}
