package imp.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"}; // ((2 + 1) * 3) = 9
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        if(tokens.length==0 ) return 0;
        if(tokens.length==1 ) return Integer.parseInt(tokens[0]);

        Stack<Integer> s = new Stack<>();
        int result=0;

        for(String token : tokens ) {
            if(isOperator(token)) {
                int b = s.pop();
                int a = s.pop();
                result = performOperation(a,b, token);
                s.push(result);
            }else {
                s.push(Integer.parseInt(token));
            }
        }
        return result;
    }

    private static int performOperation(int a, int b, String token) {
        switch (token) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                 throw new RuntimeException("Illegal operator..");
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
