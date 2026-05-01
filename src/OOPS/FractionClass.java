package OOPS;

class Fraction{
    int num;
    int den;

    Fraction(int num, int den){
        this.num = num;
        this.den = den;

        simplify();
    }

    int hcf(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(a == 0) return b;
        return hcf(b%a, a);
    }

    void simplify(){
        int gcd = hcf(num, den);
        num /= gcd;
        den /= gcd;
    }

    void print(){
        if(this.den < 0) {
            this.num = -(this.num);
            this.den = -(this.den);
        }
        System.out.println(this.num+"/"+this.den);
    }

    void add(Fraction f){
        num = num * f.den + f.num * den;
        den = den * f.den;
        simplify();
        print();
    }

    void multiply(Fraction f){
        num = num * f.num;
        den = den * f.den;
        simplify();
        print();
    }

    void divide(Fraction f){
        int tempNum = num * f.den;
        den = den * f.num;
        num = tempNum;
        simplify();
        print();
    }
}

public class FractionClass {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(40, 50);
        f1.print();
        Fraction f2 = new Fraction(9, 6);
        f2.print();

        System.out.print("Sum is: ");
        f1.add(f2);

        f1.print();
        f2.print();

        System.out.print("Product is: ");
        f1.multiply(f2);

        f1.print();
        f2.print();

        System.out.print("Quotient is: ");
        f1.divide(f2);

        Fraction f3 = new Fraction(5, -8);
        f3.print();
        Fraction f4 = new Fraction(-5, -8);
        f4.print();
        Fraction f5 = new Fraction(-5, 8);
        f5.print();

    }
}
