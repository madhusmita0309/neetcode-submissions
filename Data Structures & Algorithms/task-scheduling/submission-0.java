class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char c: tasks){
            count[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        Queue<int[]> q = new ArrayDeque<>(); // frequency , time when task available

        for(int i =0; i<count.length; i++){
            if(count[i] > 0)
                maxHeap.offer(count[i]); // task frequency 
        }

        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(maxHeap.isEmpty()){
                // that means q has the only task to be scheduled
                time = q.peek()[1]; 
            }else{
                // that means heap has high freq elem that should be scheduled
                int f = maxHeap.poll() - 1;
                if(f > 0)
                    q.offer(new int[]{f, time + n});
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                // task in the queue can be scheduled
                maxHeap.add(q.poll()[0]);
            }

        }

        return time; 
    }
}
