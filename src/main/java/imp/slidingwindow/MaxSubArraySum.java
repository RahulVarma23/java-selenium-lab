package imp.slidingwindow;

public class MaxSubArraySum {

    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1; // not enough elements

        int maxSum =Integer.MIN_VALUE;;
        int left=0;
        int right=0;
        int windowSum=0;

        while(right<arr.length) {
            windowSum += arr[right];

            if(right-left+1>k) {
                windowSum -= arr[left];
                left++;
            }

            maxSum = Math.max(maxSum, windowSum);
            right++;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + " is " + maxSumSubarray(arr, k));
    }
}
