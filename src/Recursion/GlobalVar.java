package Recursion;

public class GlobalVar {
    static int x = 10;
    public static void main(String[] args) {
        System.out.println(x);
        fun();
        System.out.println(x);

        int x = 56;
        System.out.println(x);//Global variable ko overwrite kar diye and ye local ho gay and local ka preference jyada hot ahai global se
        fun();
        System.out.println(x);  // this will not get changed and print 56
    }

    public static void fun(){
        x = 20;  //Ye pura globe me hi x ka value change ho gaya
    }
}
