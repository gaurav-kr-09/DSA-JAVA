package OOPS.Constructors;

public class Basics {
    public static class Car{
        int seats;
        String name;
        double length;

        /*// Default Constructor - ye har bar call hota hai and ye by default rehta hi hai.
        Car(){

        }*/

        // Default constructor unparameterized.
        Car(){
            System.out.println("Are bhai ye har bar call hoga, jab v object banaoge, in fact tum print nahi v karo bas object banao ye print ho jayega Ha but unparameterized object banana parega.");
        }

        // Isi chiz ko constructor overloading v bolte hai.
        Car(int s, String n, double l){
            seats = s;
            name = n;
            length = l;
        }

        Car(String n, int s, double l){
            name = n;
            seats = s;
            length = l;
        }

        void print(){
            System.out.println(name + " " + length + " " + seats);
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(); // ye unparameterized constructor call karega.
        c1.print();
        System.out.println("-------------------------------------");

        Car c2 = new Car(5, "Kia Saltos", 2.99);
        System.out.println(c2.length);
        System.out.println("-------------------------------------");

        Car c3 = new Car(15, "Lord Alto", 4.12);
        System.out.println(c3.length);
        c3.print();
        c3.length = 5.43;
        System.out.println(c3.length);
        c3.print();
        System.out.println("-------------------------------------");

        // Calling the parameterized second constructor
        Car c4 = new Car("Honda", 2, 2.23);
        c4.print();
        System.out.println("-------------------------------------");
    }
}
