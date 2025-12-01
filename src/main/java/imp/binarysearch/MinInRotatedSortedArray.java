package imp.binarysearch;

public class MinInRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = {3,4,5,6,1,2};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low=0;
        int high=nums.length-1;

        // Continue until the search space is exhausted
        while(low<=high) {
            int mid = low + (high-low)/2;

            if(nums[low]<=nums[mid]) {   // if left sorted
                min = Math.min(min, nums[low]); // The smallest value in this sorted part is at 'low'
                low = mid+1;            // Move search to the right half
            }else {                     //right sorted
                min = Math.min(min, nums[mid]);   // The smallest value could be at 'mid'
                high = mid-1;      // Move search to the left half
            }
        }
        return min;
    }
}
