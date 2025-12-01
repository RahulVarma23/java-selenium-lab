package imp.stack;

import java.util.Stack;

public class BracketMatching {
    public static void main(String[] args) {
        String input1 = "(coder)(byte))";
        String input2 = "(c(oder)) b(yte)";

        int result1 = isBracketMatched(input1);
        int result2 = isBracketMatched(input2);

        System.out.println("Output for input1: " + result1);
        System.out.println("Output for input2: " + result2);
    }

    public static int isBracketMatched(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return 0; // Mismatched brackets
                    }
                    break;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
