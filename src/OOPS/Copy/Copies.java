package OOPS.Copy;

public class Copies {
    private static class Pokemon{
        int hp;
        int sped;
        int attack;
        int defence;
        String type;
        String name;
    }

    public static void main(String[] args) {
        Pokemon p1 = new Pokemon();
        p1.name = "pikachu";
        p1.type = "Electric";
        p1.attack = 70;

        Pokemon p2 = new Pokemon();
        p2.name = "Charizard";
        p2.type = "Fire";
        p2.attack = 110;

        System.out.println(p1.type);
        Pokemon p3 = p1; // P3 is shallow coppy of p1 i.e same memory address so both can control each other
        p3.type = "Water";
        System.out.println(p1.type);
        System.out.println(p3.type);
    }
}
