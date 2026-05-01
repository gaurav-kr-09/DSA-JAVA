package Array;

import java.util.Scanner;

public class AddingTwoArray {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    public static void scan(int[] arr, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array 1: ");
        int n = sc.nextInt();
        System.out.print("Enter The Size of array 2: ");
        int p = sc.nextInt();

        int[] arr = new int[n];
        int[] brr = new int[p];
        System.out.println("Enter " + n + " elements in array 1: ");
        scan(arr, n);
        System.out.println("Enter " + p + " elements in array 2: ");
        scan(brr, p);

        System.out.println("Original Array 1: ");
        display(arr, n);

        System.out.println("Original Array 2: ");
        display(brr, p);

        int size = Math.max(n, p);
        int[] soln = new int[size];

        int i = n-1, j = p-1, k = size - 1, carry = 0;

        while(i >= 0 || j >=0 ){
            int sum = carry;
            if(i >= 0) {
                sum += arr[i];
                i--;
            }
            if(j >= 0) {
                sum += brr[j];
                j--;
            }

            soln[k] = sum % 10;
            k--;
            carry = sum / 10;
        }

        if (carry == 1){
            int[] ans = new int[n+1];
            ans[0] = 1;
            for(int x = 1; x <= n; x++){
                ans[x] = soln[x-1];
            }
            System.out.println("Resulting array is: ");
            display(ans, n+1);
        }else{
            System.out.println("Resulting array is: ");
            display(soln, n);
        }
    }

}
