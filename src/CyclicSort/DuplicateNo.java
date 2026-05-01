package CyclicSort;

import java.util.Scanner;

public class DuplicateNo {
    public static void display(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array (A/c to qn): ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.println("The Duplicate element is: "+ findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] == i+1) i++;
            else{
                int index = arr[i] - 1;

                if(arr[i] == arr[index]) return arr[i];

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return -1;
    }

    /*// yahi agar duplicates ko arraylist me add karna rehta to
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        while(i < arr.length){
            int index = arr[i] - 1;

            if(arr[i] == i+1 || arr[i] == arr[index]) i++;
            else{
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        for(i = 0; i < arr.length; i++){
            if(arr[i] != i+1) ans.add(arr[i]);
        }

        return ans;
    }*/
}
