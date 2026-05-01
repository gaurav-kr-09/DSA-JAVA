package OOPS.ClassNdObjects;

public class PassingClassesToMethods {
    public static class Cars{
        int seats;
        String Name;
        double length;
    }

    public static void main(String[] args) {
        Cars c1 = new Cars();
        c1.seats = 8;
        c1.Name = "Saltos";
        c1.length = 3.59;

        System.out.println(c1.Name +" " + c1.length + " " + c1.seats);

        change(c1);
        System.out.println(c1.Name +" " + c1.length + " " + c1.seats); // yaha pe asli c me value cghange ho jayega , iss ye pata lagta hai ki ye pass by referecnce hai.
    }

    public static void change(Cars c){
        c.Name = "Ertiga";
        c.seats = 15;
    }
}
