package Strings;

public class Equals {
    public static void main(String[] args) {
        String s1 = "Gaurav";
        String s2 = "Gaurav";
        System.out.println(s1 == s2); //True coz they point to same memory address.

        String s3 = new String("Gaurav");
        String s4 = new String("Gaurav");

        System.out.println(s3 == s4); //false dega due to different memory address.
        System.out.println(s3.charAt(0) == s4.charAt(0)); // true dega
        System.out.println(s3.equals(s4)); //true coz it compares character by character
    }
}
