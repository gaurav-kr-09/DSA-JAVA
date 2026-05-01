package Strings.basics;

public class ReversingStringUsingStringBuilder {
    public static void main(String[] args) {
        String s = "Gaurav Kumar";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        System.out.println(s);
    }
}
