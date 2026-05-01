package Array.Basics;

import java.util.Arrays;

public class SortArrayBuiltIn {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 9, -9};
        System.out.println("Original Array: ");
        display(arr, arr.length);

        Arrays.sort(arr);
        System.out.println("Array After sorting: ");
        display(arr, arr.length);
    }

    public static void display(int[] arr, int n){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
