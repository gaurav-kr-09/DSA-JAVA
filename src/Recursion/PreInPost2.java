package Recursion;

public class PreInPost2 {
    public static void main(String[] args) {
        pip(3);
    }

    public static void pip(int n){
        if(n == 0) return;

        System.out.print("Pre "+ n +" ");
        pip(n-1);
        System.out.print("In " + n + " ");
        pip(n-1);
        System.out.print("Post "+ n +" ");

    }
}
