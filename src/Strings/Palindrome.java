package Strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int i = 0, j = s.length() - 1;
        boolean isPal = true;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                isPal = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(isPal);
    }

    public static class StringToCharArray {
        public static void main(String[] args) {
            String s = "gaurav";

            char[] arr = s.toCharArray(); // Yaha pe string character k array me convert hio gaya
            // ,isiliye isme array ka sara operation jaise ki foreach loop kam karega.
            for(char ch: arr){
                System.out.println(ch);
            }
        }
    }
}
