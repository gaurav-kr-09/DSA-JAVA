package BitManipulation;

public class ReverseBits {
    // making a extra bit and reversing it -> not good
    /*public static int reverseBits(int n) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(n));

        // 32 bits ka banao taki ye andar wala bits interfare na kare
        for(int i = bin.length(); i < 32; i++) bin.insert(0, '0');
        bin.reverse();

        return Integer.parseInt(bin.toString(), 2);
    }*/

    // Best
    public static int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans = ans << 1; // jagah banega
            ans = ans | (n & 1); // add last bit of n in answer
            n = n >> 1; // now bring the next bit to operate on it
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596)); //ans -> 964176192
        System.out.println(reverseBits(2147483644)); //ans -> 1073741822
    }
}