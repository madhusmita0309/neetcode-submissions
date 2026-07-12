class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            maxHeap.offer(s);
        }

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x == y){
               continue;
            }
            x = x - y;
            maxHeap.offer(x);

        }
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
     }
}
