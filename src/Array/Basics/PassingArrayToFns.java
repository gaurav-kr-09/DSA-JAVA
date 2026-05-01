package Array.Basics;

public class PassingArrayToFns {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(arr[2]); //30

        change(arr);
        System.out.println(arr[2]); //99
    }

    public static void change(int[] brr) {
        brr[2] = 99;
    }
}
