package imp.binarysearch;

public class SearchInsertPosition {

    static int searchInsertPosition(int [] arr , int target) {
        int n = arr.length;
        // Default insert position = length of array
        //  (i.e., if target is greater than all elements, insert at the end)
        int ans = n;
        int low=0;
        int high =n-1;

        //Standard binary search loop
        while(low<=high) {
            int mid = (low+high)/2;

            //If mid element is greater than or equal to target,
            //it could be the correct insert position (or we can find a smaller one to the left)
            if(arr[mid]>=target) {
                ans = mid;  // Update possible insert position
                high = mid-1;  // Move left to find smaller valid position
            }else {
                low = mid+1;
            }
        }

        return ans;
    }




    public static void main(String[] args) {
        int [] input = {-1,0,2,4,6,8};
        int target =5;
        System.out.println(searchInsertPosition(input,target));
    }
}
