package imp.array;

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

    // Function to calculate minimum number of swaps required to sort the array
	public static void main(String[] args) {
		int [] arr = {1,4,3,2,7,5};

        //logic: create a sorted copy of the array and
        // map to store the index of each element in the sorted array

		int [] a = arr.clone();
		Arrays.sort(a);
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<a.length;i++) {
			map.put(a[i], i);
		}
		
		int count =0;
		for(int i=0;i<arr.length;i++) {
			while(map.get(arr[i])!=i){           //if the element is not at its correct position
				count++;                         //increment swap count
				swap(arr,i,map.get(arr[i]));     //swap the element with the element at its correct position
			}
		}	
		System.out.println(count);
	}
}
