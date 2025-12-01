package imp.stack;

/* Question 22: Write a java program to remove closest non-star character to its left, as well as remove star itself.
Return the string after all stars have been removed.
Input : abcd**cde*e  Output : abcde
Input : ****  Output : String has no character
Input : **asd*kk* Output : ask
*/

import java.util.*;


public class RemoveStarAndNonStar {

	public static void main(String[] args) {
		String s = "**asd*kk*";

		StringBuilder sb = new StringBuilder();

		Stack <Character> stack = new Stack<>();

		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);

			if(ch=='*' && !stack.isEmpty()) {
				stack.pop();
			}else{
				stack.push(ch);
			}
		}

		for(char c: stack){
			sb.append(c);
		}

		System.out.println(sb);
	}
}
