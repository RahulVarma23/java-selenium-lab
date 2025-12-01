package imp.binarysearch;

public class SearchPositionWithBinarySearch {
	
	static int searchFirstPosition(int [] input , int target) {
		int start =0;
		int end = input.length-1;
		int res = -1;
		if(input.length== 1 && input[0]!=target) {
			return -1;
	   }
			
		while(start<=end) {
			int mid = (start + end)/2;
			if(target > input[mid])
				start = mid+1;
			else if(target == input[mid]) {
				res = mid;
			    end = mid-1;
			}else
				end = mid-1;
		}
        return res;
	}
	
	static int searchLastPosition(int [] input , int target) {
		int start =0;
		int end = input.length-1;
		int res = -1;
			while(start<=end) {
				int mid = (start + end)/2;
				if(target > input[mid])
					start = mid+1;
				else if(target == input[mid]) {
					res = mid;
					start = mid+1;
				}else 
					end = mid-1;
			}
		return res;
	}
	
	public static int searchLastPosition1(int [] input, int target) {
		for(int i = input.length-1;i>=0;i--) {
			if(input[i]==target) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int [] input = {5,7,7,8,8,8};
		//int [] input = {1,8};
		System.out.println(searchFirstPosition(input,8));
		System.out.println(searchLastPosition(input,8));
	}
}
