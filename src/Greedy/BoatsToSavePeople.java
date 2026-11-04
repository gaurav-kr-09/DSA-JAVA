package Greedy;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0, j = people.length-1;
        int boats = 0;
        while(i <= j){
            if(people[i] + people[j] <= limit){ // agar dono aa gaya to ok
                boats++;
                i++;
                j--;
            }else{ // nahi to bhari wale ko baithao
                boats++;
                j--;
            }
        }

        return boats;
    }

    public static void main(String[] args) {
        int[] p1 = {1, 2};
        System.out.println(numRescueBoats(p1, 3)); // 1

        int[] p2 = {3, 2, 2, 1};
        System.out.println(numRescueBoats(p2, 3)); // 3

        int[] p3 = {3, 5, 3, 4};
        System.out.println(numRescueBoats(p3, 5)); // 4

        int[] p4 = {2, 2};
        System.out.println(numRescueBoats(p4, 6)); // 1
    }
}