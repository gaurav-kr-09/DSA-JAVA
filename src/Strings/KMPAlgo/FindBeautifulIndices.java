package Strings.KMPAlgo;

import java.util.ArrayList;
import java.util.List;

// leetcode 3006 and 3008 same hi hai bas constraints ka difference hai
// 3008 wala hard hai so more tight constraint
public class FindBeautifulIndices {
    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();

        List<Integer> iIdx = KMP(a, s); // already sorted
        List<Integer> jIdx = KMP(b, s); // already sorted

        List<Integer> ans = new ArrayList<>();

        for(int idx: iIdx){
            int ll = Math.max(0, idx-k); // left limit, max used to ignore -ve
            int rl = Math.min(n-1, idx+k); // right limit, min used to ignore outOfBound chars

            int lbIdx = lowerBound(jIdx, ll); // lower bound index
            if(lbIdx != -1 && jIdx.get(lbIdx) <= rl) ans.add(idx);
        }

        return ans;
    }

    public static List<Integer> KMP(String patt, String text){
        int n = text.length();
        int m = patt.length();

        int[] LPS = computeLPS(patt);

        List<Integer> foundAt = new ArrayList<>();
        int i=0;
        int j=0;
        while(i < n){
            if(text.charAt(i) == patt.charAt(j)){
                i++;
                j++;
            }

            if(j == m) { // mil gaya
                foundAt.add(i-j);
                j = LPS[j-1];
            }else if(i < n && text.charAt(i) != patt.charAt(j)){
                if(j != 0) j = LPS[j-1];
                else i++;
            }
        }

        return foundAt;
    }

    public static int[] computeLPS(String patt) {
        int m = patt.length();
        int[] LPS = new int[m];

        int len = 0;
        LPS[0] = 0;

        int i = 1;
        while (i < m){
            if(patt.charAt(i) == patt.charAt(len)){
                len++;
                LPS[i++] = len;
            }else{
                if(len != 0) len = LPS[len-1];
                else LPS[i++] = 0;
            }
        }

        return LPS;
    }

    public static int lowerBound(List<Integer> arr, int target){
        int lo=0, hi=arr.size()-1;
        int lb = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(arr.get(mid) >= target){
                lb = mid;
                hi = mid-1;
            }
            else lo = mid+1;
        }

        return lb;
    }

    public static void main(String[] args) {
        String s1 = "isawsquirrelnearmysquirrelhouseohmy";
        String a1 = "my";
        String b1 = "squirrel";
        int k1 = 15;
        System.out.println(beautifulIndices(s1, a1, b1, k1));
        // Expected: [16, 33]

        String s2 = "abcd";
        String a2 = "a";
        String b2 = "a";
        int k2 = 4;
        System.out.println(beautifulIndices(s2, a2, b2, k2));
        // Expected: [0]

        String s3 = "aaaaa";
        String a3 = "aa";
        String b3 = "a";
        int k3 = 0;
        System.out.println(beautifulIndices(s3, a3, b3, k3));
        // Expected: [0, 1, 2, 3]

        String s4 = "abcabc";
        String a4 = "abc";
        String b4 = "bc";
        int k4 = 1;
        System.out.println(beautifulIndices(s4, a4, b4, k4));
        // Expected: [0, 3]

        String s5 = "abcdef";
        String a5 = "xy";
        String b5 = "cd";
        int k5 = 3;
        System.out.println(beautifulIndices(s5, a5, b5, k5));
        // Expected: []

        String s6 = "abababab";
        String a6 = "ab";
        String b6 = "ba";
        int k6 = 1;
        System.out.println(beautifulIndices(s6, a6, b6, k6));
        // Expected: [0, 2, 4, 6]
    }
}