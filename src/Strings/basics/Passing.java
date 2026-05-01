package Strings;

import java.util.Scanner;

public class Passing {
    public static void change(String x){
        x = "Prachandeshwar";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(s); // yaha s

        s = "And Gaurav";
        System.out.println(s); // And Gaurav

        //isi ko agar fn me pass kare to
        change(s);
        System.out.println(s); // And Gaurav - purana value hi print hoga
    }
}
