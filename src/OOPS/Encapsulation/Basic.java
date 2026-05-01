package OOPS.Encapsulation;

class Student{
    String name;
    private int roll = 12;
    double cgpa;

    //this is also a getter coz through it we are  getting some value
    void print(){
        System.out.println(name + " " + roll + " " + cgpa);
    }

    //getter - iske through koi v value get kar sakte hai, even private.
    int getRoll(){
        return roll;
    }

    //setter - iske through koi v value set kar sakte hai, even private.
    void setRoll(int x){
        roll = x;
    }
}

public class Basic {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.print();

        System.out.println("Roll no. (using getter): "+ s1.getRoll());

        //s1.roll = 45; // can't do this
        s1.setRoll(45);
        s1.print();
    }
}
