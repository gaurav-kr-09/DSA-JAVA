package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsInString {
    // Method 1
    /*public static void printPermutations(String str, String t, List<String> l){
        if(str.equals("")){
            l.add(t);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            String rem = left + right;
            printPermutations(rem, t+ch, l);
        }
    }*/

    // Method 2
    /*public static void printPermutations(StringBuilder str, StringBuilder sb, List<String> l){
        if(str.isEmpty()){
            l.add(sb.toString());
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            str.deleteCharAt(i);
            printPermutations(str, sb.append(ch), l);
            sb.deleteCharAt(sb.length() - 1);
            str.insert(i, ch);
        }
    }*/

    // Method 3
    public static void printPermutations(StringBuilder str, int idx, List<String> l){
        if(idx == str.length() - 1){
            l.add(str.toString());
            return;
        }

        for(int i=idx; i<str.length(); i++){
            swap(i, idx, str);
            printPermutations(str, idx+1, l);
            swap(i, idx, str);
        }
    }

    private static void swap(int i, int idx, StringBuilder str){
        char ch = str.charAt(i);
        str.setCharAt(i, str.charAt(idx));
        str.setCharAt(idx, ch);
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> l = new ArrayList<>();

        // printPermutations(str, "", l); // Method 1

        // StringBuilder sb = new StringBuilder(str);
        // printPermutations(sb, new StringBuilder(), l); // Method 2

        StringBuilder sb = new StringBuilder(str);
        printPermutations(sb, 0, l); // Method 3
        System.out.println(l);
    }
}