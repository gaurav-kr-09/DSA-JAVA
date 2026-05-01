package BitManipulation;

public class KthBitIsSetOrNot {
    static boolean checkKthBit(int n, int k) {
        return ((n >> k) & 1) == 1;
    }

    public static void main(String[] args) {
        int n = 78;
        int k = 3;
        System.out.println(checkKthBit(n, k));
    }
}