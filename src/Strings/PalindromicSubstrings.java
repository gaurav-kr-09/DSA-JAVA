package Strings;

import java.util.Scanner;

public class PalindromicSubstrings {
    public static boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Original string: "+s);
        int count = 0;

        for(int i = 0; i<s.length(); i++){
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(s.substring(i,j+1))){
                    System.out.println(s.substring(i,j+1));
                    count++;
                }
            }
        }

        System.out.println("No. of palindromic strings: "+ count);
    }
}
