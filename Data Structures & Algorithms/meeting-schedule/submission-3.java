/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty())
            return true;
        if(intervals == null)
            return true;
        Collections.sort(intervals, (a, b) -> {
            if(a.start == b.start)
                return a.end - b.end;
            else
                return a.start - b.start;
        });

        boolean ans = true;
        Interval temp = new Interval(intervals.get(0).start, intervals.get(0).end);
        
        int i = 1;
        while( i < intervals.size() ){
            if(temp.end > intervals.get(i).start){
                ans = false;
                break;
            }
            temp = intervals.get(i);

            i++;
        }

        return ans;
    }
}
