package Array.MissingQns;

import java.util.Arrays;

public class LongestCommonPrefixLC14 {
    // Optimal -> TC nlog(n) * m (n length of string m. shortest string length
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();

        Arrays.sort(strs);
        String first = strs[0], last=strs[strs.length-1];

        int i=0;
        while (i < first.length() && i < last.length()){
            char fChar = first.charAt(i);
            if(fChar == last.charAt(i)) ans.append(fChar);
            else break;
            i++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"}; // "fl"
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"dog","racecar","car"}; // ""
        System.out.println(longestCommonPrefix(strs2));
    }
}
