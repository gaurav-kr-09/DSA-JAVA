package OOPS.FinalAndStatic;

class Cricketers{
    final String country = "India";
    int Runs;
    String Name;
}

public class FinalKeyword {
    public static void main(String[] args) {
        /*final int x = 75; // x can't be changed coz it's final
        x = 82; // Wrong*/

        Cricketers c1 = new Cricketers();
        System.out.println(c1.country);

        //c1.country = "Zimbwabe"; // Error dega.

    }
}
