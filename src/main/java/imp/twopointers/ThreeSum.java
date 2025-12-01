package imp.stack.twopointers;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4, 3, 4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int [] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1, r = n-1;
            while(l<r) {
                int sum = nums[i]+nums[l]+nums[r];

                if(sum<5){
                    l++;
                }else if(sum>5) {
                    r--;
                }else{
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r]==nums[r-1]) r--;

                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}
