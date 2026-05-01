package Stacks.Fixes.Infix;

import java.util.Scanner;
import java.util.Stack;

public class Practice {
    static Stack<Integer> val = new Stack<>();
    static Stack<Character> opr = new Stack<>();

    public static boolean isNum(char ch){
        return ch >= '0' && ch <= '9';
    }

    public static void operation(){
        int v2 = val.pop();
        int v1 = val.pop();
        char op = opr.pop();

        switch (op){
            case '+': val.push(v1 + v2); break;
            case '-': val.push(v1 - v2); break;
            case '*': val.push(v1 * v2); break;
            case '/': val.push(v1 / v2); break;
        }
    }

    public static int priority(char ch){
        switch (ch){
            case '+','-': return 1;
            case '*','/': return 2;
        }
        return -1; // never returned
    }

    private static int calculate(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') continue;

            if(isNum(ch)){
                int num = 0;
                while(i < s.length() && isNum(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val.push(num);
            } else {
                if(ch == '(') opr.push(ch);
                else if(ch == ')'){
                    while(opr.peek() != '(') operation();
                    opr.pop();
                }else{ // + - * or /
                    // Checking unary
                    int j = i-1;
                    while(j >= 0 && s.charAt(j) == ' ') j--;
                    if(j < 0 || s.charAt(j) == '(' || s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*' || s.charAt(j) == '/') val.push(0);

                    // Actual work
                    while(!opr.isEmpty() && opr.peek() != '(' && priority(ch) <= priority(opr.peek())) operation();
                    opr.push(ch);
                }
            }
        }

        while (!opr.isEmpty()) operation();

        return val.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid infix expression: ");
        String str = sc.nextLine();

        System.out.println("Answer is: " + calculate(str));
    }
}