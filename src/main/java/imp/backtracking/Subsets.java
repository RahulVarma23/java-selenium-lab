package imp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3}; //all unique elements
        System.out.println(subsets.subsets(nums));
    }

    //total subsets = 2^n, TC : O(n*2^n), SC: O(n)
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(result, nums , currentSubset, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> currentSubset, int start) {
        result.add(new ArrayList<>(currentSubset));

        for(int i=start;i< nums.length;i++ ) {
            currentSubset.add(nums[i]);  //chose
            backtrack(result, nums, currentSubset, i+1); //explore
            currentSubset.remove(currentSubset.size()-1); //unchoose
        }
    }

}
