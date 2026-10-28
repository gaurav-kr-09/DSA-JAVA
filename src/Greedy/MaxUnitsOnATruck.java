package Greedy;

import java.util.Arrays;

public class MaxUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1])); // max units wala pahle

        int maxUnits = 0; // ans
        /*for(int[] box: boxTypes){
            // max acceptable unit -> if tSize > box[0]to box[0] else
            // jo bacha hua truck ka size hoga ulna hi le sakte hai
            // in dono ko combine karke aise v likh sakte hai
            int mau = Math.min(box[0], truckSize);

            maxUnits += (box[1] * mau);
            truckSize -= mau;

            if(truckSize == 0) return maxUnits;
        }*/

        // isko aise v bana sakte hai same hi bat rahega
        for(int[] box: boxTypes){
            if(box[0] <= truckSize){
                maxUnits += (box[0] * box[1]);
                truckSize -= box[0];
            }else{
                maxUnits += (truckSize * box[1]);
                return maxUnits;
            }
        }

        return maxUnits;
    }

    public static void main(String[] args) {
        int[][] boxTypes1 = {
                {1, 3},
                {2, 2},
                {3, 1}
        };
        System.out.println(maximumUnits(boxTypes1, 4));
        // Expected: 8

        int[][] boxTypes2 = {
                {5, 10},
                {2, 5},
                {4, 7},
                {3, 9}
        };
        System.out.println(maximumUnits(boxTypes2, 10));
        // Expected: 91

        int[][] boxTypes3 = {
                {1, 100}
        };
        System.out.println(maximumUnits(boxTypes3, 1));
        // Expected: 100

        int[][] boxTypes4 = {
                {2, 4},
                {3, 3},
                {1, 2}
        };
        System.out.println(maximumUnits(boxTypes4, 3));
        // Expected: 11
    }
}