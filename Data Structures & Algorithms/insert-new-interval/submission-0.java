class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        for(int interval[] : intervals){
            if(newInterval == null || interval[1] < newInterval[0]){
                result.add(interval); // adding existing interval, not adding new interval
            }else if(interval[0] > newInterval[1]){
                result.add(newInterval); // add new interval in the begining / before existing interval
                result.add(interval); 
                newInterval = null;
            }else{
                // merging interval
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);

            }
        }

        if(newInterval != null) // adding new interval at the end
            result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}
