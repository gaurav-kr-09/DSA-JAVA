package Strings;

import java.util.Scanner;

public class ToggleCharsString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++){
            int asciChar = str.charAt(i);
            if(asciChar >= 97 && asciChar <= 122) str = str.substring(0, i) + (char)(asciChar - 32) + str.substring(i+1);
            else if(asciChar >= 65 && asciChar <= 90) str = str.substring(0, i) + (char)(asciChar + 32) + str.substring(i+1);
            else continue;
        }

        System.out.println(str);
    }
}
