package imp.intervals;

import java.util.*;

public class MeetingRoomII {

    public static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private int minMeetingRooms(List<Interval> intervals) {

        //sort on basis of start time
        intervals.sort(Comparator.comparingInt(a->a.start));

        //minheap to keep end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval: intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll(); //reuse same day
            }
            minHeap.add(interval.end);   //schedule at new day.
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomII sol = new MeetingRoomII();
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(0, 40),
                new Interval(5, 10),
                new Interval(15, 20)
        ));
        System.out.println(sol.minMeetingRooms(intervals));
    }
}
