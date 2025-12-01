package imp.intervals;

import java.util.*;

public class MeetingRoom {



     public static class Interval {
         public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
         }
      }

    public boolean canAttendMeetings(List<Interval> intervals) {
         if(intervals.size()<=1 ) {
             return true;
         }

         //sort with start time
        intervals.sort(Comparator.comparingInt(a -> a.start));

         for(int i=1;i<intervals.size();i++) {
             if(intervals.get(i).start <= intervals.get(i-1).end) {
                 return false;
             }
         }
         return true;
    }


    public static void main(String[] args) {
        MeetingRoom sol = new MeetingRoom();

        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        ));

        System.out.println(sol.canAttendMeetings(intervals)); // false

        List<Interval> intervals2 = new ArrayList<>(Arrays.asList(
                new Interval(5, 8),
                new Interval(9, 5)
        ));
        System.out.println(sol.canAttendMeetings(intervals2)); // true
    }
}
