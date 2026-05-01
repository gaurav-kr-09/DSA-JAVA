package Strings;

import java.util.Scanner;

public class SelfMadeCompareTo {
    public static int CompareTo(String a, String b){
        int i = 0, j = 0;
        boolean isSame = true;

        while(i < a.length() && j<b.length()){
            if(a.charAt(i) != b.charAt(j)){
                return (int)a.charAt(i) - (int)b.charAt(j);
            }
            i++;
            j++;
        }


        return a.length() - b.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st string: ");
        String a = sc.nextLine();
        System.out.print("Enter 2nd string: ");
        String b = sc.nextLine();

        System.out.println(CompareTo(a, b));
    }
}
