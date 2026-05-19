package Array.SlidingWindow;

public class MaximumPointsObtainedFromKCards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currSum = 0;
        for(int i=0; i<k; i++)
            currSum += cardPoints[i];

        int i = 1;
        int maxSum = currSum;
        while(k > 0){
            currSum = currSum - cardPoints[k-1] + cardPoints[n-i];
            maxSum = Math.max(maxSum, currSum);
            k--; i++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cards = {1,2,3,4,5,6,1}; // ANS = 12
        int k = 3;
        System.out.println("Maximum point is: " + maxScore(cards, k));

        int[] cards2 = {6,2,3,4,7,2,1,7,1}; // ANS = 16
        k = 4;
        System.out.println("Maximum point is: " + maxScore(cards2, k));
    }
}
