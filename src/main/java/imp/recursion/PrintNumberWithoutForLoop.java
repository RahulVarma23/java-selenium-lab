package imp.recursion;

public class PrintNumberWithoutForLoop {
	
	public static void print(int start , int end) {
		System.out.println(start);
		start++;
		if(start<=end) {
			print(start,end);
		}
	}

	public static void main(String[] args) {
		print(1,100);
	}
}
