package Recursion;

import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println(count(n));
    }

    //USING STRING
    /*public static String count(int n){
        if(n == 1) return "1";

        String prevRowString = count(n-1) + "#";

        String ans  = "";

        int i = 0, j = 0;
        while(j < prevRowString.length()){
            if(prevRowString.charAt(i) == prevRowString.charAt(j)) j++;
            else{
                int freq = j - i;
                ans += freq;
                ans += prevRowString.charAt(i);
                i = j;
            }
        }

        return ans;
    }*/

    //USING STRINGBUILDER
    public static String count(int n){
        if(n == 1) return "1";

        String prevRowString = count(n-1) + "#";

        StringBuilder ans  = new StringBuilder();

        int i = 0, j = 0;
        while(j < prevRowString.length()){
            if(prevRowString.charAt(i) == prevRowString.charAt(j)) j++;
            else{
                int freq = j - i;
                ans.append(freq);
                ans.append(prevRowString.charAt(i));
                i = j;
            }
        }

        return ans.toString();
    }
}
