package Stacks.Fixes.Infix;

import java.util.Scanner;
import java.util.Stack;

public class InfixOptimized {
    static Stack<Integer> val = new Stack<>();
    static Stack<Character> opr = new Stack<>();

    public static boolean isNum(char ch){
        return ch >= '0' && ch <= '9';
    }

    public static int priority(char ch) throws Exception{
        switch (ch){
            case '+', '-': return 1;
            case '*', '/': return 2;
            default: throw new Exception("Invalid input");
        }
    }

    public static void calculate(){
        int v2 = val.pop();
        int v1 = val.pop();
        char op = opr.pop();

        switch(op){
            case '+': val.push(v1 + v2); break;
            case '-': val.push(v1 - v2); break;
            case '*': val.push(v1 * v2); break;
            case '/': val.push(v1 / v2); break;
        }
    }

    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a valid infix expression (Without space only digits allowed): ");
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(isNum(ch)) val.push(ch-'0');
            else{
                if(opr.isEmpty() || ch == '(' || opr.peek() == '(') opr.push(ch);
                else if(ch == ')'){
                    while(opr.peek() != '('){
                        calculate();
                    }
                    opr.pop(); // To remove "("
                }else {
                    if(priority(opr.peek()) >= priority(ch)) calculate();
                    opr.push(ch);
                }
            }
        }

        while (val.size() > 1) calculate();

        System.out.println("Answer is: "+ val.pop());
    }
}
