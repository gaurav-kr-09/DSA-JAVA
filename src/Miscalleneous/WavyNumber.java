package Miscalleneous;

public class WavyNumber {
    public static int totalWaviness(int num1, int num2) {
        if (num2 <= 100)
            return 0;

        int count = 0;
        for (int i = 101; i <= num2; i++) {
            count += countPeakValley(i);
        }

        return count;
    }

    public static int countPeakValley(int num) {
        char[] numChar = String.valueOf(num).toCharArray();

        int count = 0;
        for (int i = 1; i < numChar.length - 1; i++) {
            if ((numChar[i] > numChar[i-1] && numChar[i] > numChar[i+1]) ||
                    (numChar[i] < numChar[i-1] && numChar[i] < numChar[i+1])) {
                count++;
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalWaviness(120, 130));
        // 120, 121, 130 -> 3
    }
}
