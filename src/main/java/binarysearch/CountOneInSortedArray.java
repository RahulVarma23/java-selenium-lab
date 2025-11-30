package binarysearch;

public class CountOneInSortedArray {

	public static void main(String[] args) {
		int [] nums = {0,0,1,1,1,1,1,1,1};
		int first = findPosition(nums,1,true);		
		int last = findPosition(nums,1,false);
		System.out.println(last-first+1);
	}

	static int findPosition(int [] arr , int target , boolean findFirstIndex) {		
		int start = 0;
		int end = arr.length-1;
		int ans =0;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(target<arr[mid]) {
				end = mid-1;
			}else if(target>arr[mid]) {
				start = mid+1;
			}else {
				 ans = mid;
			     if(findFirstIndex)
			    	 end = mid-1;
			     else
			    	 start = mid+1;		     
			}
		}
		return ans;
	}
}
