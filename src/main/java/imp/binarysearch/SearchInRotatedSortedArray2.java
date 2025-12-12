package imp.binarysearch;

public class SearchInRotatedSortedArray2 {

    //rotated sorted array(not necessarily with distinct values)
    private static boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        //identify sorted half
        while(low<=high) {
            int mid = low + (high-low)/2;

            if(nums[mid]==target) {return true;}  //found target
            if(nums[low]==nums[mid] && nums[mid]==nums[high]) { //cannot determine which part is sorted
                    low++;               //shrink the search space
                    high--;              //shrink the search space
                    continue;
            }
            else if(nums[low]<=nums[mid]) {   //left sorted
                if(nums[low]<=target && target<=nums[mid]) {  //if target is in left sorted part
                    high = mid-1;                    //search in left part
                }else {
                    low = mid+1;                   //search in right part
                }
            }else {   //right sorted
                if(nums[mid]<=target && target<=nums[high]) {  //if target is in right sorted part
                    low=mid+1;                 //search in right part
                }else {
                    high = mid-1;                 //search in left part
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {3,4,4,5,6,1,2,2};
        int target =1;
        System.out.println(search(nums, target));
    }
}
