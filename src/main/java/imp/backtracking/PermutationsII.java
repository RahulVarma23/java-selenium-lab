package imp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII subsets = new PermutationsII();
        int[] nums = {1, 2, 2}; //duplicate elements
        System.out.println(subsets.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        Arrays.sort(nums); //sorting allows us to properly skip duplicates
        backtrack(result, nums , currentSubset , new boolean[nums.length]);

        return result;
    }

    //tc: O(n*n!), sc: O(n) , total permutations = n!
    private void backtrack(List<List<Integer>> result,int[] nums,  List<Integer> currentSubset, boolean[] used) {
        if(currentSubset.size()==nums.length) {
           result.add(new ArrayList<>(currentSubset));
           return;
       }

        for(int i=0;i< nums.length;i++) {
            if(used[i]) continue;    //skip if we get already chosen number


            // ⭐ Skip duplicates: only allow the first unused duplicate
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;

            //add new element and mark it as used
            used[i] = true;

            currentSubset.add(nums[i]);  //chose
            backtrack(result,nums, currentSubset, used); //explore
            currentSubset.remove(currentSubset.size()-1); //unchoose

            used[i] = false;
        }
    }
}
