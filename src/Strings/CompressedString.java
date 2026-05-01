package Strings;

import java.util.Scanner;

public class CompressedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.nextLine();

        StringBuilder res = new StringBuilder();
        res.append(str.charAt(0));
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i -1);

            if(curr == prev){
                count ++;
            }else{
                if(count > 1) res.append(count);
                count = 1;
                res.append(curr);
            }
        }

        if(count > 1) res.append(count);
        System.out.println(res);
    }
}
