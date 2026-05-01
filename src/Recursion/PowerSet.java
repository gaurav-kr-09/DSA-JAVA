package Recursion;

import java.util.Scanner;

public class PowerSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();

        subsets("",str,0);
    }

    /*//unordered printing important for understanding.
    public static void subsets(String ans, String str, int i) {
        if(i == str.length()){
            System.out.print(ans+ " "); // Callback k time me value print kar dega.
            return;
        }
        char ch = str.charAt(i);

        subsets(ans+ch, str, i+1); // Pick
        subsets(ans, str, i+1); // Skip
    }*/

    public static void subsets(String ans, String str, int i){
        if(i == str.length()){
            System.out.print(ans+" ");
            return;
        }
        subsets(ans+str.charAt(i), str, i+1); //Pick
        subsets(ans, str, i+1); //Skip
    }
}
