package Stacks.Fixes.Infix;

import java.util.Scanner;
import java.util.Stack;

public class BasicCalculator2OneStack {
    private static int calculate(String str) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) num = num*10 + (ch - '0');
            if((!Character.isDigit(ch) && ch != ' ') || i == str.length() - 1){
                if(sign == '+') st.push(num);
                else if(sign == '-') st.push(-num);
                else if(sign == '*') st.push(st.pop()*num);
                else if(sign == '/') st.push(st.pop()/num);

                sign = ch;
                num = 0;
            }
        }

        int ans = 0;
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid infix expression: ");
        String str = sc.nextLine();

        System.out.println("Answer is: " + calculate(str));
    }
}