package Recursion;

public class LinearSearch {
    // Using global variable
    /*static int i = 0;
    public static boolean exists(int[] arr, int target){
        if(i == arr.length) return false;
        if(arr[i] == target) return true;
        i++;
        return exists(arr, target);
    }*/

    public static boolean exists(int[] arr, int target, int index){
        if(index == arr.length) return false;
        if(arr[index] == target) return true;
        return exists(arr, target, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 3, 9, 8};

        //System.out.println(exists(arr, 75));
        System.out.println(exists(arr, 5, 0));
    }
}
