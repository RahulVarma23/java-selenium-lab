package interview3;

import java.util.HashMap;
import java.util.Map;

public class CanFormPolindrome {

    public static void main(String[] args) {
        boolean f =canFormPolindrome("computer");
        System.out.println(f);
    }

    private static boolean canFormPolindrome(String s) {
        Map<Character, Integer> map =  new HashMap<>();

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int oddCount =0;
        for(int count: map.values()) {
            if(count%2 !=0) {
                oddCount++;
            }
        }
        return oddCount<=1;
    }
}
