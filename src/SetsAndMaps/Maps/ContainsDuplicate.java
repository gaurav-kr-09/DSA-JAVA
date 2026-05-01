package SetsAndMaps.Maps;

import java.util.HashMap;

public class ContainsDuplicate {
    // Method 1: using hashSet
    /*private static boolean findDup(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) {
            set.add(ele);
        }
        return set.size() != arr.length;
    }*/

    // Method 2: using hashSet better
    /*private static boolean findDup(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: arr) {
            if(!set.add(ele)) return true;
        }
        return false;
    }*/


    // Method 2: using hashMap not required
    private static boolean findDup(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: arr) {
            if(map.containsKey(ele)) return true;
            map.put(ele, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4}, brr={1,2,3,1};

        System.out.println("arr -> " + findDup(arr));
        System.out.println("brr -> " + findDup(brr));
    }
}