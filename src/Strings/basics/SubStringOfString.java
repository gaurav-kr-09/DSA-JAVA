package Strings;

public class SubStringOfString {
    public static void main(String[] args) {
        String s = "Prachandeshwar";
        System.out.println(s.substring(0)); // isse 0 se last tak ka substring pura print ho jayega yani pura s
        System.out.println(s.substring(4)); // 4 se aage


        System.out.println(s.substring(1, 5)); // 1 to 4
        System.out.println(s.substring(1, s.length() - 1));
    }
}
