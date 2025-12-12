package imp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

    public static void main(String[] args) {
        PermutationsOfString subsets = new PermutationsOfString();
        String s = "abc"; //all unique elements
        System.out.println(subsets.permute(s));
    }


    public List<String> permute(String s) {

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(result, s.toCharArray(), current, new boolean[s.length()]);

        return result;
    }

    //tc: O(n*n!), sc: O(n) , total permutations = n!
    private void backtrack(List<String> result, char [] chars , StringBuilder current, boolean[] used) {
        if(current.length()==chars.length) {
            result.add(current.toString());
            return;
        }

        for(int i=0;i< chars.length;i++) {
            if(used[i]) continue;    //skip if we get already chosen character

            //add new element and mark it as used
            used[i] = true;

            current.append(chars[i]);  //chose
            backtrack(result,chars, current, used); //explore
            current.deleteCharAt(current.length()-1); //unchoose

            used[i] = false; //mark it as unused
        }
    }

    //tc: O(n*n!), sc: O(n) , total permutations = n!
    private void backtrack(List<String> result, char [] chars , StringBuilder current) {
        if(current.length()==chars.length) {
            result.add(current.toString());
            return;
        }

        for(int i=0;i< chars.length;i++) {
            char ch = chars[i];
            //skip if we get already chosen number
            if(current.indexOf(String.valueOf(ch)) !=-1) continue;

            current.append(ch);  //chose
            backtrack(result,chars, current); //explore
            current.deleteCharAt(current.length()-1); //unchoose
        }
    }
}
