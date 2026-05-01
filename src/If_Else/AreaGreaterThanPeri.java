package If_Else;

import java.util.Scanner;

public class AreaGreaterThanPeri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        double l = sc.nextDouble();
        System.out.print("Enter breadth: ");
        double b = sc.nextDouble();

        double area = l* b;
        double peri = 2*(l+b);

        if(area > peri){
            System.out.println("Area is greater");
        }else if(area < peri){
            System.out.println("Peri is greater");
        }else{
            System.out.println("Equal");
        }
    }
}
