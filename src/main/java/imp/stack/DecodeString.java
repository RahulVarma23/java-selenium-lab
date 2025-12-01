package imp.stack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString decoder = new DecodeString();
        String input = "10[a2[c]]";
        System.out.println(decoder.decodeString(input));
    }

    private String decodeString(String input) {
        Stack<Integer> countStack = new Stack<>();  // stack to hold repeat counts
        Stack<String> stringStack = new Stack<>();  // stack to hold strings
        String current = "";
        int k=0;

        for(char ch: input.toCharArray()) {
            if(Character.isDigit(ch)) {
                k=k*10+(ch-'0');            // to handle multi-digit numbers
            }else if(ch=='[') {
                countStack.push(k);         // push the current count to stack
                stringStack.push(current);  // push the current string to stack
                current = "";               // reset current string
                k=0;                        // reset k
            }else if(ch==']') {
                int repeatTimes = countStack.pop();    // pop the repeat count
                StringBuilder temp = new StringBuilder(stringStack.pop()); // pop the last string
                for(int i=0;i<repeatTimes;i++) {
                    temp.append(current);
                }
                current = temp.toString();      // update current string
            }else {
                current+=ch;
            }
        }
        return current;
    }
}
