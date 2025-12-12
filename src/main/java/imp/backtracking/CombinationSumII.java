package imp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] nums = {9,2,2,4,6,1,5};
        int target = 8;

        CombinationSumII cs = new CombinationSumII();
        System.out.println(cs.combinationSum(nums,target));
    }

    //Each element from candidates may be chosen at most once within a combination
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(result, currentSet, nums, target, 0);

        return result;
    }

    //0(2^n) , sc : O(n)
    private void backtrack(List<List<Integer>> result, List<Integer> currentSet, int[] nums, int target, int index) {
        if(target<0) return;

        if(target==0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }

        for(int i=index;i<nums.length;i++) {
            if(i>index && nums[i] ==nums[i-1]) continue;

            currentSet.add(nums[i]);
            backtrack(result, currentSet, nums,target-nums[i], i+1);
            currentSet.remove(currentSet.size()-1);
        }

    }
}
