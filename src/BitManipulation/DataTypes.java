package BitManipulation;

public class DataTypes {
    public static void main(String[] args) {
        byte x = 127;
        System.out.println(x);
        // BYTE OVERFLOW
        x += 1;
        System.out.println(x); // -128
    }
}
