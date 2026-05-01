package Strings;

import java.util.Scanner;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        StringBuilder sb = new StringBuilder(sc.nextLine());

        StringBuilder temp = new StringBuilder("");
        String ans = "";

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if(ch != ' '){
                temp.append(ch);
            }else{
                temp.reverse();
                ans += temp;
                ans+= " ";
//                temp.delete(0, sb.length());
                temp = new StringBuilder("");
            }
        }

        //Isme dikkat ye hai ki last wale k bad space nahi hai isiliye ye last wala word ulta print hi nahi hoga
        System.out.println(ans);

        temp.reverse();
        ans+= temp;
        System.out.println(ans);
    }
}