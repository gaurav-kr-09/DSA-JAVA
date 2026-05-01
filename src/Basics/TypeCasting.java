package Basics;

public class TypeCasting {
    public static void main(String[] args) {
        char ch = 'A';
        int x = ch; //Implicit typeCasting
        System.out.println(x);

        char ch2 = 'a';
        int y = (int)ch2; //Explicit typeCasting
        System.out.println(y);

        char p = '0';
        System.out.println((int)p);

        char c = 'b';
        System.out.println(c+0);
        System.out.println(c+c);
        System.out.println(c+5);


        int i = 65;
        char c1 = (char)i;
        System.out.println(c1);
    }
}
