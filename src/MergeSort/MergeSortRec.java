package MergeSort;

import java.util.Scanner;

public class MergeSortRec {

    public static void mergeSort(int[] arr){
        int n = arr.length;
        if(n==1) return; //! length array is already sorted
        // Step - 1 create two arrays of half size each.
        int[] a = new int[n/2], b = new int[n-n/2];

        // Step - 2 copy and paste the half - half elements in each array.
        int idx = 0;
        for(int i = 0; i < a.length; i++) a[i] = arr[idx++];
        for(int i = 0; i < b.length; i++) b[i] = arr[idx++];

        // Step - 3 recursion.
        mergeSort(a);
        mergeSort(b);

        // Step - 4
        merge(a, b, arr);
    }

    public static void merge(int[] a, int[] b, int[] arr){
        int i = 0, j = 0, idx = 0;

        while(i < a.length && j < b.length){
            if(a[i] < b[j]) arr[idx++] = a[i++];
            else arr[idx++] = b[j++];
        }

        while(i < a.length) arr[idx++] = a[i++];
        while(j < b.length) arr[idx++] = b[j++];
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
        display(arr);

        //Sort the array
        mergeSort(arr);

        System.out.println("Sorted array is: ");
        display(arr);
    }

    public static void display(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
