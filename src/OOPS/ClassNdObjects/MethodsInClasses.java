package OOPS.ClassNdObjects;

public class MethodsInClasses {
    public static class Gadi{
        int seats;
        String Name;
        double length;
        void print(){
            System.out.println(Name +" " + length + " " + seats);
        }
    }

    public static void main(String[] args) {
        Gadi g1 = new Gadi();
        g1.seats = 8;
        g1.Name = "Saltos";
        g1.length = 3.59;

        Gadi g2 = new Gadi();
        g2.seats = 4;
        g2.Name = "Ferrari";
        g2.length = 4.86;

        g1.print();
        g2.print();
    }
}
