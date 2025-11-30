package array2;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwaps {
	
	public static void swap(int [] nums , int start, int end) {
		while(start<end) {
		    int temp = nums[start];
		    nums[start] = nums[end];
		    nums[end] = temp;	
		    start++;
		    end--;
		}
	}

	public static void main(String[] args) {
		int [] arr = {1,4,3,2,7,5};
		
		int [] a = arr.clone();
		Arrays.sort(a);
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<a.length;i++) {
			map.put(a[i], i);
		}
		
		int count =0;
		for(int i=0;i<a.length;i++) {
			while(map.get(arr[i])!=i){
				count++;
				swap(arr,i,map.get(arr[i]));
			}
		}	
		System.out.println(count);
	}
}
