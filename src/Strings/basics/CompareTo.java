package Strings;

public class CompareTo {
    public static void main(String[] args) {
//        compareTo() do string ko lexographically compare karta hai ASCII value k according
//        lexographically matlab dictionary wale order me

        String a = "Gaurav Kumar";
        String b = "Harpreet";
        System.out.println(a.compareTo(b));  // yaha -1 print hoga kyuki pahla akshar G , H se ek chhota hai to ye aage wala dekhega hi nahi.

        String c = "ramanand";
        String d = "ramu";
        System.out.println(c.compareTo(d)); // -20 print hoga , kyuki a , u se 20 chhota hai lexographically.

        String e = "ramu";
        String f = "ramanand";
        System.out.println(e.compareTo(f)); // 20 print hoga , kyuki u , a se 20 bada hai lexographically.

        String g = "gaurav";
        String h = "gaurav";
        System.out.println(g.compareTo(h)); // ), kyuki wo dono pura same hai.

        String i = "gauravkumar";
        String j = "gaurav";
        System.out.println(i.compareTo(j)); //agar dono ka same ho to dono k length me kitna difference hai wo print hota hai

    }
}
