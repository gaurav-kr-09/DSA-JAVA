package BitManipulation;

public class BinaryTODecimal {
    private static double b2D(String bin){
        boolean isNeg = bin.charAt(0) == '-';
        if(isNeg) bin = bin.substring(1);

        String[] parts = bin.split("\\.");
        String intPart = parts[0];
        double ans = 0;

        // Handling Integer Part
        int n = intPart.length();
        /*for(int i = n-1; i >= 0; i--){
            ans += (intPart.charAt(i) - '0') * Math.pow(2, n-i-1);
        }*/

        // OR BETTER
        for (int i = 0; i < intPart.length(); i++) {
            ans = ans * 2 + (intPart.charAt(i) - '0');
        }

        // Handling Fraction Part
        if(parts.length > 1){
            String fracPart = parts[1];

            /*for (int i = 0; i < fracPart.length(); i++){
                ans += (fracPart.charAt(i) - '0') * Math.pow(2, -(i+1));
            }*/

            // OR BETTER
            double power = 0.5;
            for (int i = 0; i < fracPart.length(); i++) {
                if(fracPart.charAt(i) == '1') ans += power;
                power /= 2;
            }
        }

        return isNeg ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(b2D("1001"));
        System.out.println(b2D("1001.01"));
        System.out.println(b2D("101.101"));
        System.out.println(b2D("-101.101"));
        System.out.println(b2D("101.101000000000000001"));
        System.out.println(b2D("101"));
    }
}
