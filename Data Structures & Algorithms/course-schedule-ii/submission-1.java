class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> prereqMap = new HashMap();
        for(int i=0; i<numCourses; i++){
            prereqMap.put(i, new ArrayList());
        }

        for(int[] p: prerequisites){
            int node = p[1]; int pre = p[0];
            prereqMap.get(node).add(pre); // adjacency list
        }

        List<Integer> result = new ArrayList();
        Set<Integer> visitedSet = new HashSet();
        Set<Integer> cycleSet = new HashSet();

        for(int i=0; i<numCourses; i++){
            if(!dfs(i, visitedSet, cycleSet, prereqMap, result))
                return new int[]{};
        }

        int[] output = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            output[i] = result.get(numCourses-1-i); // coz the most independent node is added last i.e with empty adj list

        }
        
        return output;
    }

    public boolean dfs(int c, Set<Integer> visitedSet, Set<Integer>  cycleSet, HashMap<Integer, List<Integer>> prereqMap, List<Integer> result){

        if(cycleSet.contains(c))
            return false; //cycle

        if(visitedSet.contains(c))
            return true; // already visited

        cycleSet.add(c); // pre req in the path
        for(int pre: prereqMap.get(c)){
            if(!dfs(pre, visitedSet, cycleSet, prereqMap, result))
                return false;
        }

        cycleSet.remove(c); 
        visitedSet.add(c);
       
        result.add(c);

        return true;

    }
}
