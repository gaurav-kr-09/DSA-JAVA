package BinarySearch;

import java.util.Scanner;

public class KthMissingPositiveNo {
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

        System.out.print("Enter K: ");
        int k = sc.nextInt();

//        Method 1 using brute force
        /*int missing = 0, correctNumber = 1, i = 0;

        while(missing < k && i < n){
            if(arr[i] == correctNumber){
                i++;
            }else{
                missing++;
            }
            correctNumber++;
        }

        while(missing < k){
            correctNumber++;
            missing++;
        }

        System.out.println(correctNumber - 1);*/

//        Method -2 Optimized approach
        int low = 0, high = n - 1;
           while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if(missing < k) low = mid + 1;
            else high = mid - 1;
        }

        System.out.println(low + k);
    }
}
