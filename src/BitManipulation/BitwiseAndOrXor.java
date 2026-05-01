package BitManipulation;

public class BitwiseAndOrXor {
    public static void main(String[] args) {
        System.out.println("--------------AND--------------");
        System.out.println(0 & 0);
        System.out.println(0 & 1);
        System.out.println(1 & 0);
        System.out.println(1 & 1);
        System.out.println(51 & 42); // 34
        System.out.println(0 & 99);
        System.out.println(1 & 99);

        System.out.println("----------------OR---------------");
        System.out.println(0 | 0);
        System.out.println(0 | 1);
        System.out.println(1 | 0);
        System.out.println(1 | 1);
        System.out.println(51 | 42); // 59
        System.out.println(0 | 99);
        System.out.println(1 | 99);

        System.out.println("----------------XOR---------------");
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);
        System.out.println(51 ^ 42); // 59
        System.out.println(0 ^ 99);
        System.out.println(1 ^ 99);
    }
}
