package BitManipulation;

public class ToggleKthBit {
    private static int toggle(int n, int k) {
        return n ^ (1 << k);
    }

    public static void main(String[] args) {
        System.out.println(toggle(78, 3)); // 78 - 8 = 70
        System.out.println(toggle(78, 4)); // 78 + 16 = 94
    }
}