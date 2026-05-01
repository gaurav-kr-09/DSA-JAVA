package MergeSort;

import java.util.Scanner;

public class ReversePairLC493 {
    public static void display(int[] arr) {
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    static int count = 0;
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

        invp(arr);
        System.out.println("No. of reverse pair: "+ count);
    }

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
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] > 2 * b[j]){
                count += (a.length - i);
                j++;
            }else i++;
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
