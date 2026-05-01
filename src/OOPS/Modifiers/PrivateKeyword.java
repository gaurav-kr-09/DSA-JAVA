package OOPS.Modifiers;

class Students{
    String name; // default null
    private int roll;  // default 0
    double cgpa; //default 0.0
}

public class PrivateKeyword {
    public static void main(String[] args) {
        Students s1 = new Students();
        System.out.println(s1.name + " "+ s1.cgpa);

        s1.name = "Gaurav";
        s1.cgpa = 2.09;

        // s1.roll = 56; // Ye change nahi hoga kyuki ye private hai.

        System.out.println(s1.name);
    }
}
