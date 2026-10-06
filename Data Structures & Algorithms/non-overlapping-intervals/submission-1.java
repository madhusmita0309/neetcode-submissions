class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        int prevEnd = intervals[0][1];
        int i = 1; int overlap = 0;
        while(i < intervals.length){
            if(prevEnd > intervals[i][0]){
                // merge
                overlap++;
                prevEnd = Math.min(prevEnd, intervals[i][1]); // update min end interval
            }else{
                prevEnd = intervals[i][1];
            }
            i++;
        }

        return overlap;
    }
}
