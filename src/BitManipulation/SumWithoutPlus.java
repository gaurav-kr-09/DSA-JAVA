package BitManipulation;

public class SumWithoutPlus {
    public static int sum(int a, int b){
        while(b != 0){
            int carry = (a & b) << 1; // carry ko left bhejo
            a = a ^ b; // dono ko sum karke a me dal do;
            b = carry; // b ko carry bana do taki wo jor le a me
        }
        return a;
    }

    public static void main(String[] args) {
        // sum = a ^ b;
        // carry = a & b;
        // Steps
        // XOR = add without carry
        // AND<<1 = carry
        // Repeat until carry = 0

        System.out.println(sum(12, 96));
        System.out.println(sum(89, 545656210));
        System.out.println(sum(-10, -5));
        System.out.println(sum(-10, 15));
        System.out.println(sum(-10, 5));
    }
}
