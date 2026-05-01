package Strings;

import java.util.Scanner;

public class Baiscs {
    public static void main(String[] args) {

//        Strings are character arrays.

//        char[] arr = {'g', 'a', 'u', 'r', 'a', 'v'};
//
//        for(char ele: arr){
//            System.out.print(ele + "\t");
//        }

//        String s = "Ram is a good guy";
//        System.out.println(s);

//        Taking Input
        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        System.out.println(s);
//        String t = sc.nextLine();
//        System.out.println(t);

        //CharAt() and length()
        String s = sc.nextLine();
        System.out.println(s.length());
        System.out.println(s.charAt(2));


    }
}
