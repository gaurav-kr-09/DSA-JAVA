package OOPS.Constructors;

public class Marks {
    public static class StudentData{
        String name;
        int roll;
        int size;
        int[] marks;

        StudentData(int s){
            marks = new int[s];
        }

        StudentData(int[] m){
            marks = m;
        }
    }

    public static void main(String[] args) {
        StudentData s1 = new StudentData(4);  //Isse marks k liye 4 size ka array ban jayega.
        StudentData s2 = new StudentData(2);  //Isse marks k liye 2 size ka array ban jayega.

        s1.marks[0] = 89;
        s1.marks[1] = 75;
        s1.marks[2] = 42;
        s1.marks[3] = 99;

        int[] s3MarksArray = {44, 72, 88};
        StudentData s3 = new StudentData(s3MarksArray); // ye v kam karega and ye array wwale constructor ko call karega
    }
}
