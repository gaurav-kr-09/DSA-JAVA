package BinarySearch.Answerpattern;

public class MinNoOfDaysToMakeMBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int startDay = Integer.MAX_VALUE;
        int endDay = 0;
        for(int b: bloomDay){
            startDay = Math.min(startDay, b);
            endDay = Math.max(endDay, b);
        }

        int minDays = -1;
        while(startDay <= endDay){
            int mid = startDay + (endDay - startDay) / 2;
            if(noOfBouquetsMade(bloomDay, mid, k) >= m){
                minDays = mid;
                // now find lesser day
                endDay = mid - 1;
            }
            else startDay = mid + 1;
        }
        return minDays;
    }

    private static int noOfBouquetsMade(int[] bloomDay, int maxAllowedDays, int k) {
        int bouquetCount = 0;
        int consecutiveCount = 0;

        for(int i=0; i< bloomDay.length; i++){
            if(bloomDay[i] <= maxAllowedDays) consecutiveCount++;
            else consecutiveCount = 0;

            if(consecutiveCount == k){
                bouquetCount ++;
                consecutiveCount = 0;
            }
        }

        return bouquetCount;
    }

    public static void main(String[] args) {
        int[] bloomDay1 = {1,10,3,10,2};
        int m1 = 3;
        int k1 = 1;
        System.out.println(minDays(bloomDay1, m1, k1)); // 3

        int[] bloomDay2 = {1,10,3,10,2};
        int m2 = 3;
        int k2 = 2;
        System.out.println(minDays(bloomDay2, m2, k2)); // -1

        int[] bloomDay3 = {7,7,7,7,12,7,7};
        int m3 = 2;
        int k3 = 3;
        System.out.println(minDays(bloomDay3, m3, k3)); // 12
    }
}
