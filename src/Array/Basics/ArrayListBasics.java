package Array.Basics;

import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(10);
        arr.add(15);
        arr.add(20);
        arr.add(25);

        System.out.println(arr);
        System.out.println(arr.get(2)); //Returns Second index element
        arr.set(2, 40);
        System.out.println(arr.get(2));

        int n = arr.size();
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + "\t");
        }
        System.out.println();
        arr.removeLast();
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);

//        Collections.reverse(arr);

//        Manually reversing the arrayList
        int i = 0, j = arr.size()-1;
        while(i < j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }

        System.out.println(arr);
    }
}
