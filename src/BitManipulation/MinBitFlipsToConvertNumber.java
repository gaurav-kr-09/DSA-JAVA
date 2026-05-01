package BitManipulation;

public class MinBitFlipsToConvertNumber {
    public static int minBitFlips(int start, int goal) {
        int temp = start ^ goal;

        // Counting no. of 1's
        int count = 0;
        while(temp != 0){
            temp = temp & (temp - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7)); // 3
        System.out.println(minBitFlips(10, 10)); // 0
        System.out.println(minBitFlips(15, 16)); // 5
    }
}