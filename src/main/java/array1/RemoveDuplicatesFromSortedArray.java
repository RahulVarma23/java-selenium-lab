package array1;

import java.sql.SQLOutput;
import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {
	static int removeDuplicates(int [] array) {		
		int i=0; //slow pointer for unique array
		for(int j=1;j<array.length;j++) {
			if(array[i] !=array[j]) {
				i++;
				array[i]=array[j];
			}			
		}
		return i+1;
	}
	
	static int removeDuplicates1(int [] array) {		
		HashSet<Integer> hs = new HashSet<Integer>();	
		for(int num : array) {
			hs.add(num);
		}	
		System.out.println(hs);
		return hs.size();
	}
		
	public static void main(String[] args) {
		int [] arr = {1, 1, 2, 2, 3, 4, 5, 5};
		int newLength = removeDuplicates(arr);
		for(int i=0;i<newLength;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
