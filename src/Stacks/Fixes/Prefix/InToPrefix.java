package Stacks.Fixes.Prefix;

import java.util.Stack;

public class InToPrefix {
    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        // 9- +53 *4/6
        // 9- *+534 /6
        // 9- /*+5346
        // -9/*+5346 Answer

        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if(Character.isDigit(ch)) val.push(String.valueOf(ch));
            else if(op.isEmpty() || ch == '(' || op.peek() == '(') op.push(ch);
            else if(ch == ')'){
                while(op.peek() != '('){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                }
                op.pop(); // to pop '('
            }else{
                if(ch == '+' || ch == '-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);

                    op.push(ch);
                }

                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);

                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }

        while(!op.isEmpty()){
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = o + v1 + v2;
            val.push(t);
        }

        System.out.println("Infix is: "+ infix);
        System.out.println("Prefix is: "+ val.pop());
    }
}