package imp.stack.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
     //   int [] height = {1,8,6,2,5,4,8,3,7};
        int [] height = {1,1};
        System.out.println(findMaxArea(height));
    }

    public static int findMaxArea(int [] height) {
       int max =0;
       int l =0;
       int r = height.length-1;

       while(l<r) {
           int lh = height[l];
           int rh = height[r];
           int minh= Math.min(lh, rh);

           max = Math.max(max, (r-l)*minh);

           if(lh<rh) {
               l++;
           }else {
               r--;
           }
       }
       return max;
    }
}
