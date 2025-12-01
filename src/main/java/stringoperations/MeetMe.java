package stringoperations;

import java.util.List;

public class MeetMe {
	public static void main(String[] args) {	
		List<String> words = List.of("meet","meet-me","implement","mango");
		int count=0;
		for (String word: words) {
			if(!word.contains("me")) {
				System.out.print(word+",");
			}
			while(word.contains("me")) {
				word=word.replaceFirst("me", "");
				count++;
			}
		}
		System.out.println(count);
	}
}
