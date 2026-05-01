package Strings;

import java.util.Scanner;

public class ReverseTheSentanceButNotWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        StringBuilder sb = new StringBuilder(sc.nextLine());

        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i = sb.length() - 1; i >= 0; i--){
            char ch = sb.charAt(i);

            if(ch != ' '){
                temp.append(ch);
            }else if(!temp.isEmpty()){
                res.append(temp.reverse());
                res.append(' ');
                temp.setLength(0);
            }
        }

        if (temp.length() > 0) res.append(temp.reverse());

        System.out.println(res.toString().trim());
    }
}
