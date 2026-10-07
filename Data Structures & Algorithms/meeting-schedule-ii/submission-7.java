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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0)
            return 0;

        intervals.sort((a, b) -> {
            if(a.start  != b.start)
                return a.start - b.start;
            else
                return a.end - b.end;
        } ); // ascending order of start time

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval i : intervals){

            if(!minHeap.isEmpty() && minHeap.peek() <= i.start){ // imp
                minHeap.poll();
            }

            minHeap.offer(i.end);
        }

        return minHeap.size();
    }
}
