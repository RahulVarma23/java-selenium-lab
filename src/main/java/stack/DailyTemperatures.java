package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    private static int[] dailyTemperatures(int [] temperatures) {
        int n = temperatures.length;
        int [] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(!s.isEmpty() && temperatures[s.peek()]<= temperatures[i]) {
                s.pop();  //if current temp is greater pop until we find greater temp
            }
            if(s.isEmpty()) {
                ans[i]=0;  //no greater temp found
            }else{
                ans[i] = s.peek()-i;  //index difference to next greater temp
            }
            s.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
}
