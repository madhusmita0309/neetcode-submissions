class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // adj map of edges
        HashMap<Integer, List<int[]>> edges = new HashMap<>(); // u : <[v, w], [v2,w2]...> u= source v=dest w=weight
        for(int i=0; i<times.length; i++){
            edges.computeIfAbsent(times[i][0], temp -> new ArrayList<>()).add(new int[]{times[i][1], times[i][2]});
        }

        // min Heap [path cost, v] - path cost/time to reach v, v node
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        Set<Integer> visited = new HashSet(); // note which nodes have been visited
        minHeap.offer(new int[]{0, k}); // path, node
        int time = 0;

        while(!minHeap.isEmpty()){
            int currNode[] = minHeap.poll();
            int n1 = currNode[1]; int w1= currNode[0];
            if(visited.contains(n1)){
                continue;
            } // node n1 is not yet visited
                
            
            visited.add(n1); // visited n1 node now
            time =  w1; // shortest weight/ edge weight so far


            if(edges.containsKey(n1)){ // if there's any edge with n1 node
                for(int[] e : edges.get(n1)){
                    int n2 = e[0]; 
                    int w2 = e[1];
                    if(!visited.contains(n2)) 
                        // node n2 already visited or no
                        minHeap.offer(new int[]{w1 + w2, n2});
                    
                    
                }
            }
            

        }
        return visited.size() == n ? time : -1;

    }
}
