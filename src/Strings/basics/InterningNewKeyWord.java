package Strings.basics;

public class InterningNewKeyWord {
    public static void main(String[] args) {
        String s = "gaurav";
        s = "Amm";
//        s += " kumar";
        System.out.println(s);

        String t = "gaurav";
        System.out.println(t);

        t += "kfjk";

        System.out.println(s);
        System.out.println(t);

//        if we want to change the string's individual character.'
        s = "Gaurav";
//        let's say we want to change gaurav to Gaumav
        s = s.substring(0, 3) + 'm' + s.substring(4);
        System.out.println(s);
    }

}
