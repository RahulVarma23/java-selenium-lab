package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int [] arr = {1,-1,1,-1,1,-1};
        System.out.println(fourSum(arr,2));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-3;i++) {
            for(int j=i+1;j<n-2;j++) {
                int start = j+1;
                int end =n-1;

                while(start<end) {
                    int sum = nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[start],nums[end]));
                        start++;
                        end--;
                    }else if(sum<target) {
                        start++;
                    }else {
                        end--;
                    }
                }
            }
        }
        return list;
    }
}
