package SetsAndMaps.Sets;

import java.util.ArrayList;
import java.util.HashSet;

public class MissingElemInRange {
    private static ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr){
            set.add(ele);
        }

        for(int i = low; i <= high; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 11, 51, 15};
        int low = 50;
        int high = 55; // ANS -> [50, 52, 53, 54, 55]
        System.out.println("Missing elements in array in range (" + low + "," + high + ") is: "+ missingRange(arr, low, high));
    }
}