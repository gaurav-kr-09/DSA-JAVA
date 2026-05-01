package Array;

import java.util.Scanner;

public class AddingTwoArray2 {
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

        int size = Math.max(m, n);
        int[] ans = new int[size + 1];

        int i = m-1, j = n-1, carry = 0, k = size;

        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;

            if(i >= 0) sum += arr[i];
            if(j >= 0) sum += brr[j];

            ans[k] = sum % 10;
            carry = sum /10;
            k--;
            i--;
            j--;
        }

//        ans[k] = carry;
//
//        System.out.println("Final array:");
//        if(ans[0] == 0){
//            int[] soln = new int[size];
//            System.arraycopy(ans, 1, soln, 0, size);
//            display(soln, size);
//            return;
//        }

        display(ans, size+1);
    }
}
