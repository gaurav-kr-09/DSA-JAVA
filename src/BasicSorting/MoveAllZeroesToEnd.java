package BasicSorting;

import java.util.Scanner;

public class MoveAllZeroesToEnd {
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

//        for(int i = 0; i < n-1; i++){
//            for(int j = 0; j < n-1-i; j++){
//                if(arr[j] == 0){
//                    arr[j] = arr[j+1];
//                    arr[j+1] = 0;
//                }
//            }
//        }

        //Better
        int j = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                if(i != j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }

        System.out.println("Required Array: ");
        display(arr, n);
    }
}
