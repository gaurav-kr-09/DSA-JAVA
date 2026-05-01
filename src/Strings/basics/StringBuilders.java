package Strings.basics;

public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("Gaurav");
        System.out.println(s.length() + " , " + s.capacity());
        System.out.println(s);

        s.append(" Kumar");
        System.out.println(s);
        System.out.println(s.length() + " , " + s.capacity());


        StringBuilder s1 = new StringBuilder(6);
        System.out.println(s1.capacity());

        s1.append("Gaurav");
        System.out.println(s1 + " , " + s1.capacity());

        s1.append("Kumar");
        System.out.println(s1 + " , "+ s1.capacity());

        System.out.println("------------------------------------------------");

        StringBuilder test = new StringBuilder("Test String");
        System.out.println(test);

        test.setCharAt(0, 'P');
        System.out.println(test);  // O(1) time complexity

        String str = test.toString();
        System.out.println(str);

        test.deleteCharAt(0);
        System.out.println(test);

        test.insert(0, 'T');
        System.out.println(test);

        test.delete(0, 4);
        System.out.println(test);
    }
}
