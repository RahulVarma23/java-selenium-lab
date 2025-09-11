package stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack <Character> s = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c=='(' || c=='[' ||c=='{') {
                s.push(c);
            }else {
                if (s.isEmpty()) {
                    return false;
                }
                char top = s.peek();
                if((c=='}' && top=='{') || (c==']' && top=='[') || (c==')' && top=='(')) {
                    s.pop();
                }else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
	
	public static void main(String[] args) {
		System.out.println(isValid("[()]{}{[()()]()}"));
	}
}
