package BinarySearch.Answerpattern;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position); // sort kar do taki place karne me easy ho
        // min distance can be 1
        int lo = 1;
        // max distance will be difference bw max and min element in array
        int hi = position[position.length-1] - position[0];

        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(isPossible(position, m, mid)){
                // matlab m balls rakhna with minimum distance mid is possible,
                // and answer is good now find larger min distance
                ans = mid;
                lo = mid + 1;
            }
            // m balls rakhna with minimum distance mid is not possible so decrease mid
            else hi = mid-1;
        }

        return ans;
    }

    private static boolean isPossible(int[] position, int balls, int minAllowedDist){
        // since min distance maximize karna hai isiliye
        // first position pe to ball hoga hi, so put that
        // coz placing earlier leaves more space for future balls
        int currPlacedBalls = 1;
        int lastBallPosition = position[0];

        // check if balls can be placed with distance mid
        for(int i=1; i<position.length; i++){
            // if distance is >= mid then place that ball
            if(position[i] - lastBallPosition >= minAllowedDist){
                currPlacedBalls++;
                lastBallPosition = position[i];
            }
            // if all balls are placed means possible
            if(balls == currPlacedBalls) return true;
        }

        // all balls are not placed
        return false;
    }

    public static void main(String[] args) {
        int[] position1 = {1,2,3,4,7};
        int m1 = 3;
        System.out.println(maxDistance(position1, m1)); // 3

        int[] position2 = {5,4,3,2,1,1000000000};
        int m2 = 2;
        System.out.println(maxDistance(position2, m2)); // 999999999
    }
}
