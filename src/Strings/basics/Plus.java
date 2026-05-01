package Strings;

public class Plus {
    public static void main(String[] args) {
        String a = "gaurav ";
        String b = "kumar";
        a = a + b;
        System.out.println(a);

        a += 5008;
        System.out.println(a);

        a+='s';
        System.out.println(a);

        a += '\n'; //Ye next line me leke chala jayega.
        System.out.println(a);

        a += " gautab";
        System.out.println(a);

        String test = "test string";
        System.out.println(test);

        System.out.println(test + 10 + 20);  // it will give test string1020  coz sum is from left to right so first string plus 10 and then plus 20
        System.out.println(10 + 20+ "gaurav"); //30gaurav
        System.out.println(10+"gaurav"+20);

        System.out.println('A' + "gaurav"); //Agaurav
        System.out.println('A'+20+"Gaurav"); // 85 Gaurav -> yaha pe pahle A ka asci me 20 jurega uske bad string "gaurav"
    }
}
