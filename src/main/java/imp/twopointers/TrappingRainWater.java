package imp.stack.twopointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] arr = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(findTrappedWater(arr));
    }

    private static int findTrappedWater(int [] height) {
        int ans =0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;

        while(left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax<rightMax) {
                ans+=leftMax-height[left];
                left++;
            } else {
                ans+=rightMax-height[right];
                right--;
            }
        }

        return ans;
    }
}
