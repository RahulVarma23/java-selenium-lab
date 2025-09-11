package string.problems;

public class CalculateVowels {

	public static void main(String[] args) {
		System.out.println(calculateVowels("rahulvarma"));;
	}

//	private static int CalculateVowels(String string) {
//		char [] ch = string.toLowerCase().toCharArray();
//		int count =0;
//		for(char c : ch) {
//			if((c == 'a') || (c == 'e')||(c == 'i')||(c == 'o')||(c == 'u'))  {
//				count++;
//			}
//		}
//		return count;
//	}

    private static int calculateVowels(String string) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (char c : string.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
