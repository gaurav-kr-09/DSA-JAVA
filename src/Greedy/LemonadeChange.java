package Greedy;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int bill: bills){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five <= 0) return false; // min ek 5 req
                five--;
                ten++;
            }else{
                if(five > 0 && ten > 0){
                    five --;
                    ten--;
                }
                else if(five >= 3) five -= 3;
                else return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(bills1));
        // Expected: true

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills2));
        // Expected: false

        int[] bills3 = {5, 5, 10};
        System.out.println(lemonadeChange(bills3));
        // Expected: true

        int[] bills4 = {10};
        System.out.println(lemonadeChange(bills4));
        // Expected: false

        int[] bills5 = {5, 5, 5, 20};
        System.out.println(lemonadeChange(bills5));
        // Expected: true
    }
}