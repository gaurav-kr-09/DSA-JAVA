package BasicSorting;

import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void scan(int[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + n + " elements in array: ");
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

        System.out.println("The ans is:");

        //Normal method bruteforce worst
        /*for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i] == brr[j]){
                    System.out.print(arr[i] + " ");
                    break;
                }
            }
        }*/

        //Optimized method
        Arrays.sort(arr);
        Arrays.sort(brr);
        int i = 0, j = 0;
        while(i < m && j < n){
            if(arr[i] == brr[j]){
                System.out.print(arr[i] + " ");
                i++;
                j++;
            }else if(arr[i] > brr[j]) j++;
            else i++;
        }
    }
}
