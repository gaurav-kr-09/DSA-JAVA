package BasicSorting;

import java.util.ArrayList;
import java.util.Scanner;


// Yenahi ban pa rha hai isko bad me banayenge
public class UnionOfSortedArray {
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

        ArrayList<Integer> crr = new ArrayList<>();
        int i = 0, j = 0;

        while(i < arr.length && j < brr.length){
            if(arr[i] == brr[j]){
                if (crr.isEmpty() || crr.getLast() != arr[i]) {
                    crr.add(arr[i]);
                }
                i++;
                j++;
            }else if (arr[i] > brr[j]){
                if(crr.isEmpty() || crr.getLast() != brr[j]){
                    crr.add(brr[j]);
                    j++;
                }
            }else{
                if(crr.isEmpty() || crr.getLast() != arr[i]){
                    crr.add(arr[i]);
                    i++;
                }
            }
        }

        while(i < arr.length){
            crr.add(arr[i]);
            i++;
        }


        while(j < brr.length){
            crr.add(brr[j]);
            j++;
        }

        System.out.println("The ans is:");
        System.out.println(crr);
    }
}
