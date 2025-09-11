package array1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MissingNumber {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,6,7};
        int n = arr.length+1;

        int actualSum = (n*(n+1))/2;
        System.out.println(actualSum);

        int sum = Arrays.stream(arr).sum();

        System.out.println("Missing num: "+ (actualSum-sum));
    }
}
