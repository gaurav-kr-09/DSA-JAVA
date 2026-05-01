package Stacks.Fixes;

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    // Method 1: using Stringbuilder
    /*static int i = 0;
    private static String decodedStr(String s) {
        int num = 0;
        StringBuilder ans = new StringBuilder();
        while(i < s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
                i++;
            }
            else if(ch == '['){
                i++;
                String temp = decodedStr(s);
                for(int j = 0; j < num; j++) ans.append(temp);
                num = 0;
            }else if(ch == ']'){
                i++;
                return ans.toString();
            }else{ // alphabet
                ans.append(ch);
                i++;
            }
        }
        return ans.toString();
    }*/

    // Method 2: using two stacks
    private static String decodedStr(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                // pushing the pichhe wala number in numberStack
               numStack.push(num);
               num = 0;
               // pushing the char in stringStack
               stringStack.push(String.valueOf(ch));
            }else if (ch != ']'){ //pushing other chars in stringStack
                stringStack.push(String.valueOf(ch));
            }else{ // ']' case
                StringBuilder temp = new StringBuilder();
                // getting the string jisko repeat karna hai,
                // since ulta traverse kar rhe hai isiliye 0th index pe insert kiye
                while (!stringStack.peek().equals("[")) temp.insert(0, stringStack.pop());

                // remove '['
                stringStack.pop();

                //repeat the required no. of times
                StringBuilder repeated = new StringBuilder();
                int count = numStack.pop();

                for (int i = 0; i < count; i++) {
                    repeated.append(temp);
                }

                // add the repeated to stringStack
                stringStack.push(repeated.toString());
            }
        }

        StringBuilder ans = new StringBuilder();
        // For cases like a2[b]3[c] we are appending at start
        while(!stringStack.isEmpty()) ans.insert(0, stringStack.pop());

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter valid string a/c to qn: ");
        String str = sc.nextLine();
        System.out.println("Answer is: " + decodedStr(str));
    }
}