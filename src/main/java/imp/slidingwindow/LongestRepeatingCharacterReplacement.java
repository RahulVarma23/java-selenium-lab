package imp.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABCC", 2));
    }

    private static int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int [] freq = new int[26]; //to store frequency of chars in current window
        int maxFrequency = 0;   //to store max frequency of a single char in current window
        int maxWindow = 0;      //to store max window size found so far

        //no of characters to be replaced = windowSize - maxFrequency -> e.g 5 - 3 = 2
        //windowSize = right-left+1

        while(right<s.length()) {
            freq[s.charAt(right)-'A']++;   //increase frequency of right char
            maxFrequency = Math.max(maxFrequency,freq[s.charAt(right)-'A']); //update max frequency in current window

            int windowSize = right-left+1;

            if(windowSize-maxFrequency>k) {   //if search space exceeds k , shrink from left
                freq[s.charAt(left)-'A']--;  //decrease frequency of left char
                left++;
            }

            maxWindow = Math.max(right-left+1, maxWindow);
            right++;
        }
        return maxWindow;
    }
}
