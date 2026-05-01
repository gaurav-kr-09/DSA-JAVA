package Array;

import java.util.Scanner;

public class AddOne {
    public static void main(String[] args) {
//        ArrayList<Integer> arr= new ArrayList<>();
//        arr.add(9);
//        arr.add(9);
//        arr.add(9);

//        Not valid method coz the array can contain many may elements more than int.
        /*int n = arr.size();

        int num = 0;
        for(int i=0; i <n; i++){
            num = num * 10;
            num += arr.get(i);
        }

        System.out.println(num + 1); */

        //USing arrayList
        /*ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.size();
        int carry = 1;

        for(int i=n-1; i>=0; i--){
            int sum = arr.get(i) + carry;

            if (sum <= 9) {
                ans.add(sum);
                carry = 0;
            } else {
                ans.add(0);
                carry = 1;
            }
        }
        if(carry == 1) ans.add(1);
        Collections.reverse(ans);
        System.out.println("Required answer: ");
        System.out.println(ans);*/

//        Without ArrayList using array best one
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements in array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original Array: ");
        display(arr, n);

        System.out.println("Required array is:");
        int[] ans = update(arr, n);
        display(ans, ans.length);
    }

    public static void display ( int[] arr, int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static int[] update(int[] arr, int n){
        for (int i = n-1; i >= 0 ; i--) {
            if(arr[i] < 9){
                arr[i]+= 1;
                return arr;
            }
            else arr[i] = 0;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}
