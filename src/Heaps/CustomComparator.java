package Heaps;

import java.util.Arrays;

public class CustomComparator {
    static class Student{
        String name;
        int rno;
        double cgpa;

        Student(String name, int rno, double cgpa){
            this.name = name;
            this.rno = rno;
            this.cgpa = cgpa;
        }
    }

    static class StudentY implements Comparable<StudentY>{
        String name;
        int rno;
        double cgpa;

        StudentY(String name, int rno, double cgpa){
            this.name = name;
            this.rno = rno;
            this.cgpa = cgpa;
        }

        // man le rollno k basis pe sort karna hai
//            public int compareTo(StudentY s){
//                return this.rno - s.rno;
//            }

       // better way for roll no
//           public int compareTo(StudentY s){
//               return Integer.compare(this.rno, s.rno);
//           }

       // Descending for roll no
//           public int compareTo(StudentY s){
//               return Integer.compare(s.rno, this.rno);
//           }


       // man le agar name k basis pe sort karna hai
//           public int compareTo(StudentY s){
//               return this.name.compareTo(s.name);
//           }

       // descending name
//           public int compareTo(StudentY s){
//               return s.name.compareTo(this.name);
//           }

       // man le cgpa k basis pe sort karna hai
//           public int compareTo(StudentY s){
//               return Double.compare(this.cgpa, s.cgpa);
//           }

       // Descending cgpa
//           public int compareTo(StudentY s){
//               return Double.compare(s.cgpa, this.cgpa);
//           }

       // dekho pahle cgpa pe and agar cgpa same ho to rollno pe
       public int compareTo(StudentY s){
            int res = Double.compare(this.cgpa, s.cgpa);
            if(res == 0){
                return this.name.compareTo(s.name);
            }
            return res;
       }
    }

    static class StudentZ{
        String name;
        int rno;
        double cgpa;

        StudentZ(String name, int rno, double cgpa){
            this.name = name;
            this.rno = rno;
            this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) {
        // ye kam karega
//        int[] arr = {5,8,9,6};
//        Arrays.sort(arr);
//        for(int ele: arr) System.out.print(ele + " ");

        // ye v kam karega
//        String[] arr = {"gaurav", "aam", "imli", "bhang"};
//        Arrays.sort(arr);
//        for(String ele: arr) System.out.print(ele + " ");

        // but ham agar apna custom data type bana k Arrays.sort lagaye
        // to ye kam nahi karega ye confuse ho jayega ki kis basis pe sort kare
//        Student s1 = new Student("Gaurav", 61, 8.38);
//        Student s2 = new Student("Aman", 19, 7.46);
//        Student s3 = new Student("Riya", 1, 8.09);
//        Student s4 = new Student("Gautam", 1, 8.64);
//
//        Student[] students = {s1, s2, s3};
//        Arrays.sort(students);
//        for(Student st: students) System.out.println(st.name + " " + s.rno);

        // agar ham chahte hai ki ye kam kare to aise karna hoga
        // samajhne k liye StudentY class banayenge
//        StudentY s1 = new StudentY("Gaurav", 61, 8.38);
//        StudentY s2 = new StudentY("Aman", 19, 7.46);
//        StudentY s3 = new StudentY("Riya", 1, 8.09);
//        StudentY s4 = new StudentY("Gautam", 10, 8.09);
//
//        StudentY[] students = {s1, s2, s3, s4};
//        Arrays.sort(students);
//        for(StudentY st: students) System.out.println(st.name + " " + st.rno + " " + st.cgpa);

        // DEkho aab is sab se badhiya way hai ek comparable ki jagah comparator use karna
        StudentZ s1 = new StudentZ("Gaurav", 61, 8.38);
        StudentZ s2 = new StudentZ("Aman", 19, 7.46);
        StudentZ s3 = new StudentZ("Riya", 1, 8.09);
        StudentZ s4 = new StudentZ("Gautam", 10, 8.09);
        StudentZ s5 = new StudentZ("Riya", 22, 6.67);

        StudentZ[] students = {s1, s2, s3, s4, s5};

        // Ascending CGPA sort
//        Arrays.sort(students, (a,b) -> Double.compare(a.cgpa, b.cgpa));

        // Descending CGPA sort
//        Arrays.sort(students, (a,b) -> Double.compare(b.cgpa, a.cgpa));

        // roll no.
//        Arrays.sort(students, (a,b) -> Integer.compare(a.rno, b.rno));

        // isi tarike se or v bahut sara kar sakte hai

        // dekho pahle name pe and agar name same ho to rollno pe
        Arrays.sort(students, (a, b) -> {
            int res = a.name.compareTo(b.name);
            if(res == 0){
                return Integer.compare(a.rno, b.rno);
            }
            return res;
        });

        for(StudentZ st: students) System.out.println(st.name + " " + st.rno + " " + st.cgpa);
    }
}