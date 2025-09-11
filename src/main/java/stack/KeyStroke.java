package stack;

import java.util.Stack;

public class KeyStroke {

    /*Given two strings s and t, which represents a sequence of keystrokes, where # denotes a backspace, return whether or not the sequences produce the same result.

            Ex: Given the following strings...

    s = "ABC#", t = "CD##AB", return true
    s = "como#pur#ter", t = "computer", return true
    s = "cof#dim#ng", t = "code", return false
     */
    public static String processString(String input) {

        if(input == null || input.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c: input.toCharArray()) {
            if(c=='#' && !stack.isEmpty()) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        for(char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        if(processString("como#pur#ter").equals(processString("computer"))) {
            System.out.println("identical");
        }else {
            System.out.println("non identical");
        }
    }
}
