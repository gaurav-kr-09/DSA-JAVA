package Array;

import java.util.Scanner;

public class MergeTwoSortedArrays {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void scan(int[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + n + " elements in array (Sorted Order): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array 1: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        scan(arr, m);

        System.out.print("Enter The Size of array 2: ");
        int n = sc.nextInt();
        int[] brr = new int[n];
        scan(brr, n);

        System.out.println("Original Array 1: ");
        display(arr, m);

        System.out.println("Original Array 2: ");
        display(brr, n);

        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(arr[i] >= brr[j]){
                res[k++] = brr[j++];
            }else{
                res[k++] = arr[i++];
            }
        }

        while(j < n){
            res[k++] = brr[j++];
        }

        while(i < m){
            res[k++] = arr[i++];
        }

        System.out.println("Sorted Array:");
        display(res, m+n);
    }
}
