package imp.stack.twopointers;

import java.util.Arrays;

public class ReverseArrayInSet {
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8};
		System.out.println(reverseInSet(arr,3));
	}
	
	public static String reverseInSet(int [] arr , int set) {	
		for(int i=0;i<arr.length;i=i+set) {
			int start = i;
			int end = Math.min(i+set-1, arr.length-1);
			
			while(start<end) {		
				int temp = arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;	
			}		
		}
		return Arrays.toString(arr);
	}
}
