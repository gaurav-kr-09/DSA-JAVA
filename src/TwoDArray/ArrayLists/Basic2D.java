package TwoDArray.ArrayLists;

import java.util.ArrayList;

public class Basic2D {
    public static void main(String[] args) {
        /*ArrayList<Integer> arr = new ArrayList<>(); //1-D k Liye.*/

        ArrayList<ArrayList <Integer>> arr = new ArrayList<>();
//        arr.add(10); //Will not work

        //Method 1
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(2); a.add(3);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(4); b.add(5); b.add(6);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(7); c.add(8); c.add(9); c.add(0);

        arr.add(a); arr.add(b); arr.add(c);

        /*//Printing method 1 - simple method
        System.out.println(arr);

        //Printing method 2 - for loop
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }

        //Printing method 3 - for each loop
        for(ArrayList<Integer> list : arr){
            for(int n: list){
                System.out.print(n + " ");
            }
            System.out.println();
        }*/

        //adding element at any index
        arr.get(arr.size()-1).add(10);  //Last wale arraylist me ek element add ho jayega
        arr.get(1).add(5);

        for(ArrayList<Integer> list : arr){
            for(int n: list){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
