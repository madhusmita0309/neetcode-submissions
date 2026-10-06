class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });
        
        List<int[]> result = new ArrayList();

        int[] newInterval = new int[2];
        for(int[] interval : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < interval[0]){
                result.add(interval);
            }
            else if(result.get(result.size()-1)[1] >= interval[0]){
                // merge 
                result.get(result.size()-1)[0] = Math.min(interval[0], result.get(result.size()-1)[0]);
                result.get(result.size()-1)[1] = Math.max(interval[1], result.get(result.size()-1)[1]);
                
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
