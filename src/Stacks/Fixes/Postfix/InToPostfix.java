package Stacks.Fixes.Postfix;

import java.util.Stack;

public class InToPostfix {
    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        // 9- 53+ *4/6
        // 9- 53+4* /6
        // 9- 53+4*6/
        // 953+4*6/- Answer

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
                    String t = v1 + v2 + o;
                    val.push(t);
                }
                op.pop(); // to pop '('
            }else{
                if(ch == '+' || ch == '-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);

                    op.push(ch);
                }

                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek() == '/'){
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2 + o;
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
            String t = v1 + v2 + o;
            val.push(t);
        }

        System.out.println("Infix is: "+ infix);
        System.out.println("Postfix is: "+ val.pop());
    }
}