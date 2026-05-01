package OOPS.ClassNdObjects;

public class UserDefinedDataType {
    public static class Student{ //Class - agar isko main class k bahar declare karde to dusra file me v (same folder ka) isko access kar sakte hai. ha but usme static na hoga
        String name;
        int roll;
        double cgpa;
    }

    public static void main(String[] args) { //Object
        Student s1 = new Student();
        s1.name =  "Gaurav";
        s1.roll = 61;
        s1.cgpa = 8.38;

        Student s2 = new Student();
        s2.name =  "Sohan";
        s2.roll = 6;
        s2.cgpa = 8.98;

        Student s3 = new Student();
        s3.name = "Oggy";
        s3.roll = 42;
        s3.cgpa = 7.48;

        System.out.println(s1.name +" , "+ s1.roll + " , "+ s1.cgpa);

        s1.cgpa = 7.44;
        System.out.println(s1.name +" , "+ s1.roll + " , "+ s1.cgpa);
    }
}
