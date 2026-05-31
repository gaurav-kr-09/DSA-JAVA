package BasicMaths;

public class GCD {
    // Method 1: simple
    /*private static int findGCD(int a, int b){
        // let a < b
        if(a > b) return findGCD(b, a);

        for(int i=a; i >= 2; i--){
            if(a % i == 0 && b % i == 0) return i;
        }

        return 1;
    }*/

    // Method 2: Euclidian recursive
    /*private static int findGCD(int a, int b){
        if(a == 0) return b;
        return findGCD(b%a, a);
    }*/

    // Method3: Euclidian iterative
    private static int findGCD(int a, int b){
        while(a != 0){
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(findGCD(40, 20)); //20
        System.out.println(findGCD(1, 20)); // 1
        System.out.println(findGCD(45, 20)); // 5
        System.out.println(findGCD(75, 180)); // 15
        System.out.println(findGCD(180, 75)); // 15
        System.out.println(findGCD(2, 75)); // 1
        System.out.println(findGCD(71, 13)); // 1
        System.out.println(findGCD(17, 15)); // 1
        System.out.println(findGCD(5, 5)); // 5
    }
}
