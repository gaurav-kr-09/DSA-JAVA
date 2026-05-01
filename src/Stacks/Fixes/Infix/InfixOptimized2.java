package Stacks.Fixes.Infix;

import java.util.Scanner;
import java.util.Stack;

public class InfixOptimized2 {
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
        System.out.print("Enter a valid infix expression: ");
        String str = sc.nextLine();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == ' ') continue;
            if(isNum(ch)) {
                int num = 0;
                while(i < str.length() && isNum(str.charAt(i))){
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--; // i ek aage chala gaya hoga usko pichhe karne ko
                val.push(num);
            }
            else{
                if(ch == '(') opr.push(ch);
                else if(ch == ')'){
                    while(opr.peek() != '('){
                        calculate();
                    }
                    opr.pop(); // To remove "("
                }else {
                    while(!opr.isEmpty() && opr.peek() != '(' && priority(opr.peek()) >= priority(ch)) calculate();
                    opr.push(ch);
                }
            }
        }

        while (val.size() > 1) calculate();

        System.out.println("Answer is: "+ val.pop());
    }
}