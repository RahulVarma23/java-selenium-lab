package stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(generateParantheses(n, 0,0));
    }

    private static List<String> generateParantheses(int n, int open , int close) {
        List<String> result =  new ArrayList<>();
        backtrack("", result, open, close, n);
        return result;
    }

    private static void backtrack(String curr, List<String> result , int open, int close, int n) {
        if(open + close == 2*n) {
            result.add(curr);
            return;
        }

        if(open<n) {
            backtrack(curr+"(", result, open+1, close, n);
        }

        if(close<open) {
            backtrack(curr+")", result, open, close+1, n);
        }
    }
}
