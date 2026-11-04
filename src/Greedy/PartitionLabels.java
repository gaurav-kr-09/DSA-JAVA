package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    // method 1
    /*public static List<Integer> partitionLabels(String s) {
        int n = s.length();

        // store last occurence
        int[] lo = new int[26];
        for(int i=0; i<n; i++) lo[s.charAt(i) - 'a'] = i;

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < n){
            int end = lo[s.charAt(i) - 'a'];

            int j = i+1;
            while(j < end) end = Math.max(end, lo[s.charAt(j++) - 'a']);

            ans.add(end-i+1);
            i = end + 1;
        }

        return ans;
    }*/

    // A bit cleaner but idea ditto same
    public static List<Integer> partitionLabels(String s) {
        int n = s.length();

        // store last occurence
        int[] lo = new int[26];
        for(int i=0; i<n; i++) lo[s.charAt(i) - 'a'] = i;

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int start = 0;
        int end = 0;
        while(i < n){
            end = Math.max(end, lo[s.charAt(i) - 'a']);

            if(i == end){
                ans.add(end-start+1);
                start = end + 1;
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        // [9, 7, 8]

        System.out.println(partitionLabels("eccbbbbdec"));
        // [10]

        System.out.println(partitionLabels("caedbdedda"));
        // [1, 9]
    }
}