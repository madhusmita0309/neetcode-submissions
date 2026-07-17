class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countChar = new int[26];
        for(char c: tasks){
            countChar[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // frequency
        Queue<int[]> q = new ArrayDeque<>(); // frequency, timeInstant when available

        for(int i=0; i<26; i++){
            if(countChar[i] > 0)
                maxHeap.offer(countChar[i]);
        }

        int time=0;
        while(!q.isEmpty() || !maxHeap.isEmpty()){
            time++;

           if(maxHeap.isEmpty()){
                time = q.peek()[1];
           }else{
                int temp = maxHeap.poll();
                if(temp - 1 > 0){
                    q.offer(new int[]{temp - 1, time+n});
                    
                }  
           }

           if(!q.isEmpty() && q.peek()[1] == time){
                
                maxHeap.add(q.poll()[0]);
            
           }

        }

        return time;

    }
}
