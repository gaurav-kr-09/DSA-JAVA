package MergeSort;

import java.util.Scanner;

public class CountInversion {
    public static void display(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    static int count;
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
        count = 0;
        invp(arr);
        System.out.println("No. of reverse pair: "+ count);
    }

    /*// Brute force
    public static int invp(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i< n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]) count++;
            }
        }

        return count;
    }*/

    // Optimal Approach
    public static void invp(int[] arr){
        int n = arr.length;
        if(n <= 1) return;
        int idx = 0;

        int[] a = new int[n/2], b = new int[n-n/2];
        for(int i = 0; i < a.length; i++) a[i] = arr[idx++];
        for(int i = 0; i < b.length; i++) b[i] = arr[idx++];

        invp(a);
        invp(b);

        merge(a,b,arr);
    }

    public static void merge(int[] a, int[] b, int[] c){
        /*// Method - 1
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]) c[k++] = a[i++];
            else{
                count += (a.length - i);
                c[k++] = b[j++];
            }
        }

        while(i < a.length) c[k++] = a[i++];
        while(j < b.length) c[k++] = b[j++];*/

        // Method - 2
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]) i++;
            else{
                count += (a.length - i);
                j++;
            }
        }

        i = 0;j = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(i < a.length) c[k++] = a[i++];
        while(j < b.length) c[k++] = b[j++];
    }
}
