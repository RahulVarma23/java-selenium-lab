package imp.stack;

import java.util.Stack;

/*Given a string s containing only lowercase letters, continuously remove
              adjacent characters that are the same and return the result.

        Ex: Given the following strings...

        s = "abccba", return ""
        s = "foobar", return "fbar"
        s = "abccbefggfe", return "a"

       */
public class AdjacentDuplicates {

      public static String removeAdjacentDuplicates(String s) {
            StringBuilder sb = new StringBuilder();
            Stack <Character> stack = new Stack<>();

            for(char c: s.toCharArray()) {
                  if( !stack.isEmpty() && stack.peek()==c) {
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
            System.out.println(removeAdjacentDuplicates("foobar"));
      }
}
