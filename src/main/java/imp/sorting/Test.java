package imp.sorting;

public class Test {

    public int subarraySum(int[] nums, int k) {
        int count =0;

        for(int i=0;i<nums.length;i++) {
            int sum =0;
            for(int j=i;j<nums.length;j++) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,-1,1,2};
        int k = 2;

        Test t = new Test();
        System.out.println(t.subarraySum(arr, k));
    }
}
