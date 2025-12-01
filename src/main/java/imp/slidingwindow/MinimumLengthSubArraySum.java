package imp.slidingwindow;

public class MinimumLengthSubArraySum {
    /*
    problem statement:
    Given an array of positive integers nums and a positive integer target,
    return the minimal length of contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
    of which the sum is greater than or equal to target. If there is no such sub
     */

    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int minLength = Integer.MAX_VALUE;
        int left =0;
        int right =0;
        int currentSum =0;

        while(right<n) {
            currentSum +=nums[right];
            while(currentSum>=target) {
                minLength = Math.min(minLength, right-left+1);
                currentSum -=nums[left];
                left++;
            }
            right++;
        }

        return (minLength==Integer.MAX_VALUE ? 0: minLength);
    }

    public static void main(String[] args) {
        MinimumLengthSubArraySum obj = new MinimumLengthSubArraySum();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(obj.minSubArrayLen(target, nums)); // Output: 2
    }

}
