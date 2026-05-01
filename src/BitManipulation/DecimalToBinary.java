package BitManipulation;

public class DecimalToBinary {
    // ONLY INTEGER
    public static String dToBInt(int num){
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }

        return sb.reverse().toString();
    }

    // WITH FLOAT & DOUBLE AND ALSO ENCOUNTERING -VE
    public static String dToBDouble(double num){
        boolean isNeg = num < 0;

        num = Math.abs(num);
        int intPart = (int) num;
        double fracPart = num - intPart;

        // Integer k liye
        StringBuilder intSb = new StringBuilder();

        if(intPart == 0) intSb.append(0);
        else{
            while(intPart > 0) {
                intSb.append(intPart % 2);
                intPart /= 2;
            }
        }

        // Fraction k Liye
        StringBuilder fltSb = new StringBuilder();

        while(fracPart > 0 && fltSb.length() < 10){
            fracPart *= 2;

            if(fracPart >= 1){
                fltSb.append("1");
                fracPart -= 1;
            }
            else fltSb.append("0");
        }

        String res = intSb.reverse().toString();
        if(fltSb.length() > 0) res += "." + fltSb;

        return isNeg ?  "-" + res : res;
    }

    public static void main(String[] args) {
        int decInt = 45; // 101101
        // int decInt = 64; // 1000000
        System.out.println(dToBInt(decInt));
        System.out.println(dToBInt(21));

        System.out.println("===========================");
        // double decFlt = 12.5;
        // double decFlt = 8.625;
        // double decFlt = 8.30;
        // double decFlt = 8.0;
        // double decFlt = -9.625;
        double decFlt = -8.30;
        System.out.println(dToBDouble(decFlt));
    }
}
