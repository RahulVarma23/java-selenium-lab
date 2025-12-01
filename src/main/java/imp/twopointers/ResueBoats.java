package imp.stack.twopointers;

import java.util.Arrays;

/*
You are given an integer array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
Return the minimum number of boats to carry every given person.
Input: people = [5,1,4,2], limit = 6

Output: 2
Explanation:
First boat [5,1].
Second boat [4,2].
 */
public class ResueBoats {

    public static int numRescueBoats(int[] people, int limit) {
        //1,3,2,3,2
        int boats=0;
        Arrays.sort(people);

        int i=0;
        int j=people.length-1;

        while(i<=j) {
            if(people[i]+people[j]<=limit) {
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        int [] people = {1,3,2,3,2};
        System.out.println(numRescueBoats(people, 3));
    }
}
