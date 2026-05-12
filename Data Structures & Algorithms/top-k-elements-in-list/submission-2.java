class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // max heap ordered by frequency of nums
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));// a[0] - number, a[1] - frequency

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry:  freqMap.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
