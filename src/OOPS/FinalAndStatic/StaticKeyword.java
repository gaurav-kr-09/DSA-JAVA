package OOPS.FinalAndStatic;

class Cricketer{
    static String country;
    static String test = "good";

    final static int check = 1;
    int Runs;
    String Name;

    static void print(){
        System.out.println(country);
    }

    /*static void greet(){
        System.out.println(Runs); // ye error dega kyuki method static hai and Runs default
    }*/
}

public class StaticKeyword {
    public static void main(String[] args) {
        Cricketer c1 = new Cricketer();

        c1.country = "india";
        System.out.println(c1.country);

        Cricketer c2 = new Cricketer();
        System.out.println(c2.country); // ye v india hi print hoga

        System.out.println("=========================================");

        System.out.println(c1.test); // good
        c1.test = "bad";
        System.out.println(c1.test); // bad
        System.out.println(c2.test); // ye v bad hi print karega

        System.out.println("=========================================");
        System.out.println(c1.check);
        //c1.check = 5; //Ye error dega, kyuki, ye final tha and it can't be changed
        System.out.println(c2.check);

        System.out.println("=====================()()()===================");
        c1.print();

    }
}
