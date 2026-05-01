package BitManipulation;

public class OnesAndTwosComplement {
    public static void main(String[] args) {
        System.out.println("ONE'S COMPLEMENT");
        int x = 13; // 1101 -> 0010
        System.out.println(~x);

        System.out.println("TWO'S COMPLEMENT");
        System.out.println(~x + 1);
        // OR
        System.out.println(-x);

        // Ones complement aise v hoga
        System.out.println(-x - 1);
    }
}