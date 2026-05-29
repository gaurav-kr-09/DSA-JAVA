package BinarySearch.Answerpattern;

public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        // lo mid high are speeds
        int lo = 1; // At least 1 banana/hour kha sakti hai.
        int hi = -1; // Agar largest pile x hai, then x bananas/hour pe har pile max 1 hour me finish ho jayega.
        for(int p: piles) hi = Math.max(hi, p);
        int speed = Integer.MAX_VALUE;

        while (lo <= hi){
            int mid = lo + (hi -lo) / 2;
            if(hours(mid, piles) <= h){
                // time kam laga -> means speed jyada hai
                // so, speed kam karo
                hi = mid - 1;
                speed = mid;
            }
            else lo = mid + 1; // time jyada laga meaans speed kam hai, so increase speed
        }

        return speed;
    }

    private static long hours(int speed, int[] piles) {
        long hrs = 0;
        for(int p: piles){
            if(p % speed == 0) hrs += p / speed; // yani pura pile khatam
            else hrs += (p / speed + 1); // wo jo last me bach jayega uske liye ek ghanta
        }
        return hrs;
    }

    public static void main(String[] args) {
        int[] piles1 = {3, 6, 7, 11};
        int h = 8; // ans = 4
        System.out.println(minEatingSpeed(piles1, h));

        int[] piles2 = {30,11,23,4,20};
        h = 6; // ans = 23
        System.out.println(minEatingSpeed(piles2, h));
    }
}