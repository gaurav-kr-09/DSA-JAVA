package Strings;

public class BuiltInMethods {
    public static void main(String[] args) {
        String s = "Gaurav Kumar";
        System.out.println(s.indexOf('a')); // first index of a
        System.out.println(s.lastIndexOf('a')); //last index of a
        System.out.println(s.lastIndexOf('o')); //agar char na ho to -1
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());

        System.out.println(s.contains("Kum")); //true
        System.out.println(s.contains("Kumb")); //false

        System.out.println(s.startsWith("G")); //true
        System.out.println(s.startsWith("g")); //false

        System.out.println(s.endsWith("r")); //true
        System.out.println(s.endsWith("R")); //false

        s.toUpperCase();
        System.out.println(s); //toUpperCase yaha kuchh nahi karega kyuki ye inplace nahi kam karta hai, yahi agar uska value kisis ko assign kiye rahte to wo kam karta

        String a = "aam";
        String b = "imli";

        System.out.println(a.concat(b)); //aaamimli //Ismev inplace nahi hota hai balki ek naya string banta hai
        a.concat(b);
        System.out.println(a); //Yaha pe a ka value hi print hoga, kyuki concatenated vlaue ko kahi store ahi kiye hai
    }
}
