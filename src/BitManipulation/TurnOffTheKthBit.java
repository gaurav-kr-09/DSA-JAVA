package BitManipulation;

public class TurnOffTheKthBit {
    static int clearKthBitFromLeft(int n, int k) {
        return n & ~(1 << k);
    }

    static int clearKthBitFromRight(int n, int k){
        int bits = Integer.toBinaryString(n).length();
        return n & ~(1 << (bits - k));
    }

    public static void main(String[] args) {
        System.out.println(clearKthBitFromLeft(78, 3)); // 70
        System.out.println(clearKthBitFromLeft(78, 4)); // 78

        System.out.println(clearKthBitFromRight(78, 3)); // 78
        System.out.println(clearKthBitFromRight(78, 4)); // 70
    }
}