package imp.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombination {

    /*
    Input: digits = "34"
    Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]
     */

    public static void main(String[] args) {
        String digits = "34";
        PhoneLetterCombination pc = new PhoneLetterCombination();
        System.out.println(pc.letterCombinations(digits));
    }

    private List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // Create the digit → letters map
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(result, new StringBuilder(), digits, map , 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, Map<Character, String> map, int index) {
        if(index==digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));

        for(char ch: letters.toCharArray()) {
            current.append(ch);
            backtrack(result, current, digits, map , index+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
