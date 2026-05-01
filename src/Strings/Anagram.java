package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return  true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String s1 = sc.next();
        System.out.print("Enter the second string: ");
        String s2 = sc.next();

        System.out.println(isAnagram(s1, s2));
    }
}
