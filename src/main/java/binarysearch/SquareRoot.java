package binarysearch;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(26));
    }

    private static int mySqrt(int x) {
        int ans =1;
        int low = 1;
        int high = x;

        while(low<=high) {

            // Find the middle point (use long to prevent integer overflow)
            long mid = (low+high)/2;

            // Compute mid²
            long val = mid*mid;

            if(val<=x) {
                ans = (int) mid; // Store current mid as the best possible answer so far
                low = (int) mid+1; // Move right to check if there’s a larger valid value
            }else {
                high = (int) mid-1;
            }
        }
        return ans;
    }
}
