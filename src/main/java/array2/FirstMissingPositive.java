package array2;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int [] nums = {3, 4, -1, 1};
        System.out.println( firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //corrected index for nums[i] = nums[i] -1
        //hence swap i with nums[i] -1. its cyclic sort to place elements to desired position
        for(int i=0;i<n;i++) {
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1] !=nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        //1 = i +1  -> i=0
        //2 = i+1   -> i=1
        for(int i=0;i<n;i++) {
            if(nums[i] !=i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void swap(int [] arr , int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
