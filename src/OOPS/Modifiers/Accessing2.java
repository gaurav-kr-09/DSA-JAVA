package OOPS.Modifiers;

class Student{
    String name;
    private int roll = 12;
    double cgpa;
    void print(){
        System.out.println(name + " " + roll + " " + cgpa);
    }

    private void privatePrint(){
        System.out.println("Isko class k bahar access nahi kar sakte hai!");
    }

    public void printThePrivatePrint(){
        privatePrint();
    }
}

public class Accessing2 {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.print();
        //s1.privatePrint(); // Cant be accessed
        s1.printThePrivatePrint(); // ye kam karega

        s1.name = "Gaurav";
        s1.cgpa = 2.09;

        s1.print();
    }
}
