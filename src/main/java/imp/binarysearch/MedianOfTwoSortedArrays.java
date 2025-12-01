package imp.binarysearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {2, 4 ,9};
        int[] nums2 = {8, 10, 12};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    //The trick here is to find a partition point that divides both arrays into equal halves.
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) { //ensuring nums1 is the smaller array
            return findMedianSortedArrays(nums2, nums1);
        }

        int m=nums1.length;
        int n=nums2.length;

        int low=0; int high=m; //binary search on smaller array

        while(low<=high) {

            /*
            Px → number of elements on the left side from nums1
            Py → number of elements on the left side from nums2
             */
            int Px = low + (high-low)/2;  //partition index for nums1
            int Py = (m+n+1)/2-Px;        //partition index for nums2 based on Px

            int x1 = (Px==0) ? Integer.MIN_VALUE: nums1[Px-1]; //left max of nums1
            int x2 = (Py==0) ? Integer.MIN_VALUE : nums2[Py-1]; //left max of nums2

            int x3 = (Px==m) ? Integer.MAX_VALUE : nums1[Px];   //right min of nums1
            int x4 = (Py==n) ? Integer.MAX_VALUE : nums2[Py];   //right min of nums2

            if(x1<=x4 && x2<=x3) {  //correct partition found
                 //calculate median
                if((m+n) % 2 ==0) {
                    return (Math.max(x1,x2) + Math.min(x3,x4))/2.0; //even length
                }
                return Math.max(x1,x2); //odd length
            }

            //if left max of nums1 is greater than right min of nums2, move partition left
            if(x1>x4) {
                high = Px-1;  // too far right → move left
            }else {
                low = Px+1;  // too far left → move right
            }
        }
        return -1;
    }
}
