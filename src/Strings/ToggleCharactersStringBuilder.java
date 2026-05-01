package Strings;

import java.util.Scanner;

public class ToggleCharactersStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        System.out.println("Original string: "+sb);

        for(int i = 0; i < sb.length(); i++){
            int asciChar = (int)sb.charAt(i);
            if(asciChar >= 97 && asciChar <= 122) sb.setCharAt(i, (char)(asciChar - 32));
            else if(asciChar >= 65 && asciChar <= 90) sb.setCharAt(i, (char) (asciChar + 32));
            else continue;
        }

        System.out.println("Toggled string: "+sb);
    }
}
