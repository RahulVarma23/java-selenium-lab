package imp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5};
        int target = 16;

        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(nums,target));
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        backtrack(result, currentSet, nums, target, 0);

        return result;
    }

    //0(2^n) , sc : O(n)
    private void backtrack(List<List<Integer>> result, List<Integer> currentSet, int[] nums, int target, int start) {
        // Stop exploring if target < 0
        if(target<0) return;

        // Base case: we found a valid combination
        if(target==0) {
            result.add(new ArrayList<>(currentSet));
            return;
        }

        // Try all candidates starting from "start"
        for(int i=start;i<nums.length;i++) {
            currentSet.add(nums[i]);
            // Reduce target by nums[i]
            backtrack(result, currentSet, nums,target-nums[i], i);  // i, not i+1 (reuse allowed)
            // Backtrack
            currentSet.remove(currentSet.size()-1);
        }
    }
}
