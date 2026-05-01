package Recursion;

public class Reverse {
    public static void display (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static  void reverse(int[] arr, int i, int j){
        if(i >= j) return;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i+1, j-1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 21, 33, 3, 5, 9, 3, 5, 9, 15, 15, 26};

        reverse(arr, 0, arr.length-1);
        display(arr);
    }
}
