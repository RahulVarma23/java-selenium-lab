package imp.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    private static int[][] mergeIntervals(int[][] intervals) {
        if(intervals==null || intervals.length<=1) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i=1;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        result.add(intervals[0]);

        while(i<n) {
            int [] current = intervals[i];
            int [] lastMerged = result.get(result.size()-1);

            if(current[0]<=lastMerged[1]) { // Overlapping intervals — merge by updating the end
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            }else {
                result.add(current); // No overlap — add as a new interval
            }
            i++;
        }
        return result.toArray(new int [result.size()][]);
    }

    public static void main(String[] args) {
        int [] [] intervals = {{1,3},{1,5},{6,7}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }
}
