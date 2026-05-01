package CyclicSort;

import java.util.Scanner;

public class SetMismatchLC645 {
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
        int[] ans = new int[2];

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array(a/c to question): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        missingNos(arr, ans);
        System.out.println("[duplicate no, missing no] : "+ ans[0] + " , " + ans[1]);
    }

    public static void missingNos(int[] arr,int[] ans) {
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
            if(arr[i] != i+1){
                ans[0] = arr[i];
                ans[1] = i+1;
                break;
            }
        }
    }
}
