package imp.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int[] nums = {2, 1, 2}; //duplicate elements
        System.out.println(subsets.subsets(nums));
    }

    //total subsets = 2^n, TC : O(n*2^n), SC: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        Arrays.sort(nums); //sort to handle duplicates

        backtrack(result, nums, currentSubset, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> currentSubset, int start) {
       //if(result.contains(currentSubset)) return;

        result.add(new ArrayList<>(currentSubset));

        for(int i=start;i< nums.length;i++ ) {
            if(i>start && nums[i]==nums[i-1]) continue;

            currentSubset.add(nums[i]);  //chose
            backtrack(result, nums, currentSubset, i+1); //explore
            currentSubset.remove(currentSubset.size()-1); //unchoose
        }
    }

}
