package OOPS.PolyMorphism;

public class Polymorph {
    public static class Dog{
        void speak(){
            System.out.println("barks");
        }
    }
    public static class Cat{
        void speak(){
            System.out.println("meow");
        }
    }
    public static class Lion{
        void speak(){
            System.out.println("roars");
        }
    }
    public static class Duck{
        void speak(){
            System.out.println("quacks");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        Lion l = new Lion();
        Duck du = new Duck();

        d.speak();
        c.speak();
        l.speak();
        du.speak();
    }
}
