package imp.array;

public class ReverseNumbers {

	public static void main(String[] args) {	
		System.out.println(reverseNum(12345));
		int num = 12345;
		int answer = reverseNum(num);	
		if(num==answer) {
			System.out.println("Given integer is polindrome");
		}else {
			System.out.println("Given integer is NOT polindrome");
		}
	}

	private static int  reverseNum(int num) {	
		int reverse =0;
		while(num>0) {
			int rem = num %  10;
			reverse = reverse*10 + rem;
			num = num / 10;
		}
		return reverse;
	}
}
