package Stacks.Fixes.Prefix;

import java.util.Scanner;
import java.util.Stack;

public class Practice {
    public static int precedence(char c){
        if(c == '+' || c == '-') return 1;
        else if(c == '*' || c == '/') return 2;
        return -1; // will never be returned
    }

    public static void operation(Stack<String> val, Stack<Character> op){
        String v2 = val.pop();
        String v1 = val.pop();
        char o = op.pop();
        val.push(o+v1+v2);
    }

    private static String calculate(String s){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) val.push(String.valueOf(ch));
            else if(!Character.isDigit(ch) && ch != ' '){
                if(ch == '(') op.push(ch);
                else if(ch == ')') {
                    while (op.peek() != '(') operation(val, op);
                    op.pop();
                }else{ // + - * or /
                    while(!op.isEmpty() && op.peek() != '(' && precedence(ch) <= precedence(op.peek())) operation(val, op);
                    op.push(ch);
                }
            }
        }

        while(!op.isEmpty()) operation(val, op);

        return val.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid infix expression: ");
        String str = sc.nextLine();
        System.out.println("Prefix expression is: " + calculate(str));
    }
}
