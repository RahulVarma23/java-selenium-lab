package imp.mathandgeometry;

public class PlusOne {

    /*
    [1,2,3] -> [1,2,4]
    [9,9,9] -> [1,0,0,0]
    */

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=n-1;i>=0;i--) {
            // If the current digit is less than 9, just add one and return
            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, it becomes 0 (carry over to the next digit)
            digits[i]=0;
        }

        //if we reach here all digits are 9. e.g 999->1000
        int [] newDigits = new int[n+1];
        newDigits[0]=1;

        return newDigits;
    }




}
