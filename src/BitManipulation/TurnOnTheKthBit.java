package BitManipulation;

public class TurnOnTheKthBit {
    static int setKthBit(int n, int k) {
        return  n | (1 << k);
    }

    public static void main(String[] args) {
        int n = 78;
        int k = 4;
        System.out.println(setKthBit(n, k)); // ans 94 -> 78 + 16 = 94
    }
}