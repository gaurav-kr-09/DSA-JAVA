package BitManipulation;

public class SetRightMostUnsetBit {
    // O(log n)
    /*private static int setBit(int n) {
        for(int i = 0; i < 31; i++){
            if(((n >> i) & 1) == 0) return n | (1 << i);
        }

        return n;
    }*/

    // O(1) best
    private static int setBit(int n) {
        return n | (n+1);
    }

    public static void main(String[] args) {
        System.out.println(setBit(47)); // 63
        System.out.println(setBit(8)); // 9
    }
}