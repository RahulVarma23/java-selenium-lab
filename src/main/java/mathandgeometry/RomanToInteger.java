package mathandgeometry;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        String input = "XLIX";

        Map<Character, Integer> roman  = new HashMap<>();
        roman.put('I' , 1);
        roman.put('V' , 5);
        roman.put('X' , 10);
        roman.put('L' , 50);

        int result = 0;
        int preValue=0;

        for(int i=input.length()-1; i>=0;i--) {
            int currentValue= roman.get(input.charAt(i));
            if(currentValue<preValue) {
                result-=currentValue;
            }else{
                result+=currentValue;
            }
            preValue=currentValue;
        }

        System.out.println(result);
    }
}
