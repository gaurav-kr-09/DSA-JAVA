package Recursion;

import java.util.ArrayList;

public class SumOfSubsets {
    public static void subsets(int tempSum, ArrayList<Integer> ans, int i, int[] arr){
        if(i == arr.length){
            System.out.print(tempSum+" ");
            return;
        }

        subsets(tempSum+arr[i], ans, i+1, arr); //pick
        subsets(tempSum, ans, i+1, arr);                //Skip
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};

        ArrayList<Integer> ans = new ArrayList<>();
        subsets(0, ans, 0, arr);
    }
}
