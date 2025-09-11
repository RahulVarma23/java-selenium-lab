package twopointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] arr = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(getTrappedWater(arr));
        System.out.println(findTrappedWater(arr));
    }

    private static int getTrappedWater(int [] height) {
        int ans =0;
        int n = height.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i=0;i<n;i++) {
            ans+=Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
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
