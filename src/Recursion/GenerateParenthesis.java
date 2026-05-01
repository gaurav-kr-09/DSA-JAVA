package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        ArrayList<String> ans = new ArrayList<>();
        generate("", n, 0, 0, ans);

        System.out.println(ans);
    }

    public static void generate(String temp, int n, int l, int r, ArrayList<String> ans){
        if(r == n){
            ans.add(temp);
            return;
        }

        if(l<n) generate(temp+"(", n, l+1, r, ans);
        if(r<l) generate(temp+")", n, l, r+1, ans);
    }
}
