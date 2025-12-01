package imp.binarysearch;

public class BinarySearch {
	
	public static int binarySearchRec(int [] array ,int target ,int left ,int right) {	
		if(right<left)
			return -1;	
		int middle = (left + right )/2;
		
		if(array[middle] == target)
			return middle;
		
		if(target>array[middle])
			return binarySearchRec(array,target,middle+1,right);
			
		return binarySearchRec(array,target,left,middle-1);
	}
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		int index =binarySearchRec(arr,4,0,arr.length-1);
		System.out.println(index);
	}
}
