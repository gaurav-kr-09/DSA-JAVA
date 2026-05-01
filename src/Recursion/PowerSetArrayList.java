package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PowerSetArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();

        List<String> ans = new ArrayList<>();

        subsets("",str,0, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    //Direct ans.add(char) nahi kar sakte kyuki add() ka return type boolean hota hai and yaha pe string chahiye

    public static void subsets(String temp, String str, int i, List<String> ans){
        //Isse sara print ho jayega.
        /*if(i == str.length()){
            ans.add(temp);
            return;
        }*/

        if(i == str.length()){
//            if(temp.length() != 0) ans.add(temp);
            if(!temp.isEmpty()) ans.add(temp);
            return;
        }

        char ch = str.charAt(i);
        subsets(temp+ch, str,i+1, ans);    //Pick
        subsets(temp, str, i+1, ans);           //Skip
    }
}
