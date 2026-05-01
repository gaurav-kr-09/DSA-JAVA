package BasicSorting;

import java.util.Arrays;
import java.util.Scanner;

public class PairWithGivenSum {
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
        System.out.println("Enter target sum ");
        int target = sc.nextInt();

        //Method 1 brute force
        /*for(int i = 0; i <n; i++){
            for(int j = i+1; j< n; j++){
                if(arr[i] + arr[j] == target){
                    System.out.println(i + "  " + j);
                    System.out.println(arr[i]+ "  " + arr[j]);
                }
            }
        }*/

        //Method 2 using sorting
        Arrays.sort(arr);

        int i = 0, j = n-1;
        while(i < j){
            if(arr[i] + arr[j] == target){
                System.out.println(i + " " + j);
                System.out.println(arr[i] + " " + arr[j]);
                j--;
                i++;
            }else if(arr[i] + arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
    }
}
