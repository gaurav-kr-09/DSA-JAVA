package Strings;

import java.util.Scanner;

public class FirstUniqueChar {

    //Method - 1 using frequency array
    public static char nonRepeatingChar(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int index = ch-'a';
            freq[index] ++;
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int index = ch-97;

            if(freq[index] == 1){
                return ch;
            }
        }

        return '$';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.next();

        System.out.println(nonRepeatingChar(s));
    }
}
