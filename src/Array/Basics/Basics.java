package Array.Basics;

public class Basics {
    public static void main(String[] args) {
        System.out.println("Method 1");
        int[] x = {5, 6, 7, 141, 45};
        //Access
        System.out.println(x[0]);

        //Updating elements - mutability
        x[3] = 142;
        System.out.println(x[3]);

        System.out.println("Method 2");
        int[] arr = new int[4]; //Empty array with 4 elements
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 15;
        arr[3] = 42;

    }
}
