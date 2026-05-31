package BasicMaths;

public class ArmstrongNo {
    public static boolean isArmstrong(int n) {
        int dup = n;
        int digits = digits(n);
        int num = 0;
        while(n > 0){
            num += (int) Math.pow(n % 10, digits);
            n /= 10;
        }

        return dup == num;
    }

    private static int digits(int n){
        if(n == 0) return 1;

        int digits = 0;
         while(n > 0){
             digits++;
             n /= 10;
         }
         return digits;
    }

    public static void main(String[] args) {
        int n = 153; // true
        System.out.println(isArmstrong(n));
        n = 371; // true
        System.out.println(isArmstrong(n));
        n = 1634; // true
        System.out.println(isArmstrong(n));
        n = 72; // false
        System.out.println(isArmstrong(n));
        n = 1802; // false
        System.out.println(isArmstrong(n));
        n = 0; // true
        System.out.println(isArmstrong(n));
    }
}
