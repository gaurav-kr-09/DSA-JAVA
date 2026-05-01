package Basics;

public class Increment {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x); //10
        System.out.println(x++); //10
        System.out.println(x); //11

        System.out.println("--------------------------------");
        x = 10;
        System.out.println(x); //10
        System.out.println(++x); //11
        System.out.println(x); //11

        System.out.println("--------------------------------");
        x = 10;
        int y = x++;
        System.out.println(x); // 11
        System.out.println(y); // 10
    }
}
