package Loops;

public class Basics {
    public static void main(String[] args) {
        //For Loop
        for (int i = 1; i <= 10 ; i++) {
            System.out.print(i + "\t");
        }

        System.out.println();

        //While Loop
        int i = 1;
        while (i <= 10){
            System.out.print(i + "\t");
            i++;
        }

        System.out.println();

        //Do While Loop
        i = 11;
        do{
            System.out.print(i + "\t");
            i ++;
        }while(i <= 10);
    }
}
