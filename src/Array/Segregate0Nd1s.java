package Array;

import java.util.Scanner;

public class Segregate0Nd1s {
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

//        Method 1 - Not bad but not good either.(Two pass solution)
        /*int numberOfZeroes = 0;
         for(int ele: arr){
             if(ele == 0) numberOfZeroes++;
         }

        for (int i = 0; i < numberOfZeroes; i++) {
            arr[i] = 0;
        }

        for (int i = numberOfZeroes; i < n; i++) {
            arr[i] = 1;
        }*/


//        Method 2 - Good.(One_pass solution)
        int i = 0, j = n-1;
        while(i < j){
            if(arr[i]==0) i++;
            else if(arr[j]==1) j--;
            else if(arr[i] == 1 && arr[j] == 0){
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
                arr[i] = 0;
                arr[j] = 1;
                i++;
                j--;
            }
        }


        System.out.println("Final array is:");
        display(arr, n);
    }
}
