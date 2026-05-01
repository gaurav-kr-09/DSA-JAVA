package Stacks.Fixes.Infix;

import java.util.Scanner;

public class BasicCalculatorLC224 {
    static int i = 0;
    private static int calculate(String str) {
        int num = 0;
        int ans = 0;
        int sign = 1; // 1 for '+' and -1 for '-'

        while (i < str.length()){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) num = num*10 + (ch - '0');

            if((!Character.isDigit(ch) && ch != ' ') || i == str.length() - 1){
                if(ch == '+') {
                    ans += sign * num;
                    num = 0;
                    sign = 1;
                }
                else if(ch == '-'){
                    ans += sign * num;
                    num = 0;
                    sign = -1;
                }
                else if(ch == '('){
                    i++;
                    num = calculate(str);
                }
                else if(ch == ')'){
                    ans += sign * num;
                    return ans;
                }
            }
            i++;
        }

        return ans + sign * num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid infix expression: ");
        String str = sc.nextLine();
        i = 0;
        System.out.println("Answer is: " + calculate(str));
    }
}
