package Greedy;

public class Candy {
    // 2 pass 2 array
    /*public static int candy(int[] ratings) {
        int n = ratings.length;

        int[] l2r = new int[n];
        int[] r2l = new int[n];
        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);

        // left to right
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]) l2r[i] = l2r[i-1] + 1;
        }

        // right to left
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]) r2l[i] = r2l[i+1] + 1;
        }

        int ans = 0;
        for(int i=0; i<n; i++) ans += Math.max(l2r[i], r2l[i]);

        return ans;
    }*/

    // 2 pass single array
    /*public static int candy(int[] ratings) {
        int n = ratings.length;

        int[] count = new int[n];
        Arrays.fill(count, 1);

        // left to right
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]) count[i] = Math.max(count[i], count[i-1]+1);
        }

        // right to left
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]) count[i] = Math.max(count[i], count[i+1] + 1);
        }

        int ans = 0;
        for(int i=0; i<n; i++) ans += count[i];

        return ans;
    }*/

    // 1 pass no space
    public static int candy(int[] ratings) {
        int n = ratings.length;

        int candies = n; // pahle sabko ek ek candy
        int i = 1;
        while (i < n){
            if(ratings[i] == ratings[i-1]){
                i++;
                continue;
            }

            // increasing
            int peak = 0;
            while (ratings[i] > ratings[i-1]){
                peak ++;
                candies += peak;
                i++;

                if(i == n) return candies; // bahar aa gaye
            }

            // decreasing
            int dip = 0;
            while (i < n && ratings[i] < ratings[i-1]){
                dip++;
                candies += dip;
                i++;
                // if(i == n) return candies; // ye yaha nahi hoga kyki min wala ghatana to parega
            }

            candies -= Math.min(peak, dip);
        }

        return candies;
    }

    public static void main(String[] args) {
        int[] r1 = {1, 0, 2};
        System.out.println(candy(r1)); // 5

        int[] r2 = {1, 2, 2};
        System.out.println(candy(r2)); // 4

        int[] r3 = {1, 3, 4, 5, 2};
        System.out.println(candy(r3)); // 11

        int[] r4 = {1, 2, 3, 4, 5};
        System.out.println(candy(r4)); // 15
    }
}