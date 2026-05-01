package Stacks.Fixes.Infix;

import java.util.Scanner;

public class BasicCalcAdvancedLC224 {
    static int i = 0;
    private static int calculate(String str) {
        int num = 0;
        int ans = 0;
        int lastNo = 0;
        char sign = '+';

        while (i < str.length()){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) num = num*10 + (ch - '0');

            if(ch == '('){
                i++;
                num = calculate(str);
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == str.length() - 1){
                if(sign == '+'){
                    ans += lastNo;
                    lastNo = num;
                }else if(sign == '-'){
                    ans += lastNo;
                    lastNo = -num;
                }
                else if(sign == '*') lastNo *= num;
                else if(sign == '/') lastNo /= num;

                sign = ch;
                num = 0;
            }

            if(ch == ')') break;

            i++;
        }

        return ans + lastNo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid infix expression: ");
        String str = sc.nextLine();
        i = 0;
        System.out.println("Answer is: " + calculate(str));
    }
}
