package array2;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int [] arr = {2,3,-6,4,3,1};
        System.out.println(findMaxSubArraySum(arr));
    }

    private static int findMaxSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum =0;

        for(int num : arr) {
            currentSum+=num;
            maxSum = Math.max(maxSum, currentSum);

            //kadane's algorithm .if current sum reaches negative, just reset it to 0
            if(currentSum<0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
