package TwoDArray.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows of Pascal triangle to print : ");
        int n = sc.nextInt();

        ArrayList<ArrayList <Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());

            for (int j = 0; j <= i; j++) {
                if(j==0 || j == i) arr.get(i).add(1);
                else arr.get(i).add(arr.get(i-1).get(j-1) + arr.get(i-1).get(j));
            }
        }

        System.out.println("Pascal's triangle of height "+n+" is: ");
        for(ArrayList<Integer> brr: arr){
            for (int ele: brr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
