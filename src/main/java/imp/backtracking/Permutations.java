package imp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations subsets = new Permutations();
        int[] nums = {1, 2, 3}; //all unique elements
        System.out.println(subsets.permute(nums));
    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(result, nums, currentSubset, new boolean[nums.length]);

        return result;
    }

    //tc: O(n*n!), sc: O(n) , total permutations = n!
    private void backtrack(List<List<Integer>> result, int[] nums , List<Integer> currentSubset, boolean[] used) {
        if(currentSubset.size()==nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        for(int i=0;i< nums.length;i++) {
            if(used[i]) continue;    //skip if we get already chosen number

            //add new element and mark it as used
            used[i] = true;

            currentSubset.add(nums[i]);  //chose
            backtrack(result,nums, currentSubset, used); //explore
            currentSubset.remove(currentSubset.size()-1); //unchoose

            used[i] = false; //mark it as unused
        }
    }


}
