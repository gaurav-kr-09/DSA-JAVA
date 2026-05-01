package OOPS;

class ComplexNumber {
    double x;
    double y;

    ComplexNumber(double x, double y){
        this.x = x;
        this.y = y;
    }

    void print(){
        if(y >= 0) System.out.println(x + " + " + y + "i");
        else System.out.println(x + " - " + (-y) + "i");
    }

    void add(ComplexNumber n){
        x += n.x;
        y += n.y;

        print();
    }

    void multiply(ComplexNumber n){
        double real = x * n.x - y * n.y;
        double imag = x * n.y + y * n.x;

        x = real;
        y = imag;
        print();
    }

    void divide(ComplexNumber n){
        double denominator = n.x * n.x + n.y * n.y;

        double real = (x * n.x + y * n.y) / denominator;
        double imag = (y * n.x - x * n.y) / denominator;

        x = real;
        y = imag;

        print();
    }

}

public class ComplexNos {
    public static void main(String[] args) {
        ComplexNumber z1 = new ComplexNumber(2, -5);
        ComplexNumber z2 = new ComplexNumber(3, 4);
        ComplexNumber z3 = new ComplexNumber(2, 0);

        z1.print();
        z2.print();
        z3.print();

        System.out.println("=========================");
        z1.add(z2);

        System.out.println("--------------------------");
        z1.print();
        z2.print();

        System.out.println("=========================");
        z1.multiply(z2);

        System.out.println("--------------------------");
        z1.print();
        z2.print();

        System.out.println("=========================");
        z1.divide(z2);

        System.out.println("--------------------------");
        z1.print();
        z2.print();
    }
}
