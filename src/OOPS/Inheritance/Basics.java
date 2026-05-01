package OOPS.Inheritance;

class Pokemon{
    int power;
    String type;

    Pokemon(){}

    Pokemon(String type, int power){
        this.power = power;
        this.type = type;
    }

    void print(){
        System.out.println(this.power + " " + this.type);
    }
}

class LegendaryPokemon extends Pokemon{ // child class or derived class.
    String ability;
}

class StrongPokemon extends Pokemon{ // child class or derived class.
    int speed;
}

class GodPokemon extends StrongPokemon{
    String tag;
}

public class Basics {
    public static void main(String[] args) {
        LegendaryPokemon mewtwo = new LegendaryPokemon();
        mewtwo.ability = "Pressure";
        System.out.println(mewtwo.ability);
        System.out.println(mewtwo.power);

        GodPokemon dialga = new GodPokemon();
    }
}
