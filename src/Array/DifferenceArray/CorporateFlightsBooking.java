package Array.DifferenceArray;

public class CorporateFlightsBooking {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        // since 1 to n i.e. 1-indexed
        for(int[] booking: bookings){
            int a = booking[0], b = booking[1], c = booking[2];
            diff[a-1] += c;
            if(b < n) diff[b] -= c;
        }

        for(int i=1; i<n; i++) diff[i] += diff[i-1];

        return diff;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5; // 10,55,45,25,25

        for(int a: corpFlightBookings(bookings, n)) System.out.print(a + " ");
    }
}