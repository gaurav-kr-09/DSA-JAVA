package Stacks.Fixes.Infix;

import java.util.Stack;

public class InfixWOBraces {
    public static void main(String[] args) {
//        String str = "9-5+3*4/6"; // Ans-> 6
        String str = "8-5+3*4/6"; // Ans-> 5

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>(); // is stack me high priority wala niche nahi rah sakta

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) val.push(ascii-48);
            else if (op.isEmpty()) op.push(ch);
            else{
                if(ch == '+' || ch == '-'){ // ye dono ka priority hamesha kam hi hoga isiliye iska calculation pahle hi kar sakte hai
                    int v2 = val.pop();
                    int v1 = val.pop();

                    if(op.peek() == '+') val.push(v1+v2);
                    else if(op.peek() == '-') val.push(v1-v2);
                    else if(op.peek() == '*') val.push(v1*v2);
                    else if(op.peek() == '/') val.push(v1/v2);

                    op.pop(); // jiska calculation ho gya hai usko hatao
                    op.push(ch); // naya wala operator push karo
                }
                if(ch == '*' || ch == '/'){ // in logo ka priority jyada hai, isiliye ye log stack me top par hi rhega ya nahi rhega
                    if(op.peek() == '*' || op.peek() == '/'){ // Agar same priority ka element hai
                        int v2 = val.pop();
                        int v1 = val.pop();

                        if(op.peek() == '*') val.push(v1*v2);
                        else if(op.peek() == '/') val.push(v1/v2);

                        op.pop(); // jiska calculation ho gya hai usko hatao
                        op.push(ch); // naya wala operator push karo
                    }else{ // matlab iske niche kam prioriy wala hai to ye log uske top pe aa sakta hai
                        op.push(ch);
                    }
                }
            }
        }

        // val stack ka size 1 se bada hai
        while(val.size() > 1){
            int v2 = val.pop();
            int v1 = val.pop();

            if(op.peek() == '+') val.push(v1+v2);
            else if(op.peek() == '-') val.push(v1-v2);
            else if(op.peek() == '*') val.push(v1*v2);
            else if(op.peek() == '/') val.push(v1/v2);

            op.pop(); // jiska calculation ho gya hai usko hatao
        }

        System.out.println("Result is: "+ val.peek());
    }
}