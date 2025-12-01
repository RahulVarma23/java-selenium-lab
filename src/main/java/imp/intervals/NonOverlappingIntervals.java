package imp.intervals;

import java.util.*;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length<=1) {
            return 0;
        }

        //Sort intervals by end time, then greedily keep the interval that ends earliest.
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));

        int prevEnd = intervals[0][1]; // end of the last included interval
        int count=0;
        int i=1;

        while(i<intervals.length) {
            // If current interval overlaps with previous chosen one
            if(intervals[i][0]<prevEnd) {
                count++;  // remove this interval
            }else {
                prevEnd = intervals[i][1]; // keep it and update end
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] [] intervals = {{1,2},{2,4},{1,4}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
