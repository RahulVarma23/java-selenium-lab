package imp.recursion;
public class RemoveOccuranceUsingRecursion {
	public static void main(String[] args) {
		System.out.println(removeOccurances("AWAWSSGT","AWS"));
	}

	private static String removeOccurances(String s1, String s2) {

        while(s1.contains(s2)) {
            s1=s1.replaceFirst(s2, "");
        }
		
		return s1;
	}
}
