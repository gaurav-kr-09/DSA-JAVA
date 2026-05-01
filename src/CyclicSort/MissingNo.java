package CyclicSort;

import java.util.ArrayList;
import java.util.Scanner;

public class MissingNo {
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
        ArrayList<Integer> ans = new ArrayList<>();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        missingNos(arr, ans);
        System.out.println("Missing nos. are: "+ ans);
    }

    /*// Method 1 using frequency array
    public static void missingNos(int[] arr, ArrayList<Integer> ans) {
        int n = arr.length;
        int[] freq = new int[n+1];

        for(int i=0; i < n; i++){
            freq[arr[i]] ++;
        }

        for(int i=1;i<=n;i++){
            if (freq[i]==0){
                ans.add(i);
            }
        }
    }*/

    // Method 2 using Cyclic sort
    public static void missingNos(int[] arr, ArrayList<Integer> ans) {
        int n = arr.length, i = 0;

        while(i < n){
            int index = arr[i] - 1;
            if(arr[i] == i+1 || arr[i] == arr[index]) i++;
            else{
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        for(i = 0; i< n; i++){
            if(arr[i] != i+1) ans.add(i+1);
        }
    }
}
