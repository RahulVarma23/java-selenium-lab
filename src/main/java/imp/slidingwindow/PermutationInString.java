package imp.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "lecabee";
        System.out.println(checkInclusion(s1, s2));
    }

    private static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) {
            return false;    //✅ edge case
        }

        int [] count1 = new int[26]; //✅ frequency array for s1
        int [] count2 = new int[26]; //✅ frequency array for s2

        for(char ch : s1.toCharArray()) {
            count1[ch-'a']++;         //fill frequency array for s1
        }

        int left=0;
        int right=0;

        while(right<s2.length()) {
            count2[s2.charAt(right)-'a']++; //add right char to frequency array

            if(right-left+1 > s1.length()) {
                count2[s2.charAt(left)-'a']--;  //remove left char from frequency array
                left++;
            }

            if(Arrays.equals(count1, count2) && right-left+1==s1.length()) {
                return true;
            }
            right++;
        }
        return false;
    }
}
