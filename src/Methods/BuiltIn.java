package Methods;

public class BuiltIn {
    public static void main(String[] args) {
        System.out.println(Math.sqrt((4))); //square root
        System.out.println(Math.cbrt(100)); //cube root
        System.out.println(Math.abs(-9)); //Absolute Value
        System.out.println(Math.floor(9.8)); // 9
        System.out.println(Math.floor(-9.8));  //-10
        System.out.println(Math.ceil(9.001)); //10
        System.out.println(Math.min(8, 10)); //8
        System.out.println(Math.max(8, 10)); //8

        System.out.println(Math.max(10, Math.max(8, 20)));
        System.out.println(Math.pow(5, 0.25));
        System.out.println(Math.pow(0, 0));
    }
}
