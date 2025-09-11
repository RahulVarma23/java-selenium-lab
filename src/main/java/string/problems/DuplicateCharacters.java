package string.problems;

import java.util.HashSet;

//output:tec
public class DuplicateCharacters {

	public static void main(String[] args) {
		String s = "technocredits";	
		System.out.println(findDuplicate(s));
	}

	private static String findDuplicate(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		char[] ch = str.toCharArray();

		HashSet<Character> hs = new HashSet<>();
		String output = "";
		for (char c : ch) {
			if (!hs.add(c)) {
				output = c+output;
			}
		}
		return output;
	}
}
