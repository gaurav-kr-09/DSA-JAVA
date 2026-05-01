package Array.Basics;

import java.util.Arrays;

public class ShalloNDeepCopy {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] x = arr; //x is shallow copy of arr
        x[0] = 100;
        System.out.println(arr[0]);

        int[] deepCopy = Arrays.copyOf(arr, arr.length);
        System.out.println(arr[1]); //20
        System.out.println(deepCopy[1]); //20
        deepCopy[1] = 90;
        System.out.println(arr[1]); //20
        System.out.println(deepCopy[1]); //90
    }
}
