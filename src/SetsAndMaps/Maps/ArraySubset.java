package SetsAndMaps.Maps;

import java.util.HashMap;

public class ArraySubset {
    private static boolean isSubset(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele: a){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        for(int ele: b){
            // if(!map.containsKey(ele)) return false;
            // int freq = map.get(ele);
            // in dono line k jagah ye v kar sakte hai
            int freq = map.getOrDefault(ele, 0);
            if(freq <= 0) return false;
            map.put(ele, freq-1);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3}, b = {11, 3, 7, 10, 7};
        System.out.println("b is a subset of a -> : "+ isSubset(a,b));
    }
}
