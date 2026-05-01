package OOPS.Constructors;

public class ThisKeyWord {
    public static class Car{
        int seats;
        String name;
        double length;

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

        // Upar wala dono constructor kam karega - but agar variable ka name same ho jaye
        // yaha compiler confuse ho gaya ki kon se length me kya dale and wo
        // (variable = value) variable me hi kat k length dal diya but length ka koi value to set hua nahi
        // isiliye jo default tha wahi print ho gaya.

        Car(double length, String name, int seats){
            /*// ye tino error dega.
            length = length;
            name = name;
            seats = seats;*/

            this.length = length;
            this.name = name;
            this.seats = seats;
        }


        void print(){
            System.out.println(name + " " + length + " " + seats);

            /*int seats = 4;
            System.out.println(name + " " + length + " " + seats); // aab yaha pe jo v print call karega waha pr seats me 4 hi print hoga
            System.out.println(name + " " + length + " " + this.seats); // but yaha pe seats ki original value hi print hogi*/
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car(5, "Kia Saltos", 2.99);
        System.out.println(c1.length);
        System.out.println("-------------------------------------");

        Car c2 = new Car(15, "Lord Alto", 4.12);
        System.out.println(c2.length);
        c2.print();
        c2.length = 5.43;
        System.out.println(c2.length);
        c2.print();
        System.out.println("-------------------------------------");

        Car c3 = new Car("Honda", 2, 2.23);
        c3.print();
        System.out.println("-------------------------------------");

        Car c4 = new Car(5.12, "Alcazar", 8);
        c4.print();  // bina this ke sab ka default value print hoga but agar this use kar liye to avi given value print hoga

    }
}

